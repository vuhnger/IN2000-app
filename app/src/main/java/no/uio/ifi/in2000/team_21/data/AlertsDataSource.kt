package no.uio.ifi.in2000.team_21.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.appendIfNameAbsent
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.team_21.model.Alert
import no.uio.ifi.in2000.team_21.model.AlertsInfo


/* DataSource som henter og deserialiserer responsen fra endepunktet
* */
class AlertsDataSource {
    // HTTP CLIENT

    private val client = HttpClient(CIO) {

        val TIMEOUT_MS: Long = (30_000.0 * 5).toLong()

        try{
            install(ContentNegotiation) {
                json(Json {
                    //Konfigurer etter behov
                    ignoreUnknownKeys = true
                    encodeDefaults = true
                })
            }
            engine {
                endpoint {
                    connectTimeout = TIMEOUT_MS
                }
            }
            install(Logging) {
                level = LogLevel.BODY
            }
            install(HttpTimeout){
                requestTimeoutMillis = TIMEOUT_MS
                connectTimeoutMillis = TIMEOUT_MS
                socketTimeoutMillis = TIMEOUT_MS
            }
            defaultRequest {
                url("https://gw-uio.intark.uh-it.no/in2000/")
                headers.appendIfNameAbsent(
                    name = "X-Gravitee-API-Key",
                    value = "eff58995-389e-4cd2-816f-4c6728aeec6e"
                )
            }
        }catch(e: Exception){
            // TODO: Noe gikk alvorlig galt, vise frem til bruker og restarte app.
        }
    }

    suspend fun fetchAlerts(parameters: AlertsInfo): Alert? {

        try {
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

        }catch (e: Exception){
            return null
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