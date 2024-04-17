package no.uio.ifi.in2000.team_21.ui.home

import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import no.uio.ifi.in2000.team_21.R
import no.uio.ifi.in2000.team_21.data.LocationForecastDataRepository

class HomeScreenViewModel : ViewModel() {

    private val forecastViewModel = ForecastViewModel()

    init{
        forecastViewModel.getTodaysIcons()
    }

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