package no.uio.ifi.in2000.team_21.data

import android.util.Log
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries

class LocationForecastDataRepository(private val dataSource: LocationForecastDataSource = LocationForecastDataSource()) {


    suspend fun fetchForecast(): LocationForecastResponse? {
        return dataSource.fetchLocationForecastResponse(60.0, 10.0)
    }

    // Timeseries er værmeldinger
    suspend fun fetchTimeseries(): ArrayList<LocationForecastTimeseries>? {

        Log.d("FORECAST_REPO","fetching timeseries.")

        return dataSource.fetchLocationForecastTimeseries(60.0, 10.0)
    }

    suspend fun fetchImageIcons(): ArrayList<String> {
        val timeseries = fetchTimeseries()
        val icons = ArrayList<String>()

        Log.d("FORECAST_REPO", "timeseries size: ${timeseries?.size}")

        timeseries?.forEach { timeseries ->
            timeseries.data?.next_1_hours?.summary?.symbol_code?.let { symbolCode ->
                println(symbolCode)
                // Add only if symbolCode is not null
                icons.add(symbolCode)
            }
        }
        Log.d("LOCATION_REPO","fetched ${icons.size} icons")
        return icons
    }

    suspend fun fetchWeatherDataForLocation(lat: Double, lon: Double): List<LocationForecastTimeseries>? {
        return dataSource.fetchLocationForecastTimeseries(lat, lon)
    }

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

    fun fetchAirTemperatureAtTime(time: String) {

    }

}