package no.uio.ifi.in2000.team_21.model.activity

import no.uio.ifi.in2000.team_21.R

data class ActivityModel(
    val activityName: String,
    val minWaterTemperature: Double,
    val maxWaterSpeed: Double,
    val maxWaveHeight: Double,
    val maxWindSpeed: Double,
    val minAirTemperature: Double,
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
        minWaterTemperature = 2.0,
        maxWaterSpeed = 3.0,
        maxWaveHeight = 0.5,
        maxWindSpeed = 10.0,
        minAirTemperature = 10.0,
        imageId = R.drawable.kayaking_ai,
        icon = R.drawable.kayaking_dark
    )
    val FISHING = ActivityModel(
        "Fisking",
        minWaterTemperature = 5.0,
        maxWaterSpeed = 2.0,
        maxWaveHeight = 1.0,
        maxWindSpeed = 5.0,
        minAirTemperature = 15.0,
        imageId = R.drawable.fishing_ai,
        icon = R.drawable.fishing_icon
    )
    val SAILING = ActivityModel(
        "Seiling",
        minWaterTemperature = 5.0,
        maxWaterSpeed = 5.0,
        maxWaveHeight = 2.0,
        maxWindSpeed = 15.0,
        minAirTemperature = 20.0,
        imageId = R.drawable.sailing2_ai,
        icon = R.drawable.sailing_icon
    )
    val ROWING = ActivityModel(
        "Roing",
        minWaterTemperature = 5.0,
        maxWaterSpeed = 3.0,
        maxWaveHeight = 0.5,
        maxWindSpeed = 8.0,
        minAirTemperature = 15.0,
        imageId = R.drawable.rowing_ai,
        icon = R.drawable.final_rowing
    )
    val PADDLING = ActivityModel(
        "Padling",
        minWaterTemperature = 5.0,
        maxWaterSpeed = 3.0,
        maxWaveHeight = 0.5,
        maxWindSpeed = 8.0,
        minAirTemperature = 5.0,
        imageId = R.drawable.padling_ai,
        icon = R.drawable.rowing_icon
    )
    val SURFING = ActivityModel(
        "Surfing",
        minWaterTemperature = 5.0,
        maxWaterSpeed = Double.MAX_VALUE,
        maxWaveHeight = 3.0,
        maxWindSpeed = 10.0,
        minAirTemperature = 8.0,
        imageId = R.drawable.surfing_ai,
        icon = R.drawable.surfing_dark
    )
    val SNORKELING = ActivityModel(
        "Snorkle",
        minWaterTemperature = 18.0,
        maxWaterSpeed = 2.0,
        maxWaveHeight = 0.5,
        maxWindSpeed = 5.0,
        minAirTemperature = 0.0,
        imageId = R.drawable.snorkelig_ai,
        icon = R.drawable.scuba_dark
    )
    val SWIMMING = ActivityModel(
        "Svømme",
        minWaterTemperature = 18.0,
        maxWaterSpeed = 2.0,
        maxWaveHeight = 0.5,
        maxWindSpeed = 5.0,
        minAirTemperature = 20.0,
        imageId = R.drawable.swimming_ai,
        icon = R.drawable.swimming_dark
    )
    val WATERSKIING = ActivityModel(
        "Vannski",
        minWaterTemperature = 5.0,
        maxWaterSpeed = 4.0,
        maxWaveHeight = 0.5,
        maxWindSpeed = 12.0,
        minAirTemperature = 20.0,
        imageId = R.drawable.waterski_ai,
        icon = R.drawable.waterski_icon
    )

    var CUSTOM_ACTIVITY = ActivityModel(
        activityName = "",
        minWaterTemperature = 0.0,
        maxWaterSpeed = 0.0,
        maxWaveHeight = 0.0,
        maxWindSpeed = 0.0,
        minAirTemperature = 0.0,
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