package no.uio.ifi.in2000.team_21.data.database

import no.uio.ifi.in2000.team_21.R

object ActivityIconMapper {
    private val iconMap = mapOf(
        "Kayaking" to R.drawable.kayaking_dark,
        "Fishing" to R.drawable.fishing_icon,
        "Sailing" to R.drawable.sailing_icon,
        "Rowing & Paddling" to R.drawable.rowing_dark,
        "Surfing" to R.drawable.surfing_dark,
        "Snorkeling & Swimming" to R.drawable.snorkeling_stock,
        "Vannski" to R.drawable.waterski_icon
    )

    fun getIcon(activityName: String): Int {
        return iconMap[activityName] ?: R.drawable.fishing_icon
    }
/*
    fun getModelForActivity(activityName: String): ActivityModel {
        return when(activityName) {
            "Kayaking & Canoeing" -> ActivityModels.KAYAKING_CANOEING
            "Fishing" -> ActivityModels.FISHING
            "Rowing & Paddling" -> ActivityModels.ROWING_PADDLING
            "Sailing" -> ActivityModels.SAILING
            "Snorkeling & Swimming" -> ActivityModels.SNORKELING_SWIMMING
            "Surfing" -> ActivityModels.SURFING
            "Vannski" -> ActivityModels.WATERSKIING
            else -> throw IllegalArgumentException("Unknown activity")
        }
    }

 */
}