package no.uio.ifi.in2000.team_21.model.locationforecast

import com.google.gson.annotations.SerializedName


data class LFCTimeseries (

  @SerializedName("time" ) var time : String? = null,
  @SerializedName("data" ) var data : LFCData?   = LFCData()

)