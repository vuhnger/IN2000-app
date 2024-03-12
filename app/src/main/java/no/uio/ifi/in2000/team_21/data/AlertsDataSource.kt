package no.uio.ifi.in2000.team_21.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.call.receive
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.team_21.model.Alert
import no.uio.ifi.in2000.team_21.model.AlertsInfo


/* DataSource som henter og deserialiserer responsen fra endepunktet
* */
class AlertsDataSource {
    // HTTP CLIENT
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                //Konfigurer etter behov
            })
        }
    }

    suspend fun fetchAlerts(parameters: AlertsInfo): Alert? {
        val url = buildUrl(parameters)
        val response: HttpResponse = client.get(url)

        Log.d("ALERTS_DATA_SOURCE", "AlertsDataSource.fetchAlerts() HTTPS status: ${response.status}")

        return if (response.status.value in 200..299) {
            response.body<Alert?>()
        } else {
            println("Error: ${response.status.value}")
            null
        }
    }

    /* Funksjon som skal forenkle query prosessen der man legger til parametere i URL'en.
    *  Støtter bare /current (ikke /archive, /all eller /test)
    */
    private fun buildUrl(parameters: AlertsInfo): String {
        return buildString {
            append("https://api.met.no/weatherapi/metalerts/2.0/current.json")

            parameters.cap?.let { append("&cap=$it") }
            append("&lang=${parameters.lang}")
            parameters.event?.let { append("&event=$it") }
            parameters.incidentName?.let { append("&incidentName=$it") }
            parameters.geographicDomain?.let { append("&geographicDomain=$it") }
            parameters.county?.let { append("&county=$it") }
            parameters.lat?.let { append("&lat=$it") }
            parameters.lon?.let { append("&lot=$it") }
            parameters.period?.let { append("&period=$it") }
            append("&sort=${parameters.sort}")
        }.replaceFirst("&", "?") // Starter query
    }
}