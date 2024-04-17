package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.LocationForecastDataRepository
import no.uio.ifi.in2000.team_21.model.locationforecast.Timeseries

class ForecastViewModel: ViewModel() {

    private val repository: LocationForecastDataRepository = LocationForecastDataRepository()
    private var instance: ForecastViewModel? = null

    fun getInstance(): ForecastViewModel {
        if (instance != null){
            instance = ForecastViewModel()
        }
        return instance!!
    }

    // Private mutable LiveData for icons
    var icons by mutableStateOf(
        listOf<String>()
    )

    var todaysIcons by mutableStateOf(
        listOf<String>()
    )

    var nearestForecast by mutableStateOf(
        Timeseries
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

    fun fetchNearestForecast() {
        viewModelScope.launch {
            val response = repository.fetchNearestForecast()
        }
    }

    fun getTodaysIcons() {
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
        //fetchIcons()
        //fetchForecast()
        //fetchNearestForecast()
        getTodaysIcons()
    }
}
