package no.uio.ifi.in2000.team_21.ui.map

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mapbox.geojson.Point
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.container.RepositoryContainer
import no.uio.ifi.in2000.team_21.data.AlertsRepository
import no.uio.ifi.in2000.team_21.model.Alert
import no.uio.ifi.in2000.team_21.model.AlertsInfo
import no.uio.ifi.in2000.team_21.model.Feature
import no.uio.ifi.in2000.team_21.ui.LocationViewModel

class AlertsViewModel(
    private val repository: AlertsRepository = RepositoryContainer.alertsRepository,
    private val locationViewModel: LocationViewModel
) : ViewModel() {

    private val _alerts = MutableLiveData<Alert?>() // GeoJSON String
    val alerts: LiveData<Alert?> = _alerts
    private val _radius = MutableStateFlow(250.0) // Default radius
    val radius: StateFlow<Double> = _radius

    init {
        // React to changes in user location
        viewModelScope.launch {
            locationViewModel.userLocation.collect { location ->
                if (location != null) {
                    fetchAndFilterAlerts(AlertsInfo(), location, _radius.value)
                }
            }
        }
    }

    fun updateRadius(newRadius: Double) {
        _radius.value = newRadius
        locationViewModel.userLocation.value?.let { location ->
            fetchAndFilterAlerts(AlertsInfo(), location, newRadius)
        }
    }

    // filtered features
    private val _filteredFeatures = MutableLiveData<List<Feature>?>()
    val filteredFeatures: LiveData<List<Feature>?> = _filteredFeatures

    fun fetchAlerts(parameters: AlertsInfo) {
        viewModelScope.launch {
            _alerts.value = repository.fetchAlerts(parameters)
        }
    }

    fun fetchAndFilterAlerts(parameters: AlertsInfo, userLocation: Point, radius: Double) {
        viewModelScope.launch {
            _filteredFeatures.value = repository.fetchAndFilterAlerts(parameters, userLocation, radius)
            //Log.d("Pre-UI Update", "Filtered Features: ${_filteredFeatures.value?.joinToString { it.properties?.title.orEmpty() }}")
        }
    }

    @Composable
    fun RadiusSelector(radius: MutableState<Double>, onRadiusChange: (Double) -> Unit) {
        Slider(
            value = radius.value.toFloat(),
            onValueChange = { newValue ->
                radius.value = newValue.toDouble()
            },
            onValueChangeFinished = {
                onRadiusChange(radius.value)
            },
            valueRange = 1f..2500f,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }

}