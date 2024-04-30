package no.uio.ifi.in2000.team_21.model.locationforcast

data class WeatherData(
    val time: String?,
    val airTemperature: Double?,
    val windFromDirection: Double?,
    val windSpeed: Double?,
    val humidity: Double?,
    val chanceOfRain: Double?,
    val airPressureAtSeaLevel: Double? = null,
    val cloudAreaFraction: Double? = null,
    val uvIndex: Double? = null
)