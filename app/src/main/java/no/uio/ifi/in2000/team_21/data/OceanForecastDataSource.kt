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
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.team_21.model.oceanforecast.Response
import no.uio.ifi.in2000.team_21.model.oceanforecast.Timeseries

open class OceanForecastDataSource {

    private var latitude: Double = 59.0
    private var longitude: Double = 5.0

    fun setCoordinates(newLatitude: Double, newLongitude: Double) {
        latitude = newLatitude
        longitude = newLongitude
    }

    private fun buildOceanForecastURL(): String {
        return "https://api.met.no/weatherapi/oceanforecast/2.0/complete?" +
                "lat=$latitude" +
                "&lon=$longitude"
    }


    @OptIn(ExperimentalSerializationApi::class)
    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(
                Json {
                    explicitNulls = false
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
        install(Logging){
            level = LogLevel.BODY
        }
    }

    suspend fun fetchOceanForecastResponse(): Response? {

        val url = buildOceanForecastURL()

        val response: HttpResponse = client.get(url)

        Log.d("OCEAN_DATA_SOURCE", "fetchForecast() status code: ${response.status.value}")

        return if (response.status.value in 200..299) {
            response.body()
        }
        else{
            null
        }
    }

    suspend fun fetchOceanForecastTimeseries(): ArrayList<Timeseries>? {
        val response = fetchOceanForecastResponse()
        return response?.properties?.timeseries
    }
}