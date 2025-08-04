package imager.frontend.shared.presentation

@Suppress("ArrayInDataClass")
internal data class ImageScreenUiState(
    val isImageSelected: Boolean = false,
    val selectedImage: ByteArray? = null,
    val isUploading: Boolean = false,
)
