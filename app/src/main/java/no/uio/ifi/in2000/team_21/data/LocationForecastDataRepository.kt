package no.uio.ifi.in2000.team_21.data

import android.util.Log
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries

class LocationForecastDataRepository(private val dataSource: LocationForecastDataSource = LocationForecastDataSource()) {


    val cachedResponseData: HashMap<String, LocationForecastResponse> = HashMap()
    val cachedTimeseriesData: HashMap<String, LocationForecastTimeseries> = HashMap()

    suspend fun fetchForecast(
        latitude: Double,
        longitude: Double
    ): LocationForecastResponse? {

        val cacheKey = "$latitude:$longitude"

        if (cachedResponseData[cacheKey] != null) {
            return cachedResponseData[cacheKey]
        }

        val response: LocationForecastResponse? = dataSource.fetchLocationForecastResponse(
            latitude = latitude,
            longitude = longitude
        )

        response?.let { cachedResponseData[cacheKey] = it }
        return response
    }

    suspend fun fetchWeatherDataForLocation(lat: Double, lon: Double): List<LocationForecastTimeseries>? {
        return dataSource.fetchLocationForecastTimeseries(lat, lon)
    }

    suspend fun fetchLocationForecastTimeseriesByTime(time: String, latitude: Double, longitude: Double): LocationForecastTimeseries? {

        val cacheKey = "$time$latitude$longitude"

        val cachedData = cachedTimeseriesData[cacheKey]


        if (cachedData != null) {
            return cachedData
        }

        Log.d(
            "LFC_DATA_REPO",
            "fetching LFCTimeSeriesByTime from network. time: $time, lat: $latitude, long: $longitude"
        )
        val networkData = dataSource.fetchLocationForecastByTime(time = time, latitude = latitude, longitude = longitude)
        networkData?.let { cachedTimeseriesData[cacheKey] = it }
        return networkData
    }

}