package imager.frontend.shared.service

import androidx.compose.ui.graphics.ImageBitmap

internal expect fun byArrayToImageBitmap(image: ByteArray): ImageBitmap