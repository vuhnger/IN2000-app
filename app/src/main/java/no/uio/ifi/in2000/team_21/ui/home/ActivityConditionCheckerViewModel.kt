package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
import no.uio.ifi.in2000.team_21.model.oceanforecast.Details
import no.uio.ifi.in2000.team_21.model.locationforcast.Details as LocationDetails
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.data.LocationForecastRepository
import no.uio.ifi.in2000.team_21.data.OceanForecastRepository
import no.uio.ifi.in2000.team_21.model.ActivityModel
import no.uio.ifi.in2000.team_21.model.ActivityModels.allActivities
import no.uio.ifi.in2000.team_21.model.ConditionStatus


open class ActivityConditionCheckerViewModel(
    private val oceanRepository: OceanForecastRepository = OceanForecastRepository(),
    private val locationRepository: LocationForecastRepository = LocationForecastRepository()
) : ViewModel() {

    private var _activities: MutableLiveData<List<ActivityModel>> = MutableLiveData()
    val activities: LiveData<List<ActivityModel>> get() = _activities

    init {
        _activities.value = allActivities
    }

    fun useDummyData() {
        val dummyData = listOf(
            ActivityModel("Surfing", 5.0, 5.0, 3.0, 10.0, 18.0, conditionStatus = ConditionStatus.ALL_MET),
            ActivityModel("Swimming", 18.0, 2.0, 0.5, 5.0, 20.0, conditionStatus = ConditionStatus.ALL_MET),
            ActivityModel("Fishing", 5.0, 2.0, 1.0, 5.0, 15.0, conditionStatus = ConditionStatus.SOME_MET),
            ActivityModel("Boating", 5.0, 4.0, 0.5, 12.0, 20.0, conditionStatus = ConditionStatus.SOME_MET),
            ActivityModel("Kayaking & Canoeing", 2.0, 3.0, 0.5, 10.0, 10.0, conditionStatus = ConditionStatus.ALL_MET),
            ActivityModel("Sailing", 5.0, 5.0, 2.0, 15.0, 20.0, conditionStatus = ConditionStatus.NONE_MET),
            ActivityModel("Rowing & Paddling", 5.0, 3.0, 0.5, 8.0, 15.0, conditionStatus = ConditionStatus.ALL_MET),
            ActivityModel("Snorkeling & Swimming", 18.0, 2.0, 0.5, 5.0, 20.0, conditionStatus = ConditionStatus.NONE_MET),
            ActivityModel("Vannski", 5.0, 4.0, 0.5, 12.0, 20.0, conditionStatus = ConditionStatus.NONE_MET)
        )
        _activities.value = dummyData
    }

    fun checkActivityConditions(time: String, latitude: Double, longitude: Double) {
        viewModelScope.launch {
            Log.d("ActivityViewModel", "Fetching ocean timeseries for time: $time")
            val oceanTimeseries = oceanRepository.fetchOceanForecastTimeseriesByTime(time, latitude, longitude)
            Log.d("ActivityViewModel", "Fetched ocean timeseries: $oceanTimeseries")

            Log.d("ActivityViewModel", "Fetching location forecast for time: $time")
            val locationData = locationRepository.fetchLocationForecastTimeseriesByTime(time, latitude, longitude)
            Log.d("ActivityViewModel", "Fetched location forecast: $locationData")

            val currentActivities = _activities.value ?: emptyList()

            val updatedActivities = currentActivities.map { activity ->
                val oceanDetails = oceanTimeseries?.data?.instant?.details ?: return@map activity
                val locationDetails = locationData?.data?.instant?.details ?: return@map activity

                // Update conditionStatus based on combined data
                activity.copy(
                    conditionStatus = isWeatherOptimalForActivity(oceanDetails, locationDetails, activity)
                )
            }

            _activities.value = updatedActivities
            Log.d("ActivityViewModel", "Updated activities: $updatedActivities")
        }
    }

    private fun isWeatherOptimalForActivity(
        oceanDetails: Details,
        locationDetails: LocationDetails,
        activity: ActivityModel
    ): ConditionStatus {
        val conditions = listOf(
            (oceanDetails.sea_water_temperature ?: 0.0) >= activity.waterTemperatureThreshold,
            (oceanDetails.sea_water_speed ?: Double.MAX_VALUE) <= activity.waterSpeedThreshold,
            (oceanDetails.sea_surface_wave_height ?: Double.MAX_VALUE) <= activity.waveHeightThreshold,
            (locationDetails.air_temperature ?: Double.MIN_VALUE) >= (activity.airTemperatureThreshold ?: Double.MIN_VALUE),
            (locationDetails.wind_speed ?: Double.MAX_VALUE) <= (activity.windSpeedThreshold ?: Double.MAX_VALUE)
        )

        return when (conditions.count { it }) {
            conditions.size -> ConditionStatus.ALL_MET
            0 -> ConditionStatus.NONE_MET
            else -> ConditionStatus.SOME_MET
        }
    }
}