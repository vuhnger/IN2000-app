package no.uio.ifi.in2000.team_21.ui.map

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.container.RepositoryContainer
import no.uio.ifi.in2000.team_21.data.AlertsRepository
import no.uio.ifi.in2000.team_21.model.Alert
import no.uio.ifi.in2000.team_21.model.AlertsInfo
import no.uio.ifi.in2000.team_21.model.Feature
import org.osmdroid.util.GeoPoint

class AlertsViewModel(private val repository: AlertsRepository = RepositoryContainer.alertsRepository) : ViewModel() {
    private val _alerts = MutableLiveData<Alert?>() // GeoJSON String
    val alerts: LiveData<Alert?> = _alerts
    val radius = mutableDoubleStateOf(50000.0)

    // filtered features
    private val _filteredFeatures = MutableLiveData<List<Feature>?>()
    val filteredFeatures: LiveData<List<Feature>?> = _filteredFeatures

    fun fetchAlerts(parameters: AlertsInfo) {
        viewModelScope.launch {
            _alerts.value = repository.fetchAlerts(parameters)
        }
    }

    fun fetchAndFilterAlerts(parameters: AlertsInfo, userLocation: GeoPoint, radius: Double) {
        viewModelScope.launch {
            _filteredFeatures.value = repository.fetchAndFilterAlerts(parameters, userLocation, radius)
        }
    }

    fun updateAlertsOnRadius(userLocation: GeoPoint, newRadius: Double) {
        val parameters = AlertsInfo()
        viewModelScope.launch {
            val filteredFeatures = repository.fetchAndFilterAlerts(parameters, userLocation, newRadius)
            _filteredFeatures.value = filteredFeatures
        }
    }
}
