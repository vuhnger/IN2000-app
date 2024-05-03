package no.uio.ifi.in2000.team_21.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.OceanForecastRepository
import no.uio.ifi.in2000.team_21.model.oceanforecast.Details
import no.uio.ifi.in2000.team_21.model.oceanforecast.Timeseries
import no.uio.ifi.in2000.team_21.model.oceanforecast.OceanData
import no.uio.ifi.in2000.team_21.model.oceanforecast.OceanForecastResponse
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit


class OceanForecastViewModel : ViewModel() {

    private val repository: OceanForecastRepository = OceanForecastRepository()

    private val _oceanDataState = MutableLiveData<OceanForecastResponse>()
    val oceanDataState: LiveData<OceanForecastResponse> = _oceanDataState

    fun fetchOceanForecastByTime(
        latitude: Double,
        longitude: Double
    ) {
        viewModelScope.launch {
            _oceanDataState.value = repository.fetchOceanForecastResponse(
                latitude = latitude,
                longitude = longitude
            )
        }
    }

    private fun transformToOceanData(
        details: Details,
        timeseries: Timeseries?
    ): OceanData {
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

