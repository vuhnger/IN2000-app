package no.uio.ifi.in2000.team_21.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.database.DatabaseBuilder
import no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity

class UserMarkerViewModel(application: Application) : AndroidViewModel(application) {
    private val database = DatabaseBuilder.getDatabase(application)
    private val dao = database.locationDao()
    val markerMap = mutableMapOf<String, UserMarkerEntity>()

    // DAO to interact with the database
    fun saveUserLocation(locationEntity: UserMarkerEntity) {
        viewModelScope.launch {
            dao.insert(locationEntity)
        }
    }

    fun addMarkerToMap(userMarkerEntity: UserMarkerEntity, markerId: String) {
        markerMap[markerId] = userMarkerEntity
    }

    fun deleteUserLocation(locationEntity: UserMarkerEntity) {
        viewModelScope.launch {
            dao.delete(locationEntity)
            markerMap.values.remove(locationEntity)
        }
    }

    fun updateUserLocation(locationEntity: UserMarkerEntity) {
        viewModelScope.launch {
            dao.update(locationEntity)
        }
    }

    fun loadSavedMarkers(onMarkersLoaded: (List<UserMarkerEntity>) -> Unit) {
        viewModelScope.launch {
            val savedLocations = dao.getAll()
            onMarkersLoaded(savedLocations)
        }
    }

    fun getMarkerById(id: String): UserMarkerEntity? = markerMap[id]

    init {
        Log.d("ViewModel", "UserMarkerViewModel initialized")
    }

}