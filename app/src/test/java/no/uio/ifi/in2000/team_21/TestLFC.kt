package no.uio.ifi.in2000.team_21

// Import necessary libraries
import io.ktor.client.statement.bodyAsText
import io.ktor.util.InternalAPI
import kotlinx.coroutines.runBlocking
import no.uio.ifi.in2000.team_21.data.LocationForecastDataSource
import org.junit.Test


// Simulate the TestLFCResponse class
class TestLFCResponse(private val datasource: LocationForecastDataSource) {
    @OptIn(InternalAPI::class)
    suspend fun fetchForecast() {
        try {
            // Call the fetch function from the datasource
            val forecast = datasource.fetchForecast()
            if (forecast != null) {
                //println("Fetched forecast: ${forecast.bodyAsText()}")
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
        val response = TestLFCResponse(LocationForecastDataSource())

        // Run the fetchForecast function
        response.fetchForecast()
    }
}