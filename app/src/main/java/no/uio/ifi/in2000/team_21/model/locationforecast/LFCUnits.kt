package no.uio.ifi.in2000.team_21.model.locationforecast

import com.google.gson.annotations.SerializedName


data class LFCUnits (

  @SerializedName("air_pressure_at_sea_level"     ) var airPressureAtSeaLevel      : String? = null,
  @SerializedName("air_temperature"               ) var airTemperature             : String? = null,
  @SerializedName("air_temperature_max"           ) var airTemperatureMax          : String? = null,
  @SerializedName("air_temperature_min"           ) var airTemperatureMin          : String? = null,
  @SerializedName("air_temperature_percentile_10" ) var airTemperaturePercentile10 : String? = null,
  @SerializedName("air_temperature_percentile_90" ) var airTemperaturePercentile90 : String? = null,
  @SerializedName("cloud_area_fraction"           ) var cloudAreaFraction          : String? = null,
  @SerializedName("cloud_area_fraction_high"      ) var cloudAreaFractionHigh      : String? = null,
  @SerializedName("cloud_area_fraction_low"       ) var cloudAreaFractionLow       : String? = null,
  @SerializedName("cloud_area_fraction_medium"    ) var cloudAreaFractionMedium    : String? = null,
  @SerializedName("dew_point_temperature"         ) var dewPointTemperature        : String? = null,
  @SerializedName("fog_area_fraction"             ) var fogAreaFraction            : String? = null,
  @SerializedName("precipitation_amount"          ) var precipitationAmount        : String? = null,
  @SerializedName("precipitation_amount_max"      ) var precipitationAmountMax     : String? = null,
  @SerializedName("precipitation_amount_min"      ) var precipitationAmountMin     : String? = null,
  @SerializedName("probability_of_precipitation"  ) var probabilityOfPrecipitation : String? = null,
  @SerializedName("probability_of_thunder"        ) var probabilityOfThunder       : String? = null,
  @SerializedName("relative_humidity"             ) var relativeHumidity           : String? = null,
  @SerializedName("ultraviolet_index_clear_sky"   ) var ultravioletIndexClearSky   : String? = null,
  @SerializedName("wind_from_direction"           ) var windFromDirection          : String? = null,
  @SerializedName("wind_speed"                    ) var windSpeed                  : String? = null,
  @SerializedName("wind_speed_of_gust"            ) var windSpeedOfGust            : String? = null,
  @SerializedName("wind_speed_percentile_10"      ) var windSpeedPercentile10      : String? = null,
  @SerializedName("wind_speed_percentile_90"      ) var windSpeedPercentile90      : String? = null

)