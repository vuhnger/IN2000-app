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

open class LocationForecastDataSource {

    private val url = "https://api.met.no/weatherapi/locationforecast/2.0/complete?lat=60.10&lon=10"

    private val client = HttpClient() {
        install(ContentNegotiation) {
            json()
        }
        install(Logging){
            level = LogLevel.BODY
        }
    }

    suspend fun fetchForecast(): HttpResponse? {

        val response: HttpResponse = client.get(url)


        /*
        *
        Log.d(
            "LFC_DATA_SOURCE",
            "fetchForecast() returned code ${response.status.value}"
        )
        *
        * */

        return if (response.status.value in 200..299) {
            response.body<HttpResponse?>()
        }
        else{
             null
        }
    }
}
