package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.LocationForecastDataRepository
import no.uio.ifi.in2000.team_21.model.locationforecast.Response

class ForecastViewModel : ViewModel() {

    private val repository: LocationForecastDataRepository = LocationForecastDataRepository()

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

    init {
        fetchIcons()
        fetchForecast()
    }
}
