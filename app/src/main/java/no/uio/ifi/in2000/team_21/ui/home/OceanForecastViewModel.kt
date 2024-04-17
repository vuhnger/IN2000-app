package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.OceanForecastRepository
import no.uio.ifi.in2000.team_21.model.oceanforecast.Response
import no.uio.ifi.in2000.team_21.model.oceanforecast.Timeseries

class OceanForecastViewModel : ViewModel() {

    private val repository: OceanForecastRepository = OceanForecastRepository()

    private var _forecasts: MutableLiveData<Response?> = MutableLiveData()
    val forecasts: LiveData<Response?> get() = _forecasts

    private var _timeseries: MutableLiveData<ArrayList<Timeseries>?> = MutableLiveData()
    val timeseries: LiveData<ArrayList<Timeseries>?> get() = _timeseries

    fun fetchOceanForecastResponse() {
        viewModelScope.launch {
            val response = repository.fetchOceanForecastResponse()
            _forecasts.value = response
            Log.d("OCEANFORCAST_VM", "Response: $response")
        }
    }

    fun fetchOceanForcastTimeseries() {
        viewModelScope.launch {
            val timeseriesData = repository.fetchOceanForecastTimeseries()
            _timeseries.value = timeseriesData
            Log.d("OCEANFORCAST_VM", "Timeseries: $timeseriesData")
        }
    }

    fun updateCoordinates(newLatitude: Double, newLongitude: Double) {
        Log.d("OCEANFORCAST_VM", "Updating coordinates to lat: $newLatitude, lon: $newLongitude")
        repository.setCoordinates(newLatitude, newLongitude)
    }
}


