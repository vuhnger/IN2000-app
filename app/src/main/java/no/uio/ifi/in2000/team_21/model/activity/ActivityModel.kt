package no.uio.ifi.in2000.team_21.model.activity

import no.uio.ifi.in2000.team_21.R

data class ActivityModel(
    val activityName: String,
    val waterTemperatureThreshold: Double,
    val waterSpeedThreshold: Double,
    val waveHeightThreshold: Double,
    val windSpeedThreshold: Double,
    val airTemperatureThreshold: Double,
    val conditionStatus: ConditionStatus = ConditionStatus.NONE_MET,
    val imageId: Int,
    val icon: Int
){
    fun getFlagColorId(
    ): Int {
        return when (conditionStatus) {
            ConditionStatus.ALL_MET -> R.drawable.svg_flag_green_icon
            ConditionStatus.SOME_MET -> R.drawable.svg_flag_orange_icon
            ConditionStatus.NONE_MET -> R.drawable.svg_red_flag_icon
        }
    }
}

enum class ConditionStatus {
    ALL_MET, // Green flag
    SOME_MET, // Yellow flag
    NONE_MET // Red flag
}

object ActivityModels {
    val KAYAKING = ActivityModel(
        "Kayaking",
        waterTemperatureThreshold = 2.0,
        waterSpeedThreshold = 3.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 10.0,
        airTemperatureThreshold = 10.0,
        imageId = R.drawable.kayak_stock,
        icon = R.drawable.kayaking_dark
    )
    val FISHING = ActivityModel(
        "Fishing",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = 2.0,
        waveHeightThreshold = 1.0,
        windSpeedThreshold = 5.0,
        airTemperatureThreshold = 15.0,
        imageId = R.drawable.fisking_stock,
        icon = R.drawable.fishing_icon
    )
    val SAILING = ActivityModel(
        "Sailing",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = 5.0,
        waveHeightThreshold = 2.0,
        windSpeedThreshold = 15.0,
        airTemperatureThreshold = 20.0,
        imageId = R.drawable.sailing_stock,
        icon = R.drawable.sailing_icon
    )
    val ROWING = ActivityModel(
        "Rowing",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = 3.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 8.0,
        airTemperatureThreshold = 15.0,
        imageId = R.drawable.roing_stock,
        icon = R.drawable.rowing_dark
    )
    val PADDLING = ActivityModel(
        "Paddling",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = 3.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 8.0,
        airTemperatureThreshold = 15.0,
        imageId = R.drawable.roing_stock,
        icon = R.drawable.rowing_dark
    )
    val SURFING = ActivityModel(
        "Surfing",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = Double.MAX_VALUE,
        waveHeightThreshold = 3.0,
        windSpeedThreshold = 10.0,
        airTemperatureThreshold = 18.0,
        imageId = R.drawable.surfing_stock,
        icon = R.drawable.surfing_dark
    )
    val SNORKELING = ActivityModel(
        "Snorkeling",
        waterTemperatureThreshold = 18.0,
        waterSpeedThreshold = 2.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 5.0,
        airTemperatureThreshold = 20.0,
        imageId = R.drawable.snorkeling_stock,
        icon = R.drawable.scuba
    )
    val SWIMMING = ActivityModel(
        "Swimming",
        waterTemperatureThreshold = 18.0,
        waterSpeedThreshold = 2.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 5.0,
        airTemperatureThreshold = 20.0,
        imageId = R.drawable.snorkeling_stock,
        icon = R.drawable.swimming_dark
    )
    val WATERSKIING = ActivityModel(
        "Vannski",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = 4.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 12.0,
        airTemperatureThreshold = 20.0,
        imageId = R.drawable.waterski_stock,
        icon = R.drawable.waterski_icon
    )

    val allActivities = listOf(
        KAYAKING,
        FISHING,
        SAILING,
        ROWING,
        PADDLING,
        SURFING,
        SNORKELING,
        SWIMMING,
        WATERSKIING
    )

    // Get an activity object based on its unique string identifier
    fun find(activityName: String): ActivityModel?{
        return allActivities.find { it.activityName == activityName }
    }
}