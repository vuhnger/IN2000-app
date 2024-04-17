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
import no.uio.ifi.in2000.team_21.model.locationforecast.Response
import java.nio.channels.UnresolvedAddressException

open class LocationForecastDataSource {


    private var lat: Double = 59.921499
    private var lon: Double = 10.673347
    private val altitude = 1

    private val url = "https://api.met.no/weatherapi/locationforecast/2.0/complete?lat=$lat&lon=$lon"

    //private val url = "https://api.met.no/weatherapi/locationforecast/2.0/complete?lat=59.92&lon=10.67"

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

    suspend fun TESTfetchForecast(lat: Double = this.lat, long: Double = lon): Response? {

        val response: HttpResponse = client.get(url)

        return if (response.status.value in 200..299) {
            response.body()
        }
        else{
            null
        }
    }

    suspend fun fetchForecast(lat: Double = 52.52, long: Double = 13.405): Response? {

        try {

            Log.d(
                "LFC_DATA_SOURCE",
                "fetchForecast() fetching from url: $url"
            )

            val response: HttpResponse = client.get(url)

            Log.d(
                "LFC_DATA_SOURCE",
                "fetchForecast() returned code ${response.status.value}"
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
                "failed to fatch forecast:" +
                    "\nCause:${e.cause}" +
                        "\nMessage:${e.message}" +
                        "\nError: $e" +
                        "\nStacktrace: ${e.stackTrace}"
            )
        }

        return null
    }
}
