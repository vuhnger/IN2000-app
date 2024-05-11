package no.uio.ifi.in2000.team_21.model.oceanforecast

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class OceanForecastResponse (

    @SerializedName("type"       ) var type       : String?     = null,
    @SerializedName("geometry"   ) var geometry   : Geometry?   = Geometry(),
    @SerializedName("properties" ) var properties : Properties? = Properties()

)
@Serializable
data class Geometry (

    @SerializedName("type"        ) var type        : String?           = null,
    @SerializedName("coordinates" ) var coordinates : ArrayList<Double> = arrayListOf()

)
@Serializable
data class Properties (

    @SerializedName("meta"       ) var meta       : Meta?                 = Meta(),
    @SerializedName("timeseries" ) var timeseries : ArrayList<Timeseries> = arrayListOf()

)
@Serializable
data class Meta (

    @SerializedName("updated_at" ) var updated_at : String? = null,
    @SerializedName("units"      ) var units     : Units?  = Units()

)
@Serializable
data class Timeseries (

    @SerializedName("time" ) var time : String? = null,
    @SerializedName("data" ) var data : Data?   = Data()

)
@Serializable
data class Units (

    @SerializedName("sea_surface_wave_from_direction" ) var sea_surface_wave_from_direction : String? = null,
    @SerializedName("sea_surface_wave_height"         ) var sea_surface_wave_height        : String? = null,
    @SerializedName("sea_water_speed"                 ) var sea_water_speed               : String? = null,
    @SerializedName("sea_water_temperature"           ) var sea_water_temperature         : String? = null,
    @SerializedName("sea_water_to_direction"          ) var sea_water_to_direction       : String? = null

)
@Serializable
data class Instant (

    @SerializedName("details" ) var details : Details? = Details()

)
@Serializable
data class Data (

    @SerializedName("instant" ) var instant : Instant? = Instant()

)
@Serializable
data class Details (

    @SerializedName("sea_surface_wave_from_direction" ) var sea_surface_wave_from_direction : Double? = null,
    @SerializedName("sea_surface_wave_height"         ) var sea_surface_wave_height        : Double? = null,
    @SerializedName("sea_water_speed"                 ) var sea_water_speed              : Double? = null,
    @SerializedName("sea_water_temperature"           ) var sea_water_temperature        : Double? = null,
    @SerializedName("sea_water_to_direction"          ) var sea_water_to_direction         : Double? = null

)