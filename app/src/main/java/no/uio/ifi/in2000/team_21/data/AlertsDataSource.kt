package no.uio.ifi.in2000.team_21.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.header
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
                ignoreUnknownKeys = true
                encodeDefaults = true
            })
        }
        install(Logging) {
            level = LogLevel.BODY
        }
        install(HttpTimeout){
            requestTimeoutMillis = 30000
            connectTimeoutMillis = 30000
            socketTimeoutMillis = 30000
        }
        defaultRequest {
            header(
                key = "X-Gravitee-API-Key",
                value = "eff58995-389e-4cd2-816f-4c6728aeec6e"
            )
        }
    }

    suspend fun fetchAlerts(parameters: AlertsInfo): Alert? {
        val url = buildUrl(parameters)
        val response: HttpResponse = client.get(url)

        Log.d("ALERTS_DATA_SOURCE", "AlertsDataSource.fetchAlerts() HTTPS status: ${response.status}")

        return if (response.status.value in 200..299) {
            val alert: Alert? = response.body<Alert?>()
            /*alert?.features?.forEach { feature ->
                Log.d("ALERTS_DATA_SOURCE", "Feature: ${feature.type}, Properties: ${feature.properties}")
            }*/
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
            append("https://in2000.api.met.no/weatherapi/metalerts/2.0/current.json")

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