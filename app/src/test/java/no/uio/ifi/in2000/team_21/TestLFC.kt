package no.uio.ifi.in2000.team_21

import androidx.compose.runtime.Composable
import io.ktor.util.InternalAPI
import kotlinx.coroutines.runBlocking
import no.uio.ifi.in2000.team_21.data.LocationForecastDataSource
import org.junit.Test


class TestLFCResponse(private val datasource: LocationForecastDataSource = LocationForecastDataSource()) {
    suspend fun fetchForecast() {
        try {
            println("FETCHING FORECAST...")
            val forecast = datasource.TESTfetchForecast()
            if (forecast != null){
                println("Timeseries count: ${forecast.properties?.timeseries?.size}")
            }else{
                println("FORECAST: $forecast")
            }
        }catch (e: RuntimeException){
            println("RTE: ${e.message}")
        }catch (e: Exception){
            println(e.message)
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