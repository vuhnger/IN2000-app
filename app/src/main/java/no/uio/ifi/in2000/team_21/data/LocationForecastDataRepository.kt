package no.uio.ifi.in2000.team_21.data

import android.util.Log
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries

class LocationForecastDataRepository(private val dataSource: LocationForecastDataSource = LocationForecastDataSource()) {


    val cachedResponseData: HashMap<String, LocationForecastTimeseries>? = null

    suspend fun fetchForecast(
        latitude: Double,
        longitude: Double
    ): LocationForecastResponse? {
        return dataSource.fetchLocationForecastResponse(
            latitude = latitude,
            longitude = longitude
        )
    }

    // Timeseries er værmeldinger
    suspend fun fetchTimeseries(
        latitude: Double,
        longitude: Double
    ): ArrayList<LocationForecastTimeseries>? {

        Log.d("FORECAST_REPO","fetching timeseries.")

        return dataSource.fetchLocationForecastTimeseries(
            latitude = latitude,
            longitude =  longitude
        )
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

        Log.d(
            "LFC_DATA_REPO",
            "fetch LFCTimeSeriesByTime recieved time: $time, lat: $latitude, long: $longitude"
        )

        return dataSource.fetchLocationForecastByTime(time = time, latitude = latitude, longitude = longitude)
    }

    fun convertFromCels(
        n: Double
    ): Double {
        return (n - 32) * 5.0/9.0
    }

    fun convertWindSpeedMpsToMph(
        windSpeedMps: Double
    ): Double {
        return windSpeedMps * 2.2369
    }

    fun convertPrecipitationMmToInches(
        precipitationMm: Double
    ): Double {
        return precipitationMm * 0.03937
    }



}