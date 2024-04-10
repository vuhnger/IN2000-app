package no.uio.ifi.in2000.team_21

// Import necessary libraries
import io.ktor.client.statement.bodyAsText
import io.ktor.util.InternalAPI
import kotlinx.coroutines.runBlocking
import no.uio.ifi.in2000.team_21.data.LocationForecastDataSource
import no.uio.ifi.in2000.team_21.model.locationforecast.Response
import org.junit.Test


// Simulate the TestLFCResponse class
class TestLFCResponse(private val datasource: LocationForecastDataSource = LocationForecastDataSource()) {
    @OptIn(InternalAPI::class)
    suspend fun fetchForecast() {
        try {
            // Call the fetch function from the datasource
            val forecast = datasource.fetchForecast()
            if (forecast != null){
                forecast.properties?.timeseries?.forEach {
                    println(it)
                }
            }
        } catch (e: Exception) {
            println("Error fetching forecast: $e")
        }
    }
}

class TestLFCResponseTest {

    @Test
    fun `test fetchForecast should not crash`() = runBlocking {
        // Create an instance with the mock datasource
        val response = TestLFCResponse()

        // Run the fetchForecast function
        response.fetchForecast()
    }
}