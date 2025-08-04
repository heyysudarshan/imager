package imager.frontend.shared.service

import android.content.Context
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

object AndroidPhotoPickerService  {

    private var photoPickerLauncher: ActivityResultLauncher<PickVisualMediaRequest>? = null

    private var onPhotoPicked: (ByteArray) -> Unit = {}
    private var onPhotoPickerError: () -> Unit = {}

    fun initialize(activity: ComponentActivity) {
        photoPickerLauncher = activity.registerForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia()
        ) { uri ->
            if (uri != null) {
                val uriByteArray = convertUriToByteArray(
                    context = activity.applicationContext,
                    uri = uri
                )
                onPhotoPicked(uriByteArray)
            } else {
                onPhotoPickerError()
            }
        }
    }

    internal fun pickPhoto(
        onPhotoPicked: (ByteArray) -> Unit,
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

    private fun convertUriToByteArray(context: Context, uri: Uri): ByteArray {
        return context.contentResolver.openInputStream(uri)?.use { it.readBytes() } ?: ByteArray(0)
    }
}