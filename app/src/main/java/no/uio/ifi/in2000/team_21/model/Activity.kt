package no.uio.ifi.in2000.team_21.model



// Egenskapene til klassen(e) skal tilsvare navn på variabler vi får fra api.met.no
abstract class Activity{

    abstract val name: String
    abstract val description: String
    abstract val air_temperature: Double?
    abstract val air_temperature_unit: String?
    abstract val sea_water_temperature: Double?
    abstract val sea_water_temperature_unit: String?
    abstract val sea_water_speed: Double? // Current
    abstract val sea_surface_wave_height: Double?
    abstract val imageId: Int
    abstract val icons: List<String>?

}

class Kayaking(
    override val name: String,
    override val air_temperature: Double?,
    override val air_temperature_unit: String?,
    override val sea_water_temperature: Double?,
    override val sea_water_temperature_unit: String?,
    override val sea_water_speed: Double?,
    override val sea_surface_wave_height: Double?,
    override val imageId: Int,
    override val icons: List<String>,
    override val description: String
) : Activity() {

    val sea_water_to_direction: Double? = null
    val MIN_WATER_TEMPERATURE: Double = 1.0


}

class Fishing(
    override val name: String,
    override val description: String,
    override val air_temperature: Double?,
    override val air_temperature_unit: String?,
    override val sea_water_temperature: Double?,
    override val sea_water_temperature_unit: String?,
    override val sea_water_speed: Double?,
    override val sea_surface_wave_height: Double?,
    override val imageId: Int,
    override val icons: List<String>?
) : Activity() {

}

class Rowing(
    override val name: String,
    override val description: String,
    override val air_temperature: Double?,
    override val air_temperature_unit: String?,
    override val sea_water_temperature: Double?,
    override val sea_water_temperature_unit: String?,
    override val sea_water_speed: Double?,
    override val sea_surface_wave_height: Double?,
    override val imageId: Int,
    override val icons: List<String>?
) : Activity() {

}

class Waterskiing(
    override val name: String,
    override val description: String,
    override val air_temperature: Double?,
    override val air_temperature_unit: String?,
    override val sea_water_temperature: Double?,
    override val sea_water_temperature_unit: String?,
    override val sea_water_speed: Double?,
    override val sea_surface_wave_height: Double?,
    override val imageId: Int,
    override val icons: List<String>?
) : Activity() {

}

class Snorkling(
    override val name: String,
    override val description: String,
    override val air_temperature: Double?,
    override val air_temperature_unit: String?,
    override val sea_water_temperature: Double?,
    override val sea_water_temperature_unit: String?,
    override val sea_water_speed: Double?,
    override val sea_surface_wave_height: Double?,
    override val imageId: Int,
    override val icons: List<String>?
) : Activity() {

}