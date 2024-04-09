package no.uio.ifi.in2000.team_21.model.locationforecast

import com.google.gson.annotations.SerializedName


data class LFCNext6Hours (

  @SerializedName("summary" ) var summary : LFCSummary? = LFCSummary(),
  @SerializedName("details" ) var details : LFCDetails? = LFCDetails()

)