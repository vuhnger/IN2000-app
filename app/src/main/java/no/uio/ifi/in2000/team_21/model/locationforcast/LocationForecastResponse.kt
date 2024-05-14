package no.uio.ifi.in2000.team_21.model.locationforcast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationForecastResponse (
    @SerialName("type") var type: String? = null,
    @SerialName("geometry") var geometry: Geometry? = Geometry(),
    @SerialName("properties") var properties: Properties? = Properties()
)
@Serializable
data class Geometry (
    @SerialName("type") var type: String? = null,
    @SerialName("coordinates") var coordinates: ArrayList<Double> = arrayListOf()
)
@Serializable
data class Properties (
    @SerialName("meta") var meta: Meta? = Meta(),
    @SerialName("timeseries") var timeseries: ArrayList<LocationForecastTimeseries> = arrayListOf()
)
@Serializable
data class Meta (
    @SerialName("updated_at") var updated_at: String? = null,
    @SerialName("units") var units: Units? = Units()
)
@Serializable
data class LocationForecastTimeseries (
    @SerialName("time") var time: String? = null,
    @SerialName("data") var data: Data? = Data()
)
@Serializable
data class Units (
    @SerialName("air_pressure_at_sea_level") var air_pressure_at_sea_level: String? = null,
    @SerialName("air_temperature") var air_temperature: String? = null,
    @SerialName("air_temperature_max") var air_temperature_max: String? = null,
    @SerialName("air_temperature_min") var air_temperature_min: String? = null,
    @SerialName("air_temperature_percentile_10") var air_temperature_percentile_10: String? = null,
    @SerialName("air_temperature_percentile_90") var air_temperature_percentile_90: String? = null,
    @SerialName("cloud_area_fraction") var cloud_area_fraction: String? = null,
    @SerialName("cloud_area_fraction_high") var cloud_area_fraction_high: String? = null,
    @SerialName("cloud_area_fraction_low") var cloud_area_fraction_low: String? = null,
    @SerialName("cloud_area_fraction_medium") var cloud_area_fraction_medium: String? = null,
    @SerialName("dew_point_temperature") var dew_point_temperature: String? = null,
    @SerialName("fog_area_fraction") var fog_area_fraction: String? = null,
    @SerialName("precipitation_amount") var precipitation_amount: String? = null,
    @SerialName("precipitation_amount_max") var precipitation_amount_max: String? = null,
    @SerialName("precipitation_amount_min") var precipitation_amount_min: String? = null,
    @SerialName("probability_of_precipitation") var probability_of_precipitation: String? = null,
    @SerialName("probability_of_thunder") var probability_of_thunder: String? = null,
    @SerialName("relative_humidity") var relative_humidity: String? = null,
    @SerialName("ultraviolet_index_clear_sky") var ultraviolet_index_clear_sky: String? = null,
    @SerialName("wind_from_direction") var wind_from_direction: String? = null,
    @SerialName("wind_speed") var wind_speed: String? = null,
    @SerialName("wind_speed_of_gust") var wind_speed_of_gust: String? = null,
    @SerialName("wind_speed_percentile_10") var wind_speed_percentile_10: String? = null,
    @SerialName("wind_speed_percentile_90") var wind_speed_percentile_90: String? = null
)
@Serializable
data class Data (
    @SerialName("instant") var instant: Instant? = Instant(),
    @SerialName("next_12_hours") var next_12_hours: Next12Hours? = Next12Hours(),
    @SerialName("next_1_hours") var next_1_hours: Next1Hours? = Next1Hours(),
    @SerialName("next_6_hours") var next_6_hours: Next6Hours? = Next6Hours()
)
@Serializable
data class Instant (
    @SerialName("details") var details: Details? = Details()
)
@Serializable
data class Details (
    @SerialName("air_pressure_at_sea_level") var air_pressure_at_sea_level: Double? = null,
    @SerialName("air_temperature") var air_temperature: Double? = null,
    @SerialName("air_temperature_percentile_10") var air_temperature_percentile_10: Double? = null,
    @SerialName("air_temperature_percentile_90") var air_temperature_percentile_90: Double? = null,
    @SerialName("cloud_area_fraction") var cloud_area_fraction: Double? = null,
    @SerialName("cloud_area_fraction_high") var cloud_area_fraction_high: Double? = null,
    @SerialName("cloud_area_fraction_low") var cloud_area_fraction_low: Double? = null,
    @SerialName("cloud_area_fraction_medium") var cloud_area_fraction_medium: Double? = null,
    @SerialName("dew_point_temperature") var dew_point_temperature: Double? = null,
    @SerialName("fog_area_fraction") var fog_area_fraction: Double? = null, // Endret til Double
    @SerialName("relative_humidity") var relative_humidity: Double? = null,
    @SerialName("ultraviolet_index_clear_sky") var ultraviolet_index_clear_sky: Double? = null,
    @SerialName("wind_from_direction") var wind_from_direction: Double? = null,
    @SerialName("wind_speed") var wind_speed: Double? = null,
    @SerialName("wind_speed_of_gust") var wind_speed_of_gust: Double? = null,
    @SerialName("wind_speed_percentile_10") var wind_speed_percentile_10: Double? = null,
    @SerialName("wind_speed_percentile_90") var wind_speed_percentile_90: Double? = null,
    @SerialName("precipitation_amount") var precipitation_amount: Double? = null,
    @SerialName("precipitation_amount_max") var precipitation_amount_max: Double? = null,
    @SerialName("precipitation_amount_min") var precipitation_amount_min: Double? = null,
    @SerialName("probability_of_precipitation") var probability_of_precipitation: Double? = null,
    @SerialName("probability_of_thunder") var probability_of_thunder: Double? = null,
    @SerialName("air_temperature_max") var air_temperature_max: Double? = null,
    @SerialName("air_temperature_min") var air_temperature_min: Double? = null
)
@Serializable
data class Next12Hours (
    @SerialName("summary") var summary: Summary? = Summary(),
    @SerialName("details") var details: Details? = Details()
)
@Serializable
data class Next1Hours (
    @SerialName("summary") var summary: Summary? = Summary(),
    @SerialName("details") var details: Details? = Details()
)
@Serializable
data class Next6Hours (
    @SerialName("summary") var summary: Summary? = Summary(),
    @SerialName("details") var details: Details? = Details()
)
@Serializable
data class Summary (
    @SerialName("symbol_code") var symbol_code: String? = null,
    @SerialName("symbol_confidence") var symbol_confidence: String? = null
)