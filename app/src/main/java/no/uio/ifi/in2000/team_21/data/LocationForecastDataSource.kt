
package no.uio.ifi.in2000.team_21.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries

class LocationForecastDataSource {

    private var latitude: Double = 59.93
    private var longitude: Double = 10.72
    private var altitude: Int = 90


    private val client = HttpClient() {
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
    }

    suspend fun fetchLocationForecastResponse(latitude: Double, longitude: Double): LocationForecastResponse? {

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

    suspend fun fetchForecastForLocation(lat: Double, lon: Double): LocationForecastResponse? {
        val url = "https://api.met.no/weatherapi/locationforecast/2.0/complete?" +
                "lat=$lat" +
                "&lon=$lon"

        val response: HttpResponse = client.get(url)

        return if (response.status.value in 200..299) {
            response.body()
        } else {
            null
        }
    }

    suspend fun fetchCurrentAirTemperature(): Double {

        val response: LocationForecastResponse? = fetchForecast()

        return response?.properties?.timeseries?.first()?.data?.instant?.details?.air_temperature ?: 0.0

    }

    suspend fun repositoryfetchNextHourWeatherIcon(): String {

        val response: LocationForecastResponse? = fetchForecast()

        return response?.properties?.timeseries?.first()?.data?.next_1_hours?.summary?.symbol_code ?: ""

    }

        suspend fun fetchForecast(): LocationForecastResponse? {

            val response: HttpResponse = client.get("https://api.met.no/weatherapi/locationforecast/2.0/complete?" +
                    "lat=$latitude" +
                    "&lon=$longitude")

            /*
            *
            Log.d(
                "LFC_DATA_SOURCE",
                "fetchForecast() returned code ${response.status.value}"
            )
            *
            * */

            return if (response.status.value in 200..299) {
                response.body()
            }
            else{
                null
            }
        }




}