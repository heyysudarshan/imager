package imager.frontend.shared.service

internal expect fun requestImage(
    onPhotoPicked: (ByteArray) -> Unit,
    onPhotoPickerError: () -> Unit
)