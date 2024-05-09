package no.uio.ifi.in2000.team_21.ui.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.LocationForecastDataRepository
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries

@RequiresApi(Build.VERSION_CODES.O)
class ForecastViewModel(

) : ViewModel() {

    private val repository: LocationForecastDataRepository = LocationForecastDataRepository()
    private val _selectedLocationWeatherData = mutableStateOf<List<LocationForecastTimeseries>?>(null)
    val selectedLocationWeatherData: State<List<LocationForecastTimeseries>?> = _selectedLocationWeatherData

    private var _forecast = MutableStateFlow<LocationForecastResponse?>(null)
    val forecast: StateFlow<LocationForecastResponse?> = _forecast.asStateFlow()

    private val TIMEOUT_MS = (300_000).toLong() // 300k ms er 5 min
    fun continuousForecastUpdate(
        latitude: Double,
        longitude: Double
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            flow {
                while (true) {
                    val forecast = repository.fetchForecast(latitude, longitude)
                    emit(forecast)
                    delay(TIMEOUT_MS) // Delay for 30 seconds
                }
            }.collect { forecast ->
                _forecast.value = forecast
            }
        }
    }

    fun fetchWeatherForLocation(
        lat: Double,
        lon: Double
    ) {
        viewModelScope.launch {
            val timeseriesData = repository.fetchWeatherDataForLocation(lat, lon)
            _selectedLocationWeatherData.value = timeseriesData
        }
    }

    fun describeCloudCover(cloudAreaFraction: Double): String {
        return when(cloudAreaFraction){
            in 0.0..10.0 -> "Skyfritt"
            in 10.0..20.0 -> "Nesten skyfritt"
            in 20.0..30.0 -> "Litt spredte skyer"
            in 30.0..40.0 -> "Delvis solrikt"
            in 40.0..50.0 -> "Mest sol, noen skyer"
            in 50.0..60.0 -> "Halvveis skydekket, like mye sol som skyer"
            in 60.0..70.0 -> "Lett skyet, mer skyer enn sol"
            in 70.0..80.0 -> "Hovedsaklig skyet, lite sol"
            in 80.0..90.0 -> "Nesten helt skydekket, knapt noe sol"
            in 90.0..100.0 -> "Helt skydekket, ingen synlig sol."
            else -> {
                "Ugyldig verdi: $cloudAreaFraction"
            }
        }
    }

}
