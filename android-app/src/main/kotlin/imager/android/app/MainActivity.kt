package imager.android.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import imager.frontend.shared.AndroidApp
import imager.frontend.shared.service.AndroidPhotoPickerService

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeServices()
        setContent {
            AndroidApp()
        }
    }

    private fun initializeServices() {
        AndroidPhotoPickerService.initialize(activity = this)
    }
}