package no.uio.ifi.in2000.team_21.data

import android.util.Log
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries
import no.uio.ifi.in2000.team_21.model.oceanforecast.Timeseries


class LocationForecastRepository(
    private val dataSource: LocationForecastDataSource = LocationForecastDataSource()) {

    suspend fun fetchLocationForecastResponse(latitude: Double, longitude: Double): LocationForecastResponse? {
        Log.d("LOCATIONFORCAST_REPO", "fetching LocationForcast responses...")
        return dataSource.fetchLocationForecastResponse(latitude, longitude)
    }

    suspend fun fetchLocationForecastTimeseries(latitude: Double, longitude: Double): ArrayList<LocationForecastTimeseries>? {
        Log.d("LOCATIONFORECAST_REPO", "fetching OceanForecast timeseries...")
        return dataSource.fetchLocationForecastTimeseries(latitude, longitude)
    }

    suspend fun fetchLocationForecastTimeseriesByTime(time: String, latitude: Double, longitude: Double): LocationForecastTimeseries? {
        return dataSource.fetchLocationForecastByTime(time, latitude, longitude)
    }

}
