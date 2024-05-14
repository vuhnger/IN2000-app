package no.uio.ifi.in2000.team_21.ui.viewmodels

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
    private val markerMap = mutableMapOf<String, UserMarkerEntity>()


    fun saveUserLocation(userMarkerEntity: UserMarkerEntity) {
        viewModelScope.launch {
            dao.insert(userMarkerEntity)
        }
    }

    fun addMarkerToMap(userMarkerEntity: UserMarkerEntity, markerId: String) {
        markerMap[markerId] = userMarkerEntity
    }

    fun deleteUserMarker(userMarkerEntity: UserMarkerEntity) {
        viewModelScope.launch {
            //dao.delete(userMarkerEntity)
            dao.deleteByLatLong(userMarkerEntity.latitude, userMarkerEntity.longitude)
            markerMap.values.remove(userMarkerEntity)
            Log.d("ViewModel", "Deleted marker at lat: ${userMarkerEntity.latitude}, long: ${userMarkerEntity.longitude}")
            val allMarkers = dao.getAll()  // Debugging purpose
            Log.d("UserMarkerViewModel", "Remaining Markers after delete: ${allMarkers.size}")
        }
    }

    fun updateUserMarker(userMarkerEntity: UserMarkerEntity) {
        viewModelScope.launch {
            dao.update(userMarkerEntity)
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