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

    val sea_water_to_direction: Double? = null

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