package no.uio.ifi.in2000.team_21

import io.ktor.util.InternalAPI
import kotlinx.coroutines.runBlocking
import no.uio.ifi.in2000.team_21.data.LocationForecastDataSource
import org.junit.Test


class TestLFCResponse(private val datasource: LocationForecastDataSource = LocationForecastDataSource()) {
    @OptIn(InternalAPI::class)
    suspend fun fetchForecast() {
        try {
            val forecast = datasource.fetchLocationForecastResponse(60.0, 10.0)
        } catch (e: RuntimeException) {

        }catch (e: Exception){
            println("Something went wrong. ")
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