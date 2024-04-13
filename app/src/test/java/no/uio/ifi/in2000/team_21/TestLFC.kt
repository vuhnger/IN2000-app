package no.uio.ifi.in2000.team_21

import io.ktor.util.InternalAPI
import kotlinx.coroutines.runBlocking
import no.uio.ifi.in2000.team_21.data.LocationForecastDataSource
import org.junit.Test


class TestLFCResponse(private val datasource: LocationForecastDataSource = LocationForecastDataSource()) {
    @OptIn(InternalAPI::class)
    suspend fun fetchForecast() {
        try {

            val forecast = datasource.fetchForecast()
        } catch (e: Exception) {
            println("Error fetching forecast: $e")
        }

        try {
            val forecast = datasource.fetchForecast()
            if (forecast != null){
                println(forecast.properties?.timeseries?.size)
            }
        }catch (e: Exception){
            println("Error in data format: $e")
        }
    }
}

class TestLFCResponseTest {

    @Test
    fun `test fetchForecast should not crash`() = runBlocking {

        val response = TestLFCResponse()

        response.fetchForecast()
    }


}