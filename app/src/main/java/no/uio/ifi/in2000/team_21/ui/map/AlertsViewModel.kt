package no.uio.ifi.in2000.team_21.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mapbox.mapboxsdk.geometry.LatLng
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.container.RepositoryContainer
import no.uio.ifi.in2000.team_21.data.AlertsRepository
import no.uio.ifi.in2000.team_21.model.Alert
import no.uio.ifi.in2000.team_21.model.AlertsInfo
import no.uio.ifi.in2000.team_21.model.Feature

class AlertsViewModel(private val repository: AlertsRepository = RepositoryContainer.alertsRepository) : ViewModel() {
    private val _alerts = MutableLiveData<Alert?>() // GeoJSON String
    val alerts: LiveData<Alert?> = _alerts

    // filtered features
    private val _filteredFeatures = MutableLiveData<List<Feature>?>()
    val filteredFeatures: LiveData<List<Feature>?> = _filteredFeatures

    fun fetchAlerts(parameters: AlertsInfo) {
        viewModelScope.launch {
            _alerts.value = repository.fetchAlerts(parameters)
        }
    }

    fun fetchAndFilterAlerts(parameters: AlertsInfo, userLocation: LatLng, radius: Double) {
        viewModelScope.launch {
            _filteredFeatures.value = repository.fetchAndFilterAlerts(parameters, userLocation, radius)
        }
    }
}