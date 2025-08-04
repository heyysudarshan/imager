package imager.frontend.shared.service

internal actual fun requestImage(
    onPhotoPicked: (ByteArray) -> Unit,
    onPhotoPickerError: () -> Unit
) {
    AndroidPhotoPickerService.pickPhoto(
        onPhotoPicked = onPhotoPicked,
        onPhotoPickerError = onPhotoPickerError
    )
}