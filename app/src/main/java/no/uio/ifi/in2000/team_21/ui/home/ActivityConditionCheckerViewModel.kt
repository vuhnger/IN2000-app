package no.uio.ifi.in2000.team_21.ui.home

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
                    activity.copy(
                        conditionStatus = isWeatherOptimalForActivity(
                            weatherDetails = relevantDetails,
                            activity = activity
                        )
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

    private fun isWeatherOptimalForActivity(
        weatherDetails: WeatherDetails,
        activity: ActivityModel
    ): ConditionStatus {
        val conditions = listOf(
            (weatherDetails.seaWaterTemperature ?: 0.0) >= activity.waterTemperatureThreshold,
            (weatherDetails.seaWaterSpeed ?: Double.MAX_VALUE) <= activity.waterSpeedThreshold,
            (weatherDetails.seaSurfaceWaveHeight ?: Double.MAX_VALUE) <= activity.waveHeightThreshold,
            (weatherDetails.airTemperature ?: Double.MIN_VALUE) >= (activity.airTemperatureThreshold),
            (weatherDetails.windSpeed ?: Double.MAX_VALUE) <= (activity.windSpeedThreshold)
        )

        return when (conditions.count { it }) {
            conditions.size -> ConditionStatus.ALL_MET
            0 -> ConditionStatus.NONE_MET
            else -> ConditionStatus.SOME_MET
        }
    }
}