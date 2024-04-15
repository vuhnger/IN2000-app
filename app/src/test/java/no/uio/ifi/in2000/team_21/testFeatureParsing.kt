package no.uio.ifi.in2000.team_21

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import no.uio.ifi.in2000.team_21.model.Feature
import org.junit.Assert.assertEquals
import org.junit.Test

class FeatureParsingTest {
    @Test
    fun testFeatureParsing() {
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
        """.trimIndent()

        val gson = Gson()
        val featureListType = object : TypeToken<List<Feature>>() {}.type
        val features: List<Feature> = gson.fromJson(jsonSnippet, featureListType)

        val firstFeatureProperties = features.first().properties
        assertEquals("Test Area", firstFeatureProperties.area)
        assertEquals("Test Event", firstFeatureProperties.event)
        assertEquals("Moderate", firstFeatureProperties.severity)
        assertEquals("Description here.", firstFeatureProperties.description)
        assertEquals("2024-03-12T23:00:00+00:00", firstFeatureProperties.eventEndingTime)

        // Additional assertions ..
    }
}