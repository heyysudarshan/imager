package imager.frontend.shared.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class ImageScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ImageScreenUiState())
    val uiState = _uiState.asStateFlow()
}