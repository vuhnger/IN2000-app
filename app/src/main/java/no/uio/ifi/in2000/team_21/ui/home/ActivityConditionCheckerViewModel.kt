package no.uio.ifi.in2000.team_21.ui.home

import android.util.Log
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


class ActivityConditionCheckerViewModel(
    private val oceanRepository: OceanForecastRepository = OceanForecastRepository(),
    private val locationRepository: LocationForecastDataRepository = LocationForecastDataRepository()
) : ViewModel() {

    private var _activities: MutableLiveData<List<ActivityModel>> = MutableLiveData()
    val activities: LiveData<List<ActivityModel>> get() = _activities

    init {
        _activities.value = allActivities
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

                // Update areConditionsMet based on combined data
                activity.copy(
                    areConditionsMet = isWeatherOptimalForActivity(oceanDetails, locationDetails, activity)
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
    ): Boolean {
        val waterTemperatureSuitable = (oceanDetails.sea_water_temperature ?: 0.0) >= activity.waterTemperatureThreshold
        val waterSpeedSuitable = (oceanDetails.sea_water_speed ?: Double.MAX_VALUE) <= activity.waterSpeedThreshold
        val waveHeightSuitable = (oceanDetails.sea_surface_wave_height ?: Double.MAX_VALUE) <= activity.waveHeightThreshold

        val airTemperatureSuitable = (locationDetails.air_temperature
            ?: Double.MIN_VALUE) >= (activity.airTemperatureThreshold
            ?: Double.MIN_VALUE)
        val windSpeedSuitable =
            (locationDetails.wind_speed ?: Double.MAX_VALUE) <= (activity.windSpeedThreshold
                ?: Double.MAX_VALUE)
        // Legg til flere skjekker

        return waterTemperatureSuitable && waterSpeedSuitable && waveHeightSuitable && airTemperatureSuitable && windSpeedSuitable
    }
}