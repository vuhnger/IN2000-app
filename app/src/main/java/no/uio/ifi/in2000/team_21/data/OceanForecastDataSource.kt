package no.uio.ifi.in2000.team_21.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.appendIfNameAbsent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.team_21.model.oceanforecast.Response
import no.uio.ifi.in2000.team_21.model.oceanforecast.Timeseries

open class OceanForecastDataSource {

    private var latitude: Double = 59.0
    private var longitude: Double = 3.0

    fun setCoordinates(newLatitude: Double, newLongitude: Double) {
        latitude = newLatitude
        longitude = newLongitude
    }


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

    suspend fun fetchOceanForecastResponse(): Response? {
        return try {
            val response: HttpResponse = client.get("https://in2000.api.met.no/weatherapi/oceanforecast/2.0/complete?lat=59.0&lon=3.0")
            Log.d("OCEAN_DATA_SOURCE", "fetchForecast() status code: ${response.status.value}")
            if (response.status.value in 200..299) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun fetchOceanForecastTimeseries(): ArrayList<Timeseries>? {
        val response = fetchOceanForecastResponse()
        return response?.properties?.timeseries
    }
}