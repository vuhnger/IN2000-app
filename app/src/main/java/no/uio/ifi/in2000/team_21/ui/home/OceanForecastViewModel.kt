package no.uio.ifi.in2000.team_21.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.OceanForecastRepository
import no.uio.ifi.in2000.team_21.model.oceanforecast.Details
import no.uio.ifi.in2000.team_21.model.oceanforecast.Timeseries
import no.uio.ifi.in2000.team_21.model.oceanforecast.OceanData


class OceanForecastViewModel : ViewModel() {

    private val repository: OceanForecastRepository = OceanForecastRepository()

    private val _oceanDataState = MutableStateFlow<OceanDataState>(OceanDataState.Loading)
    val oceanDataState: StateFlow<OceanDataState> = _oceanDataState

    sealed class OceanDataState {
        object Loading : OceanDataState()
        data class Success(val oceanData: OceanData?) : OceanDataState()
        data class Error(val message: String) : OceanDataState()
    }

    fun fetchOceanForecastByTime(time: String, latitude: Double, longitude: Double) {
        _oceanDataState.value = OceanDataState.Loading
        viewModelScope.launch {
            val timeseries = repository.fetchOceanForecastTimeseriesByTime(time, latitude, longitude)
            val oceanData = timeseries?.data?.instant?.details?.let { transformToOceanData(it, timeseries) }
            _oceanDataState.value = if (oceanData != null) {
                OceanDataState.Success(oceanData)
            } else {
                OceanDataState.Error("No data found for time: $time")
            }
        }
    }

    private fun transformToOceanData(details: Details, timeseries: Timeseries?): OceanData {
        return OceanData(
            time = timeseries?.time,
            sea_surface_wave_from_direction = details.sea_surface_wave_from_direction,
            sea_surface_wave_height = details.sea_surface_wave_height,
            sea_water_speed = details.sea_water_speed,
            sea_water_temperature = details.sea_water_temperature,
            sea_water_to_direction = details.sea_water_to_direction
        )
    }
}

