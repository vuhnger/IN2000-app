package no.uio.ifi.in2000.team_21

import kotlinx.coroutines.runBlocking
import no.uio.ifi.in2000.team_21.data.LocationForecastDataSource

// Simulate the TestLFCResponse class
class TestLFCResponse(private val datasource: LocationForecastDataSource) {
    suspend fun fetchForecast() {
        try {
            // Call the fetch function from the datasource
            val forecast = datasource.fetch()
            print("Fetched forecast: $forecast")
        } catch (e: Exception) {
            print("Error fetching forecast: {e}")
        }
    }
}

// Create an instance with the mock datasource
val response = TestLFCResponse(LocationForecastDataSource())

// Run the test coroutine
fun main() = runBlocking {
    response.fetchForecast()
}