package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.LocationForecastDataRepository
import no.uio.ifi.in2000.team_21.model.locationforecast.Response
import no.uio.ifi.in2000.team_21.model.locationforecast.Timeseries

class ForecastViewModel : ViewModel() {

    private val repository: LocationForecastDataRepository = LocationForecastDataRepository()
    private val _selectedLocationWeatherData = mutableStateOf<List<Timeseries>?>(null)
    val selectedLocationWeatherData: State<List<Timeseries>?> = _selectedLocationWeatherData

    // Private mutable LiveData for icons
    var icons by mutableStateOf(
        listOf<String>()
    )

    var forecasts by mutableStateOf(
        Response
    )

    fun fetchIcons() {
        viewModelScope.launch {
            val response = repository.fetchImageIcons()
            // Update LiveData with the new list
            icons = response
        }
    }

    fun fetchForecast(){
        viewModelScope.launch {
            val response = repository.fetchForecast()
        }
    }

    fun fetchWeatherForLocation(lat: Double, lon: Double) {
        viewModelScope.launch {
            val timeseriesData = repository.fetchWeatherDataForLocation(lat, lon)
            _selectedLocationWeatherData.value = timeseriesData
        }
    }

    init {
        fetchIcons()
        fetchForecast()
    }
}
