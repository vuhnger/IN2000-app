package no.uio.ifi.in2000.team_21.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json

open class LocationForecastDataSource {

    private val client = HttpClient() {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun fetch(): HttpResponse {

        val url = "https://api.met.no/weatherapi/locationforecast/2.0/complete?lat=60.10&lon=10"
        val response: HttpResponse = client.get(url).body()
        return response
    }

}