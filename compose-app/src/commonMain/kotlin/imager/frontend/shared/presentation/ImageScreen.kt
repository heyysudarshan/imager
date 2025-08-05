package imager.frontend.shared.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import imager.frontend.shared.extensions.backgroundContainerModifier
import imager.frontend.shared.extensions.profileImageModifier
import imager.frontend.shared.service.byArrayToImageBitmap

@Composable
fun ImageScreen() {
    val imageScreenViewModel = viewModel { ImageScreenViewModel() }

    val imageScreenUiState = imageScreenViewModel.uiState.collectAsState()
    val showUploadImageScreen = imageScreenUiState.value.showUploadImageScreen

    Column(modifier = Modifier.backgroundContainerModifier()) {
        when {
            showUploadImageScreen -> {
                UploadImageUi(
                    imageScreenViewModel = imageScreenViewModel,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
private fun UploadImageUi(
    imageScreenViewModel: ImageScreenViewModel,
    modifier: Modifier = Modifier
) {
    val imageScreenUiState = imageScreenViewModel.uiState.collectAsState()
    val isImageSelected = imageScreenUiState.value.isImageSelected
    val selectedImage = imageScreenUiState.value.selectedImage

    val commonModifier = Modifier.fillMaxWidth()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (isImageSelected) {
            val imageBitmap = remember { byArrayToImageBitmap(image = selectedImage!!) }
            Image(
                bitmap = imageBitmap,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.profileImageModifier()
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        Text(
            text = "Upload Image",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
            modifier = commonModifier
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Select an image to upload",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            modifier = commonModifier
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { imageScreenViewModel.selectImage() }) {
            Text(text = "Select Image")
        }
    }
}

