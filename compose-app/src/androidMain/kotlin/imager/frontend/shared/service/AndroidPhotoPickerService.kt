package imager.frontend.shared.service

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

object AndroidPhotoPickerService  {

    private var photoPickerLauncher: ActivityResultLauncher<PickVisualMediaRequest>? = null

    private var onPhotoPicked: (Uri) -> Unit = {}
    private var onPhotoPickerError: () -> Unit = {}

    fun initialize(activity: ComponentActivity) {
        photoPickerLauncher = activity.registerForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia()
        ) { uri ->
            if (uri != null) {
                onPhotoPicked(uri)
            } else {
                onPhotoPickerError()
            }
        }
    }

    internal fun pickPhoto(
        onPhotoPicked: (Uri) -> Unit,
        onPhotoPickerError: () -> Unit
    ) {
        this.onPhotoPicked = onPhotoPicked
        this.onPhotoPickerError = onPhotoPickerError
        photoPickerLauncher?.launch(
            input = PickVisualMediaRequest(
                mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
            )
        )
    }
}