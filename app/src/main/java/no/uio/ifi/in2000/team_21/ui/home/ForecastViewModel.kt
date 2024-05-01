package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.LocationForecastDataRepository
import no.uio.ifi.in2000.team_21.model.locationforcast.Details
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries
import no.uio.ifi.in2000.team_21.model.locationforcast.WeatherData
import no.uio.ifi.in2000.team_21.model.locationforecast.Response

class ForecastViewModel : ViewModel() {

    private val repository: LocationForecastDataRepository = LocationForecastDataRepository()
    private val _selectedLocationWeatherData = mutableStateOf<List<LocationForecastTimeseries>?>(null)
    val selectedLocationWeatherData: State<List<LocationForecastTimeseries>?> = _selectedLocationWeatherData
    private val _weatherDataState = MutableStateFlow<WeatherDataState>(WeatherDataState.Loading)
    val weatherDataState: StateFlow<WeatherDataState> = _weatherDataState

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

    sealed class WeatherDataState {
        object Loading : WeatherDataState()
        data class Success(val weatherData: WeatherData?) : WeatherDataState()
        data class Error(val message: String) : WeatherDataState()
    }

    fun fetchWeatherDataByTime(time: String, latitude: Double, longitude: Double) {
        _weatherDataState.value = WeatherDataState.Loading
        viewModelScope.launch {
            val timeseries = repository.fetchLocationForecastTimeseriesByTime(time ,latitude, longitude) // Assuming this fetches by location
            val weatherData = timeseries?.data?.instant?.details?.let { transformToWeatherData(it, timeseries) }
            _weatherDataState.value = if (weatherData != null) {
                WeatherDataState.Success(weatherData)
            } else {
                WeatherDataState.Error("No data found for time: $time")
            }
        }
    }

    fun fetchAirTemperatureAtTime(time: String) {
        viewModelScope.launch {
            val temperature = repository.fetchAirTemperatureAtTime(time)
            Log.d("LF_VM", "Air temperature at $time is $temperature degrees Celsius.")
        }
    }

    private fun transformToWeatherData(details: Details, timeseries: LocationForecastTimeseries): WeatherData? {

        return WeatherData(
            time = timeseries.time,
            airTemperature = details.air_temperature,
            windFromDirection = details.wind_from_direction,
            windSpeed = details.wind_speed,
            humidity = details.relative_humidity,
            chanceOfRain = details.probability_of_precipitation,
            // Add other fields based on your needs and response structure (e.g., air pressure, cloud cover)
        )
    }

    init {
        fetchIcons()
        fetchForecast()
    }
}
