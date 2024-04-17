package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.LocationForecastDataRepository
import no.uio.ifi.in2000.team_21.model.locationforecast.Response
import no.uio.ifi.in2000.team_21.model.locationforecast.Timeseries

class ForecastViewModel: ViewModel() {

    private val repository: LocationForecastDataRepository = LocationForecastDataRepository()

    private var _forecasts: MutableLiveData<Response?> = MutableLiveData()
    val forecasts: LiveData<Response?> get() = _forecasts

    // Private mutable LiveData for icons
    var icons by mutableStateOf(
        listOf<String>()
    )

    var todaysIcons by mutableStateOf(
        listOf<String>()
    )

    fun fetchIcons() {
        Log.d("FORECAST_VIEWMODEL","fetch all icons")
        viewModelScope.launch {
            val response = repository.fetchImageIcons()
            // Update LiveData with the new list
            icons = response
        }
    }

    fun fetchForecast(){
        Log.d("FORECAST_VIEWMODEL","fetch all forecasts")
        viewModelScope.launch {

            Log.d("FORECAST_VIEWMODEL","fetching forecast from $repository")
            val response = repository.fetchForecast()
            Log.d("FORECAST_VIEWMODEL","reponse = $response")
            _forecasts.value = response
        }
    }

    fun fetchNearestForecast() {
        Log.d("FORECAST_VIEWMODEL","most recent icons")
        viewModelScope.launch {
            val response = repository.fetchNearestForecast()
        }
    }

    fun getTodaysIcons() {
        Log.d("FORECAST_VIEWMODEL","todays icons")
        viewModelScope.launch {
            try {
                val forecast = repository.fetchForecast()  // Assuming this fetches the JSON data

                // Filter and extract the symbol codes for each timeseries entry
                val icons: List<String?> =
                    listOf(
                        forecast?.properties?.timeseries?.first()?.data?.next_1_hours?.summary?.symbol_code,
                        forecast?.properties?.timeseries?.first()?.data?.next_6_hours?.summary?.symbol_code,
                        forecast?.properties?.timeseries?.first()?.data?.next_12_hours?.summary?.symbol_code
                    )

                Log.d("FORECAST_VM","returning icons: $icons")

                // Update the mutable state with the new icons
                todaysIcons = icons as List<String>
            } catch (e: Exception) {
                // Handle exceptions, e.g., log an error or update UI accordingly
                println("Error fetching forecast: ${e.message}")
            }
        }
    }

    init {
        Log.d("FORECAST_VIEWMODEL","constructor")
        fetchForecast()
    }

}
