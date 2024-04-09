package no.uio.ifi.in2000.team_21.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class LocationForecastDataSource {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                //Konfigurer etter behov
                ignoreUnknownKeys = true
                encodeDefaults = true
            })
        }
        install(Logging) {
            level = LogLevel.BODY
        }
    }

    suspend fun fetch(){

        val url = "https://api.met.no/weatherapi/locationforecast/2.0/complete?lat=60.10&lon=10"
        val response: HttpResponse = client.get(url)

        Log.d(
            "LOCATION_FORECAST_DATA_SOURCE",
            "fetch() returned satus code: ${response.status}"
        )

    }

}