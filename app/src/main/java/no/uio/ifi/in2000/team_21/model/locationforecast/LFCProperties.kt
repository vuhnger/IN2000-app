package no.uio.ifi.in2000.team_21.model.locationforecast

import com.google.gson.annotations.SerializedName


data class LFCProperties (

    @SerializedName("meta"       ) var meta       : LFCMeta?                 = LFCMeta(),
    @SerializedName("timeseries" ) var timeseries : ArrayList<LFCTimeseries> = arrayListOf()

)