package no.uio.ifi.in2000.team_21.model.oceanforecast

data class OceanData(
    val time: String?,
    val sea_surface_wave_from_direction: Double?,
    val sea_surface_wave_height: Double?,
    val sea_water_speed: Double?,
    val sea_water_temperature: Double?,
    val sea_water_to_direction: Double?,
)