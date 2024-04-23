package no.uio.ifi.in2000.team_21.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.database.DatabaseBuilder
import no.uio.ifi.in2000.team_21.data.database.UserMarker

class LocationViewModel(application: Application) : AndroidViewModel(application) {
    private val database = DatabaseBuilder.getDatabase(application)
    private val dao = database.userLocationDao()

    // DAO to interact with the database
    fun addLocation(userLocation: UserMarker) {
        viewModelScope.launch {
            dao.insert(userLocation)
        }
    }
}