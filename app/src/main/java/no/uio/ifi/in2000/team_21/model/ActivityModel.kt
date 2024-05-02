package no.uio.ifi.in2000.team_21.model

import no.uio.ifi.in2000.team_21.R


data class ActivityModel(
    val activityName: String,
    val waterTemperatureThreshold: Double,
    val waterSpeedThreshold: Double,
    val waveHeightThreshold: Double,
    val windSpeedThreshold: Double,
    val airTemperatureThreshold: Double,
    val conditionStatus: ConditionStatus = ConditionStatus.NONE_MET
) {
    fun getFlagColorId(): Int {
        return when (conditionStatus) {
            ConditionStatus.ALL_MET -> R.drawable.green_flag_48
            ConditionStatus.SOME_MET -> R.drawable.yellow_flag_48
            ConditionStatus.NONE_MET -> R.drawable.red_flag_48
        }
    }
}
enum class ConditionStatus {
    ALL_MET, // Green flag
    SOME_MET, // Yellow flag
    NONE_MET // Red flag
}

object ActivityModels {
    val KAYAKING_CANOEING = ActivityModel(
        "Kayaking & Canoeing",
        waterTemperatureThreshold = 2.0,
        waterSpeedThreshold = 3.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 10.0,
        airTemperatureThreshold = 10.0
    )
    val FISHING = ActivityModel(
        "Fishing",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = 2.0,
        waveHeightThreshold = 1.0,
        windSpeedThreshold = 5.0,
        airTemperatureThreshold = 5.0
    )
    val SAILING = ActivityModel(
        "Sailing",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = 5.0,
        waveHeightThreshold = 2.0,
        windSpeedThreshold = 15.0,
        airTemperatureThreshold = 2.0
    )
    val ROWING_PADDLING = ActivityModel(
        "Rowing & Paddling",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = 3.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 8.0,
        airTemperatureThreshold = 5.0
    )
    val SURFING = ActivityModel(
        "Surfing",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = Double.MAX_VALUE,
        waveHeightThreshold = 3.0,
        windSpeedThreshold = 10.0,
        airTemperatureThreshold = 1.0
    )
    val SNORKELING_SWIMMING = ActivityModel(
        "Snorkeling & Swimming",
        waterTemperatureThreshold = 18.0,
        waterSpeedThreshold = 2.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 5.0,
        airTemperatureThreshold = 2.0
    )
    val WATERSKIING = ActivityModel(
        "Vannski",
        waterTemperatureThreshold = 10.0,
        waterSpeedThreshold = 4.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 12.0,
        airTemperatureThreshold = 0.0
    )

    val allActivities = listOf(KAYAKING_CANOEING, FISHING, SAILING, ROWING_PADDLING, SURFING, SNORKELING_SWIMMING, WATERSKIING
    )
}