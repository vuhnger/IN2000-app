package no.uio.ifi.in2000.team_21

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.team_21.model.Alert
import org.junit.Test

class SerializationTest{
    @Test
    fun testSerialization() {
        val jsonSnippet = """
            {
              "features": [
                {
                  "type": "Feature",
                  "geometry": {
                    "type": "Polygon",
                    "coordinates": [[[10, 10], [20, 20], [30, 30]]]
                  },
                  "properties": {
                    "area": "Test Area",
                    "event": "Test Event",
                    "severity": "Moderate",
                    "description": "Description here.",
                    "eventEndingTime": "2024-03-12T23:00:00+00:00",
                    "resources": [
                      {
                        "description": "Test Resource",
                        "mimeType": "application/json",
                        "uri": "https://example.com"
                      }
                    ]
                  },
                  "when": {
                    "interval": ["2024-03-09T10:00:00+00:00", "2024-03-12T23:00:00+00:00"]
                  }
                }
              ],
              "lang": "en",
              "lastChange": "2024-03-09T10:00:00Z",
              "type": "TestType"
            }
        """
        val json = Json { ignoreUnknownKeys = true }

        // Deserialize JSON to Kotlin object
        val alert: Alert = json.decodeFromString(jsonSnippet)
        println("Deserialized object: $alert")

        // Serialize Kotlin object back to JSON
        val jsonString = json.encodeToString(alert)
        println("Serialized JSON: $jsonString")
    }
}
