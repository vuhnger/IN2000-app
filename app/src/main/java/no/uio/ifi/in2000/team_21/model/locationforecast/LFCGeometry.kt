package no.uio.ifi.in2000.team_21.model.locationforecast

import com.google.gson.annotations.SerializedName


data class LFCGeometry (

  @SerializedName("type"        ) var type        : String?        = null,
  @SerializedName("coordinates" ) var coordinates : ArrayList<Int> = arrayListOf()

)