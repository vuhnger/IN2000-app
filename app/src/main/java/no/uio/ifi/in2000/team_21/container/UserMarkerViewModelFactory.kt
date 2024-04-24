package no.uio.ifi.in2000.team_21.container

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import no.uio.ifi.in2000.team_21.ui.UserMarkerViewModel

class UserMarkerViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserMarkerViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserMarkerViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
