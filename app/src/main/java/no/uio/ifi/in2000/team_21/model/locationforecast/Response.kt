package no.uio.ifi.in2000.team_21.model.locationforecast

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Response (

    @SerializedName("type"       ) var type       : String?     = null,
    @SerializedName("geometry"   ) var geometry   : Geometry?   = Geometry(),
    @SerializedName("properties" ) var properties : Properties? = Properties()

)
@Serializable
data class Geometry(

    @SerializedName("type"        ) var type        : String?        = null,
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

    @SerializedName("air_pressure_at_sea_level"     ) var air_pressure_at_sea_level      : String? = null,
    @SerializedName("air_temperature"               ) var air_temperature             : String? = null,
    @SerializedName("air_temperature_max"           ) var air_temperature_max          : String? = null,
    @SerializedName("air_temperature_min"           ) var air_temperature_min          : String? = null,
    @SerializedName("air_temperature_percentile_10" ) var air_temperature_percentile_10 : String? = null,
    @SerializedName("air_temperature_percentile_90" ) var air_temperature_percentile_90 : String? = null,
    @SerializedName("cloud_area_fraction"           ) var cloud_area_fraction          : String? = null,
    @SerializedName("cloud_area_fraction_high"      ) var cloud_area_fraction_high      : String? = null,
    @SerializedName("cloud_area_fraction_low"       ) var cloud_area_fraction_low       : String? = null,
    @SerializedName("cloud_area_fraction_medium"    ) var cloud_area_fraction_medium    : String? = null,
    @SerializedName("dew_point_temperature"         ) var dew_point_temperature        : String? = null,
    @SerializedName("fog_area_fraction"             ) var fog_area_fraction            : String? = null,
    @SerializedName("precipitation_amount"          ) var precipitation_amount        : String? = null,
    @SerializedName("precipitation_amount_max"      ) var precipitation_amount_max     : String? = null,
    @SerializedName("precipitation_amount_min"      ) var precipitation_amount_min     : String? = null,
    @SerializedName("probability_of_precipitation"  ) var probability_of_precipitation : String? = null,
    @SerializedName("probability_of_thunder"        ) var probability_of_thunder       : String? = null,
    @SerializedName("relative_humidity"             ) var relative_humidity           : String? = null,
    @SerializedName("ultraviolet_index_clear_sky"   ) var ultraviolet_index_clear_sky   : String? = null,
    @SerializedName("wind_from_direction"           ) var wind_from_direction          : String? = null,
    @SerializedName("wind_speed"                    ) var wind_speed                  : String? = null,
    @SerializedName("wind_speed_of_gust"            ) var wind_speed_of_gust            : String? = null,
    @SerializedName("wind_speed_percentile_10"      ) var wind_speed_percentile_10      : String? = null,
    @SerializedName("wind_speed_percentile_90"      ) var wind_speed_percentile_90      : String? = null

)

@Serializable
data class Instant (

    @SerializedName("details" ) var details : Details? = Details()

)

@Serializable
data class Next1Hours (

    @SerializedName("summary" ) var summary : Summary? = Summary(),
    @SerializedName("details" ) var details : Details? = Details()

)
@Serializable
data class Next6Hours (

    @SerializedName("summary" ) var summary : Summary? = Summary(),
    @SerializedName("details" ) var details : Details? = Details()

)
@Serializable
data class Next12Hours (

    @SerializedName("summary" ) var summary : Summary? = Summary(),
    @SerializedName("details" ) var details : Details? = Details()

)

@Serializable
data class Data (
    @SerializedName("instant"       ) var instant     : Instant?     = Instant(),
    @SerializedName("next_12_hours" ) var next_12_hours : Next12Hours? = Next12Hours(),
    @SerializedName("next_1_hours"  ) var next_1_hours  : Next1Hours?  = Next1Hours(),
    @SerializedName("next_6_hours"  ) var next_6_hours  : Next6Hours?  = Next6Hours()
)

@Serializable
data class Details (
    @SerializedName("air_temperature"              ) var air_temperature         : Double? = null,
    @SerializedName("air_temperature_max"          ) var air_temperature_max          : Double? = null,
    @SerializedName("air_temperature_min"          ) var air_temperature_min          : Double? = null,
    @SerializedName("precipitation_amount"         ) var precipitation_amount        : Double? = null,
    @SerializedName("precipitation_amount_max"     ) var precipitation_amount_max     : Double? = null,
    @SerializedName("precipitation_amount_min"     ) var precipitation_amount_min     : Double? = null,
    @SerializedName("probability_of_precipitation" ) var probability_of_precipitation : Double?    = null,
    @SerializedName("wind_speed"                   ) var wind_speed                  : String? = null
)

@Serializable
data class Summary (
    @SerializedName("symbol_code" ) var symbol_code : String? = null
)


