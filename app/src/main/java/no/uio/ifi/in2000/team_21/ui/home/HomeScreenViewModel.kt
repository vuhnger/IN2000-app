package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import no.uio.ifi.in2000.team_21.R
import no.uio.ifi.in2000.team_21.data.LocationForecastDataRepository
import no.uio.ifi.in2000.team_21.model.Activity
import no.uio.ifi.in2000.team_21.model.Fishing

class HomeScreenViewModel : ViewModel() {

    private val forecastViewModel = ForecastViewModel()

    init{
        forecastViewModel.fetchForecast()
        Log.d("HOMESCREEN_VIEWMODEL","constructor")
    }

    val activities: List<Activity> = listOf<Activity>(
        Fishing(
            name = "Fishing",
            description = "Fishing",
            imageId = R.drawable.fisking_stock,
            air_temperature = forecastViewModel.forecasts.value?.properties?.timeseries?.first()?.data?.instant?.details?.air_temperature,
            air_temperature_unit = forecastViewModel.forecasts.value?.properties?.meta?.units?.air_temperature,
            sea_water_temperature = 0.0,
            sea_water_temperature_unit = "celsuis",
            sea_water_speed = 0.0,
            sea_surface_wave_height = 0.0,
            icons = forecastViewModel.todaysIcons,
        )
    )

    val cards = listOf<ActivityInfo>(
        ActivityInfo(
            name = "Fisking",
            temperature = 10.0,
            temperatureUnit = "c",
            wind = 5.0,
            windUnit = "m/s",
            precipitation = 0.6,
            imageId = R.drawable.fisking_stock,
            icons = forecastViewModel.todaysIcons
        ),
        ActivityInfo(
            name = "Roing",
            temperature = 10.0,
            temperatureUnit = "c",
            wind = 5.0,
            windUnit = "m/s",
            precipitation = 0.6,
            imageId = R.drawable.roing_stock,
            icons = forecastViewModel.todaysIcons
        ),
        ActivityInfo(
            name = "Kajakk",
            temperature = 10.0,
            temperatureUnit = "c",
            wind = 5.0,
            windUnit = "m/s",
            precipitation = 0.6,
            imageId = R.drawable.kayak_stock,
            icons = forecastViewModel.todaysIcons
        ),
        ActivityInfo(
            name = "Vannski",
            temperature = 10.0,
            temperatureUnit = "c",
            wind = 5.0,
            windUnit = "m/s",
            precipitation = 0.6,
            imageId = R.drawable.waterski_stock,
            icons = forecastViewModel.todaysIcons
        ),
        ActivityInfo(
            name = "Snorkling",
            temperature = 10.0,
            temperatureUnit = "c",
            wind = 5.0,
            windUnit = "m/s",
            precipitation = 0.6,
            imageId = R.drawable.snorkeling_stock,
            icons = forecastViewModel.todaysIcons
        )

    )

}