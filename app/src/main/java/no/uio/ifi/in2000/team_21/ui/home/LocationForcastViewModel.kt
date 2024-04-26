package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.LocationForecastRepository
import no.uio.ifi.in2000.team_21.data.OceanForecastRepository
import no.uio.ifi.in2000.team_21.model.locationforcast.Details
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries
import no.uio.ifi.in2000.team_21.model.locationforcast.WeatherData

class LocationForecastViewModel() : ViewModel() {

    private val repository: LocationForecastRepository = LocationForecastRepository()

    private val _weatherDataState = MutableStateFlow<WeatherDataState>(WeatherDataState.Loading)
    val weatherDataState: StateFlow<WeatherDataState> = _weatherDataState

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
}