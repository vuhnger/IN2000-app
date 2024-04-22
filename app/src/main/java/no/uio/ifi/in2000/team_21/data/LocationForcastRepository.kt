package no.uio.ifi.in2000.team_21.data

import android.util.Log
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForcastResponse
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries


class LocationForcastRepository(private val dataSource: LocationForcastDataSource = LocationForcastDataSource()) {

    suspend fun fetchLocationForcastResponse(): LocationForcastResponse? {
        Log.d("LOCATIONFORCAST_REPO", "fetching LocationForcast responses...")
        return dataSource.fetchLocationForcastResponse()
    }

    suspend fun fetchLocationForecastTimeseries(): ArrayList<LocationForecastTimeseries>? {
        Log.d("LOCATIONFORECAST_REPO", "fetching OceanForecast timeseries...")
        return dataSource.fetchLocationForecastTimeseries()
    }

    suspend fun fetchAirTemperatureAtTime(time: String): Double? {
        val timeseries = fetchLocationForecastTimeseries()
        return timeseries?.find { it.time == time }?.data?.instant?.details?.air_temperature
    }
}
