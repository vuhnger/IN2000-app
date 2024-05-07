package no.uio.ifi.in2000.team_21.container

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import no.uio.ifi.in2000.team_21.ui.viewmodels.ActivitiesViewModel

class ActivityViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ActivitiesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ActivitiesViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

