package no.uio.ifi.in2000.team_21.model.locationforecast

import com.google.gson.annotations.SerializedName


data class LFCData (

  @SerializedName("instant"       ) var instant     : LFCInstant?     = LFCInstant(),
  @SerializedName("next_12_hours" ) var next12Hours : Next12Hours? = Next12Hours(),
  @SerializedName("next_1_hours"  ) var next1Hours  : LFCNext1Hours?  = LFCNext1Hours(),
  @SerializedName("next_6_hours"  ) var next6Hours  : LFCNext6Hours?  = LFCNext6Hours()

)