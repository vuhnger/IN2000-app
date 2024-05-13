package no.uio.ifi.in2000.team_21.ui.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
class ForecastViewModel(

) : ViewModel() {

    private val repository: LocationForecastDataRepository = LocationForecastDataRepository()
    private val _selectedLocationWeatherData = mutableStateOf<List<LocationForecastTimeseries>?>(null)
    val selectedLocationWeatherData: State<List<LocationForecastTimeseries>?> = _selectedLocationWeatherData

    private var _forecast = MutableStateFlow<LocationForecastResponse?>(null)
    val forecast: StateFlow<LocationForecastResponse?> = _forecast.asStateFlow()

    private val TIMEOUT_MS = (300_000).toLong() // 300k ms er 5 min

    private val norwayZone = ZoneId.of("Europe/Oslo")
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH").withZone(norwayZone)

    private val _selected_time = MutableStateFlow<String>(ZonedDateTime.now(norwayZone).truncatedTo(ChronoUnit.HOURS).format(formatter))
    val selected_time: StateFlow<String> = _selected_time.asStateFlow()

    private var _selectedDate = MutableStateFlow<LocalDate>(LocalDate.now())
    private var _selectedTime = MutableStateFlow<LocalTime>(LocalTime.now())

    var selectedDate: StateFlow<LocalDate> = _selectedDate.asStateFlow()
    var selectedTime: StateFlow<LocalTime> = _selectedTime.asStateFlow()


    fun update_selected_time(
        selectedDate: LocalDate,
        selectedTime: LocalTime
    ){
        val time = selectedDate.atTime(selectedTime).format(formatter)
        _selected_time.value = time
    }

    fun updateSelectedTime(
        time: LocalTime
    ){
        _selectedTime.value = time
    }

    fun updateSelectedDate(
        date: LocalDate
    ){
        _selectedDate.value = date
    }

    fun continuousForecastUpdate(
        latitude: Double,
        longitude: Double
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            flow {
                while (true) {
                    val forecast = repository.fetchForecast(latitude, longitude)
                    emit(forecast)
                    delay(TIMEOUT_MS)
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
            in 0.0..9.999 -> "Skyfritt"
            in 10.0..19.999 -> "Nesten skyfritt"
            in 20.0..29.999 -> "Litt spredte skyer"
            in 30.0..39.999 -> "Delvis solrikt"
            in 40.0..49.999 -> "Mest sol, noen skyer"
            in 50.0..59.999 -> "Halvveis skydekket, like mye sol som skyer"
            in 60.0..69.999 -> "Lett skyet, mer skyer enn sol"
            in 70.0..79.999 -> "Hovedsaklig skyet, lite sol"
            in 80.0..89.999 -> "Nesten helt skydekket, knapt noe sol"
            in 90.0..100.0 -> "Helt skydekket, ingen synlig sol"
            else -> {
                "Ugyldig verdi: $cloudAreaFraction"
            }
        }
    }

}
