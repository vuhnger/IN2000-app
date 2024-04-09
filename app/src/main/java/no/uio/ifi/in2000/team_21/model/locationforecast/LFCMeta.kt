package no.uio.ifi.in2000.team_21.model.locationforecast

import com.google.gson.annotations.SerializedName


data class LFCMeta (

  @SerializedName("updated_at" ) var updatedAt : String? = null,
  @SerializedName("units"      ) var units     : LFCUnits?  = LFCUnits()

)