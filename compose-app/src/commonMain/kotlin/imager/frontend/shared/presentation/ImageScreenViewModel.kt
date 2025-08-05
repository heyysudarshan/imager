package imager.frontend.shared.presentation

import androidx.lifecycle.ViewModel
import imager.frontend.shared.service.ImageRequestorService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class ImageScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ImageScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun selectImage() {
        ImageRequestorService.getImageFromUserDevice(
            onPhotoPicked = {
                _uiState.value = _uiState.value.copy(
                    isImageSelected = true,
                    selectedImage = it
                )
            },
            onPhotoPickerError = {
                _uiState.value = _uiState.value.copy(
                    isImageSelected = false,
                    selectedImage = null
                )
            }
        )
    }
}