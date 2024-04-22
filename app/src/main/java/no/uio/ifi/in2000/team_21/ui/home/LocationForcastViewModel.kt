package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.LocationForcastRepository
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForcastResponse
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries

class LocationForcastViewModel: ViewModel() {

    private val repository: LocationForcastRepository = LocationForcastRepository()

    private  var _forecasts: MutableLiveData<LocationForcastResponse?> = MutableLiveData()
    val forecasts: LiveData<LocationForcastResponse?> get() = _forecasts

    private var _timeseries: MutableLiveData<ArrayList<LocationForecastTimeseries>?> = MutableLiveData()

    val timeseries: LiveData<ArrayList<LocationForecastTimeseries>?> get() = _timeseries

    fun fetchLocationForecastResponse() {
        viewModelScope.launch {
            val response = repository.fetchLocationForcastResponse()
            _forecasts.value = response
            Log.d("LOCATIONFORECAST_VM", "Response: $response")
        }
    }

    fun fetchLocationForecastTimeseries() {
        viewModelScope.launch {
            val timeseriesData = repository.fetchLocationForecastTimeseries()
            _timeseries.value = timeseriesData
            Log.d("LF_VM", "Timeseries: $timeseriesData")

        }
    }

    fun fetchAirTemperatureAtTime(time: String) {
        viewModelScope.launch {
            val temperature = repository.fetchAirTemperatureAtTime(time)
            Log.d("LF_VM", "Air temperature at $time is $temperature degrees Celsius.")
        }
    }
 }