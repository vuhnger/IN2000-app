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
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForcastResponse
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries
class LocationForcastDataSource {

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

    suspend fun fetchLocationForcastResponse(): LocationForcastResponse? {

        val response: HttpResponse = client.get("https://in2000.api.met.no/weatherapi/locationforecast/2.0/complete?lat=59.93&lon=10.72")

        Log.d("LOCATION_DATA_SOURCE", "fetchLocationForcastResponse() status code: ${response.status.value}")

        return if (response.status.value in 200..299) {
            response.body()
        }
        else{
            null
        }
    }

    suspend fun fetchLocationForecastTimeseries(): ArrayList<LocationForecastTimeseries>? {
        val response = fetchLocationForcastResponse()
        return response?.properties?.timeseries
    }


}