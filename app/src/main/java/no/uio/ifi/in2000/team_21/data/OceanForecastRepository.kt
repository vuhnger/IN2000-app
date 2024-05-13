package no.uio.ifi.in2000.team_21.data

import android.util.Log
import androidx.compose.material3.rememberDatePickerState
import no.uio.ifi.in2000.team_21.model.oceanforecast.OceanForecastResponse
import no.uio.ifi.in2000.team_21.model.oceanforecast.Timeseries



class OceanForecastRepository(
    private val dataSource: OceanForecastDataSource = OceanForecastDataSource()
) {

    val cachedResponseData: HashMap<String, OceanForecastResponse> = HashMap()
    val cachedTimeseriesData: HashMap<String, Timeseries> = HashMap()

    suspend fun fetchOceanForecastResponse(
        latitude: Double,
        longitude: Double
    ): OceanForecastResponse? {

        val cacheKey = "$latitude$longitude"

        Log.d("OCEANFORCAST_REPO", "fetching OceanForecast responses...")

        if (cachedResponseData[cacheKey] != null){
            return cachedResponseData[cacheKey]
        }

        val response: OceanForecastResponse? = dataSource.fetchOceanForecastResponse(
            latitude = latitude,
            longitude = longitude
        )
        response?.let { cachedResponseData[cacheKey] = it }
        return response
    }

    suspend fun fetchOceanForecastTimeseriesByTime(time: String, latitude: Double, longitude: Double): Timeseries? {

        val cacheKey = "$time$latitude$longitude"

        if (cachedTimeseriesData[cacheKey] != null){
            return cachedTimeseriesData[cacheKey]
        }

        val reseponse: Timeseries? = dataSource.fetchOceanForecastByTime(time, latitude, longitude)

        reseponse?.let { cachedTimeseriesData[cacheKey] = it }
        return reseponse
    }
}
