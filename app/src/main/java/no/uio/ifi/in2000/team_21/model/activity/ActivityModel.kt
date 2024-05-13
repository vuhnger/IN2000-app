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
    var conditionDescription: String = "",
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
    fun getFlagDescription(
    ): String {
        return when (conditionStatus) {
            ConditionStatus.ALL_MET -> "Perfekt tidspunkt for ${activityName.lowercase()}"
            ConditionStatus.SOME_MET -> "Forholdene er moderate for ${activityName.lowercase()}"
            ConditionStatus.NONE_MET -> "Vær forsiktig og følg advarsler"
        }
    }

    fun getFlagData(
    ): Pair<Int, String> {
        return Pair(getFlagColorId(), getFlagDescription())
    }
}

enum class ConditionStatus {
    ALL_MET, // Green flag
    SOME_MET, // Yellow flag
    NONE_MET // Red flag
}

object ActivityModels {
    val KAYAKING = ActivityModel(
        "Kajakk",
        waterTemperatureThreshold = 2.0,
        waterSpeedThreshold = 3.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 10.0,
        airTemperatureThreshold = 10.0,
        imageId = R.drawable.kayaking_ai,
        icon = R.drawable.kayaking_dark
    )
    val FISHING = ActivityModel(
        "Fisking",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = 2.0,
        waveHeightThreshold = 1.0,
        windSpeedThreshold = 5.0,
        airTemperatureThreshold = 15.0,
        imageId = R.drawable.fishing_ai,
        icon = R.drawable.fishing_icon
    )
    val SAILING = ActivityModel(
        "Seiling",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = 5.0,
        waveHeightThreshold = 2.0,
        windSpeedThreshold = 15.0,
        airTemperatureThreshold = 20.0,
        imageId = R.drawable.sailing2_ai,
        icon = R.drawable.sailing_icon
    )
    val ROWING = ActivityModel(
        "Roing",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = 3.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 8.0,
        airTemperatureThreshold = 15.0,
        imageId = R.drawable.rowing_ai,
        icon = R.drawable.final_rowing
    )
    val PADDLING = ActivityModel(
        "Padling",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = 3.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 8.0,
        airTemperatureThreshold = 5.0,
        imageId = R.drawable.padling_ai,
        icon = R.drawable.rowing_icon
    )
    val SURFING = ActivityModel(
        "Surfing",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = Double.MAX_VALUE,
        waveHeightThreshold = 3.0,
        windSpeedThreshold = 10.0,
        airTemperatureThreshold = 8.0,
        imageId = R.drawable.surfing_ai,
        icon = R.drawable.surfing_dark
    )
    val SNORKELING = ActivityModel(
        "Snorkle",
        waterTemperatureThreshold = 18.0,
        waterSpeedThreshold = 2.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 5.0,
        airTemperatureThreshold = 0.0,
        imageId = R.drawable.snorkelig_ai,
        icon = R.drawable.scuba_dark
    )
    val SWIMMING = ActivityModel(
        "Svømme",
        waterTemperatureThreshold = 18.0,
        waterSpeedThreshold = 2.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 5.0,
        airTemperatureThreshold = 20.0,
        imageId = R.drawable.swimming_ai,
        icon = R.drawable.swimming_dark
    )
    val WATERSKIING = ActivityModel(
        "Vannski",
        waterTemperatureThreshold = 5.0,
        waterSpeedThreshold = 4.0,
        waveHeightThreshold = 0.5,
        windSpeedThreshold = 12.0,
        airTemperatureThreshold = 20.0,
        imageId = R.drawable.waterski_ai,
        icon = R.drawable.waterski_icon
    )

    var CUSTOM_ACTIVITY = ActivityModel(
        activityName = "",
        waterTemperatureThreshold = 0.0,
        waterSpeedThreshold = 0.0,
        waveHeightThreshold = 0.0,
        windSpeedThreshold = 0.0,
        airTemperatureThreshold = 0.0,
        imageId = R.drawable.default_img,
        icon = R.drawable.running_icon_free_vector
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