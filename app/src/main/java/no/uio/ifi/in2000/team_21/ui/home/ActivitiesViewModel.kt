package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.R
import no.uio.ifi.in2000.team_21.model.Activity
import no.uio.ifi.in2000.team_21.model.Fishing
import no.uio.ifi.in2000.team_21.model.Kayaking
import no.uio.ifi.in2000.team_21.model.Rowing
import no.uio.ifi.in2000.team_21.model.Snorkeling
import no.uio.ifi.in2000.team_21.model.Waterskiing


data class ActivitiesUIState(
    val activities: List<Activity>,
    val favorites: List<Activity>
)

class ActivitiesViewModel(

) : ViewModel() {

    var activityUIstate by mutableStateOf(
        ActivitiesUIState(
            activities = listOf(
                Kayaking(
                    air_temperature = 10.0,
                    air_temperature_unit = R.string.celsius.toString(),
                    sea_water_temperature = 2.0,
                    sea_water_temperature_unit = "celsius",
                    sea_water_speed = 3.0,
                    sea_surface_wave_height = 0.5
                ),
                Fishing(
                    air_temperature = 10.0,
                    air_temperature_unit = R.string.celsius.toString(),
                    sea_water_temperature = 2.0,
                    sea_water_temperature_unit = "celsius",
                    sea_water_speed = 3.0,
                    sea_surface_wave_height = 0.5
                ),
                Rowing(
                    air_temperature = 10.0,
                    air_temperature_unit = R.string.celsius.toString(),
                    sea_water_temperature = 2.0,
                    sea_water_temperature_unit = "celsius",
                    sea_water_speed = 3.0,
                    sea_surface_wave_height = 0.5
                ),
                Snorkeling(
                    air_temperature = 10.0,
                    air_temperature_unit = R.string.celsius.toString(),
                    sea_water_temperature = 2.0,
                    sea_water_temperature_unit = "celsius",
                    sea_water_speed = 3.0,
                    sea_surface_wave_height = 0.5
                ),
                Waterskiing(
                    air_temperature = 10.0,
                    air_temperature_unit = R.string.celsius.toString(),
                    sea_water_temperature = 2.0,
                    sea_water_temperature_unit = "celsius",
                    sea_water_speed = 3.0,
                    sea_surface_wave_height = 0.5
                )
            ),
            favorites = listOf(

            )
        )
    )
        private set

    // TODO: Lage konstruktør som henter værdata

    fun getWeatherData(){
        viewModelScope.launch {
            // TODO: Hent relevant værdata og legg det i kortene

            activityUIstate = activityUIstate.copy(
                activities = listOf() // TODO: Oppdater aktivitetene med værdata i
            )

        }
    }

}