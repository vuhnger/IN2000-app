package no.uio.ifi.in2000.team_21.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.team_21.model.oceanforecast.OceanForecastResponse
import no.uio.ifi.in2000.team_21.model.oceanforecast.Timeseries
import java.nio.channels.UnresolvedAddressException

open class OceanForecastDataSource {

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
        defaultRequest {
            header(
                key = "X-Gravitee-API-Key",
                value = "eff58995-389e-4cd2-816f-4c6728aeec6e"
            )
        }
    }

    suspend fun fetchOceanForecastResponse(
        latitude: Double,
        longitude: Double
    ): OceanForecastResponse? {
        return try {
            val response: HttpResponse = client.get("https://in2000.api.met.no/weatherapi/oceanforecast/2.0/complete?lat=$latitude&lon=$longitude")
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

    suspend fun fetchOceanForecastTimeseries(latitude: Double, longitude: Double): ArrayList<Timeseries>? {

        return try {
            val response = fetchOceanForecastResponse(latitude, longitude)
            response?.properties?.timeseries
        }catch (e: Exception){
            null
        }
    }

    suspend fun fetchOceanForecastByTime(time: String, latitude: Double, longitude: Double): Timeseries? {

        return try {
            val timeseries = fetchOceanForecastTimeseries(latitude, longitude)
            timeseries?.find { it.time?.contains(time) ?: false }
        }catch (e: Exception){
            null
        }
    }
}

