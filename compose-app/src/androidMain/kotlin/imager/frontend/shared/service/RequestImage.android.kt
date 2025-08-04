package imager.frontend.shared.service

internal actual fun requestImage(
    onPhotoPicked: (ByteArray) -> Unit,
    onPhotoPickerError: () -> Unit
): ByteArray {
    AndroidPhotoPickerService.pickPhoto(
        onPhotoPicked = {
            onPhotoPicked(it)
        },
        onPhotoPickerError = {
            onPhotoPickerError()
        }
    )
    return ByteArray(0)
}