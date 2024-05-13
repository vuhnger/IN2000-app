
package no.uio.ifi.in2000.team_21.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.appendIfNameAbsent
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries
import java.nio.channels.UnresolvedAddressException

class LocationForecastDataSource {


    private val client = HttpClient() {

        val TIMEOUT_MS: Long = (30_000.0 * 5).toLong()

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    encodeDefaults = true
                }
            )
        }
        install(Logging){
            level = LogLevel.BODY
        }
        install(HttpTimeout){
            requestTimeoutMillis = TIMEOUT_MS
            connectTimeoutMillis = TIMEOUT_MS
            socketTimeoutMillis = TIMEOUT_MS
        }
        defaultRequest {
            url("https://gw-uio.intark.uh-it.no/in2000/")
            headers.appendIfNameAbsent(
                name = "X-Gravitee-API-Key",
                value = "eff58995-389e-4cd2-816f-4c6728aeec6e"
            )
        }
    }

    suspend fun fetchLocationForecastResponse(
        latitude: Double,
        longitude: Double
    ): LocationForecastResponse? {

        try {

            Log.d(
                "LOCATION_DATA_SOURCE",
                "attempting fetch from lat: $latitude and long: $longitude"
            )

            val response: HttpResponse = client.get("https://in2000.api.met.no/weatherapi/locationforecast/2.0/complete?lat=${latitude}3&lon=$longitude")

            Log.d(
                "LOCATION_DATA_SOURCE",
                "fetchLocationForcastResponse() status code: ${response.status.value} for lat: $latitude and long: $longitude"
            )

            return if (response.status.value in 200..299) {
                response.body()
            }
            else{
                null
            }

        }catch (e: UnresolvedAddressException){
            Log.d(
                "LFC_DATASOURCE",
                "could not fetch from URL: ${e.stackTrace}"
            )
        }
        return null
    }

    suspend fun fetchLocationForecastTimeseries(latitude: Double, longitude: Double): ArrayList<LocationForecastTimeseries>? {

        Log.d(
            "LFC_DATA_SOURCE",
            "fetchLCFCTimeseries at lat: $latitude and long: $longitude"
        )

        val response = fetchLocationForecastResponse(latitude, longitude)

        return response?.properties?.timeseries
    }

    suspend fun fetchLocationForecastByTime(time: String, latitude: Double, longitude: Double): LocationForecastTimeseries? {
        val timeseries = fetchLocationForecastTimeseries(latitude, longitude)

        val return_value = timeseries?.find { it.time?.contains(time, ignoreCase = true) ?: false}

        Log.d(
            "LOCATION_FORECAST_DATA_SOURCE",
            "fetched LocationForecast by time: $time at lat$latitude long$longitude and returned $return_value"
        )

        return return_value
    }

}