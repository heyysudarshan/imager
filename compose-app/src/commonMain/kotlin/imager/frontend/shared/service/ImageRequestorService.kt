package imager.frontend.shared.service

internal object ImageRequestorService {
    fun getImageFromUserDevice(
        onPhotoPicked: (ByteArray) -> Unit,
        onPhotoPickerError: () -> Unit
    ) {
        requestImage(onPhotoPicked = onPhotoPicked, onPhotoPickerError = onPhotoPickerError)
    }
}