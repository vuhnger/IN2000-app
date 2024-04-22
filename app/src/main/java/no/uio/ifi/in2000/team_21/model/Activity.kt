package no.uio.ifi.in2000.team_21.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.graphics.vector.ImageVector
import no.uio.ifi.in2000.team_21.R

/*
Aktiviteter:
Kayaking
Fisking
Seiling
Roing
Padling
Surfing
Snorkling
Svømming
Vannski
Kano
 */


private fun toFahrenheit(x: Double): Double {
    return (x * 9.0 / 5.0) + 32
}
abstract class Activity{

    abstract val type: String
    abstract val air_temperature: Double?
    abstract val air_temperature_unit: String?
    abstract val sea_water_temperature: Double?
    abstract val sea_water_temperature_unit: String?
    abstract val sea_water_speed: Double? // Current
    abstract val sea_surface_wave_height: Double?
    abstract val imageId: Int
    val symbol: ImageVector = Icons.Default.Close
    var icons: List<String> = listOf()
    open val MIN_AIR_TEMPERATURE: Double = 0.0
    open val MIN_SEA_WATER_TEMPERATURE = 0.0
    fun isReccomended(): Boolean{
        if (air_temperature == null){
            return false
        }
        if (sea_water_temperature == null){
            return false
        }
        if (
            air_temperature!! >= MIN_AIR_TEMPERATURE
            && sea_water_temperature!! >= MIN_SEA_WATER_TEMPERATURE
        ){
            return true
        }
        return false
    }

}

class Kayaking(
    override val type: String = "Kayaking",
    override val air_temperature: Double,
    override val air_temperature_unit: String,
    override val sea_water_temperature: Double,
    override val sea_water_temperature_unit: String,
    override val sea_water_speed: Double,
    override val sea_surface_wave_height: Double,
    override val imageId: Int = R.drawable.kayak_stock,
) : Activity() {

    /*
    Gunstige forhold:
    Lufttemperatur: Over 10°C
    Vannets temperatur: Over 12°C
    Vannhastighet: Under 3 m/s
    Bølgehøyde: Under 0.5 m
     */
    val sea_water_to_direction: Double? = null

    private val min_air_temp = 10.0
    override val MIN_AIR_TEMPERATURE = if (air_temperature_unit == "celsius") min_air_temp else toFahrenheit(min_air_temp)
    private val min_sea_temp = 12.0
    override val MIN_SEA_WATER_TEMPERATURE = if (air_temperature_unit == "celsius") min_sea_temp else toFahrenheit(min_sea_temp)
    val MIN_SEA_WATER_SPEED = 3.0
    val MAX_SEA_SURFACE_WAVE_HEIGHT = 0.5

}

class Fishing(
    override val type: String = "Fisking",
    override val air_temperature: Double?,
    override val air_temperature_unit: String?,
    override val sea_water_temperature: Double?,
    override val sea_water_temperature_unit: String?,
    override val sea_water_speed: Double?,
    override val sea_surface_wave_height: Double?,
    override val imageId: Int = R.drawable.fisking_stock
) : Activity() {

    private val min_air_temp = 5.0
    override val MIN_AIR_TEMPERATURE = if (air_temperature_unit == "celsius") min_air_temp else toFahrenheit(min_air_temp)
    private val min_sea_temp = 5.0
    override val MIN_SEA_WATER_TEMPERATURE = if (sea_water_temperature_unit == "celsius") min_sea_temp else toFahrenheit(min_sea_temp)
    val MIN_SEA_WATER_SPEED = 2.0
    val MAX_WAVE_HEIGHT = 1.0
    
}

class Rowing(
    override val type: String = "Roing",
    override val air_temperature: Double?,
    override val air_temperature_unit: String?,
    override val sea_water_temperature: Double?,
    override val sea_water_temperature_unit: String?,
    override val sea_water_speed: Double?,
    override val sea_surface_wave_height: Double?,
    override val imageId: Int = R.drawable.roing_stock
) : Activity() {

    private val min_air_temp = 10.0
    override val MIN_AIR_TEMPERATURE = if (air_temperature_unit == "celsius") min_air_temp else toFahrenheit(min_air_temp)
    private val min_sea_temp = 12.0
    override val MIN_SEA_WATER_TEMPERATURE = if (sea_water_temperature_unit == "celsius") min_sea_temp else toFahrenheit(min_sea_temp)


}

class Paddling(
    override val type: String = "Padling" ,
    override val air_temperature: Double?,
    override val air_temperature_unit: String?,
    override val sea_water_temperature: Double?,
    override val sea_water_temperature_unit: String?,
    override val sea_water_speed: Double?,
    override val sea_surface_wave_height: Double?,
    override val imageId: Int
) : Activity() {

}

class Surfing(
    override val type: String = "Surfing",
    override val air_temperature: Double?,
    override val air_temperature_unit: String?,
    override val sea_water_temperature: Double?,
    override val sea_water_temperature_unit: String?,
    override val sea_water_speed: Double?,
    override val sea_surface_wave_height: Double?,
    override val imageId: Int
) : Activity() {

}

class Snorkeling(
    override val type: String = "Snorkling",
    override val air_temperature: Double?,
    override val air_temperature_unit: String?,
    override val sea_water_temperature: Double?,
    override val sea_water_temperature_unit: String?,
    override val sea_water_speed: Double?,
    override val sea_surface_wave_height: Double?,
    override val imageId: Int = R.drawable.snorkeling_stock
) : Activity() {

}

class Swimming(
    override val type: String = "Svømming",
    override val air_temperature: Double?,
    override val air_temperature_unit: String?,
    override val sea_water_temperature: Double?,
    override val sea_water_temperature_unit: String?,
    override val sea_water_speed: Double?,
    override val sea_surface_wave_height: Double?,
    override val imageId: Int
) : Activity() {

}

class Waterskiing(
    override val type: String = "Vannski",
    override val air_temperature: Double?,
    override val air_temperature_unit: String?,
    override val sea_water_temperature: Double?,
    override val sea_water_temperature_unit: String?,
    override val sea_water_speed: Double?,
    override val sea_surface_wave_height: Double?,
    override val imageId: Int = R.drawable.waterski_stock
) : Activity() {

}

class Canoing(
    override val type: String = "Kanotur",
    override val air_temperature: Double?,
    override val air_temperature_unit: String?,
    override val sea_water_temperature: Double?,
    override val sea_water_temperature_unit: String?,
    override val sea_water_speed: Double?,
    override val sea_surface_wave_height: Double?,
    override val imageId: Int
) : Activity() {

}