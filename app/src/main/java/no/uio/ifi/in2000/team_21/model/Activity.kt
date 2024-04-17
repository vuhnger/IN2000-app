package no.uio.ifi.in2000.team_21.model

abstract class Activity{

    abstract val type: String
    abstract val air_temperature: Double?
    abstract val air_temperature_unit: String?
    abstract val sea_water_temperature: Double?
    abstract val sea_water_temperature_unit: String?
    abstract val sea_water_speed: Double? // Current
    abstract val sea_surface_wave_height: Double?
    abstract val imageResource: Resource
    abstract val icons: List<String>?
}

class Kayaking(
    override val type: String,
    override val air_temperature: Double,
    override val air_temperature_unit: String,
    override val sea_water_temperature: Double,
    override val sea_water_temperature_unit: String,
    override val sea_water_speed: Double,
    override val sea_surface_wave_height: Double,
    override val imageResource: Resource,
    override val icons: List<String>
) : Activity() {

    val sea_water_to_direction: Double? = null

}