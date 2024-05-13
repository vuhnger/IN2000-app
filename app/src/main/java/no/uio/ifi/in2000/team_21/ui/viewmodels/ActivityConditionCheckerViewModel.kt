package no.uio.ifi.in2000.team_21.ui.viewmodels

import no.uio.ifi.in2000.team_21.model.oceanforecast.Details
import no.uio.ifi.in2000.team_21.model.locationforcast.Details as LocationDetails
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.LocationForecastDataRepository
import no.uio.ifi.in2000.team_21.data.OceanForecastRepository

import no.uio.ifi.in2000.team_21.model.activity.ActivityModel
import no.uio.ifi.in2000.team_21.model.activity.ActivityModels.allActivities
import no.uio.ifi.in2000.team_21.model.activity.ConditionStatus
    
open class ActivityConditionCheckerViewModel : ViewModel() {

    private val oceanRepository: OceanForecastRepository = OceanForecastRepository()

    private val locationRepository: LocationForecastDataRepository = LocationForecastDataRepository()

    private var _activities: MutableLiveData<List<ActivityModel>> = MutableLiveData()
    val activities: LiveData<List<ActivityModel>> get() = _activities

    init {
        _activities.value = allActivities
    }

    fun get(
        activityName: String
    ): ActivityModel? {
        return activities.value?.find {
            it.activityName == activityName
        }
    }

    fun checkActivityConditions(
        time: String,
        latitude: Double,
        longitude: Double
    ) {
        viewModelScope.launch {
            val oceanData = oceanRepository.fetchOceanForecastTimeseriesByTime(
                time = time,
                latitude = latitude,
                longitude = longitude
            )
            val locationData = locationRepository.fetchLocationForecastTimeseriesByTime(
                time = time,
                latitude = latitude,
                longitude = longitude
            )

            val updatedActivities = _activities.value?.map { activity ->
                val relevantDetails = getRelevantWeatherDetails(
                    oceanData?.data?.instant?.details,
                    locationData?.data?.instant?.details
                )
                val conditionsMet = getWeatherConditionsMet(relevantDetails, activity)
                val conditionStatus = isWeatherOptimalForActivity(conditionsMet)

                activity.copy(
                    conditionStatus = conditionStatus,
                    conditionDescription = getConditionDescription(activity, conditionsMet)
                )
            } ?: emptyList()
            _activities.value = updatedActivities
        }
    }

    private data class WeatherDetails(
        val seaWaterTemperature: Double?,
        val seaWaterSpeed: Double?,
        val seaSurfaceWaveHeight: Double?,
        val airTemperature: Double?,
        val windSpeed: Double?
    )

    private fun getRelevantWeatherDetails(oceanDetails: Details?, locationDetails: LocationDetails?): WeatherDetails {
        return WeatherDetails(
            seaWaterTemperature = oceanDetails?.sea_water_temperature,
            seaWaterSpeed = oceanDetails?.sea_water_speed,
            seaSurfaceWaveHeight = oceanDetails?.sea_surface_wave_height,
            airTemperature = locationDetails?.air_temperature,
            windSpeed = locationDetails?.wind_speed
        )
    }


    private fun getWeatherConditionsMet(
        weatherDetails: WeatherDetails,
        activity: ActivityModel
    ): Map<String, Boolean> {
        val conditionsMet = mutableMapOf<String, Boolean>()

        conditionsMet["Vannets temperatur"] = (weatherDetails.seaWaterTemperature ?: 0.0) >= activity.minWaterTemperature
        conditionsMet["Vannets hastighet"] = (weatherDetails.seaWaterSpeed ?: Double.MAX_VALUE) <= activity.maxWaterSpeed
        conditionsMet["Bølgehøyde"] = (weatherDetails.seaSurfaceWaveHeight ?: Double.MAX_VALUE) <= activity.maxWaveHeight
        conditionsMet["Lufttemperatur"] = (weatherDetails.airTemperature ?: Double.MIN_VALUE) >= (activity.minAirTemperature)
        conditionsMet["Vindhastighet"] = (weatherDetails.windSpeed ?: Double.MAX_VALUE) <= (activity.maxWindSpeed)
        return conditionsMet
    }

    private fun isWeatherOptimalForActivity(
        conditionsMet: Map<String, Boolean>
    ): ConditionStatus {
        val allConditionsMet = conditionsMet.values.all { it }
        val noConditionsMet = conditionsMet.values.none { it }

        return when {
            allConditionsMet -> ConditionStatus.ALL_MET
            noConditionsMet -> ConditionStatus.NONE_MET
            else -> ConditionStatus.SOME_MET
        }
    }

    private fun getConditionDescription(
        activity: ActivityModel,
        conditionsMet: Map<String, Boolean>
    ): String {
        val descriptionBuilder = StringBuilder()
        with(descriptionBuilder) {
            //appendLine("Forholdene for ${activity.activityName} er nå:")
            conditionsMet.forEach { (condition, conditionMet) ->
                val icon = if (conditionMet) "✅" else "❌"
                appendLine("$condition: $icon")
            }
        }
        return descriptionBuilder.toString()
    }
}

