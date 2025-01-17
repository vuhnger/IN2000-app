package no.uio.ifi.in2000.team_21
import no.uio.ifi.in2000.team_21.ui.viewmodels.ActivityConditionCheckerViewModel

object WeatherDetailsMockData {


    val favorableWeather = ActivityConditionCheckerViewModel.WeatherDetails(
        seaWaterTemperature = 10.0,
        seaWaterSpeed = 2.0,
        seaSurfaceWaveHeight = 0.2,
        airTemperature = 20.0,
        windSpeed = 5.0
    )


    val unfavorableWeather = ActivityConditionCheckerViewModel.WeatherDetails(
        seaWaterTemperature = 5.0,
        seaWaterSpeed = 4.0,
        seaSurfaceWaveHeight = 0.8,
        airTemperature = 10.0,
        windSpeed = 15.0
    )


    val noneMetWeather = ActivityConditionCheckerViewModel.WeatherDetails(
        seaWaterTemperature = 0.0,
        seaWaterSpeed = 20.0,
        seaSurfaceWaveHeight = 15.0,
        airTemperature = 5.0,
        windSpeed = 20.0
    )
}