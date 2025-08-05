package imager.frontend.shared

import androidx.compose.ui.window.ComposeUIViewController
import imager.frontend.shared.presentation.ImageScreen

fun IosViewController() = ComposeUIViewController { ImageScreen() }