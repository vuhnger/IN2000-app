package no.uio.ifi.in2000.team_21.model.locationforecast

import com.google.gson.annotations.SerializedName


data class LFCResponse (

    @SerializedName("type"       ) var type       : String?     = null,
    @SerializedName("geometry"   ) var geometry   : LFCGeometry?   = LFCGeometry(),
    @SerializedName("properties" ) var properties : LFCProperties? = LFCProperties()

)