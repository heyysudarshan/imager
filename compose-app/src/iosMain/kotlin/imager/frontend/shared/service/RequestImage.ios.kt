package imager.frontend.shared.service

actual fun requestImage(
    onPhotoPicked: (ByteArray) -> Unit,
    onPhotoPickerError: () -> Unit
): ByteArray {
    return ByteArray(0)
}