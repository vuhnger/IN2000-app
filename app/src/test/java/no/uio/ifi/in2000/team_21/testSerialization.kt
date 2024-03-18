package no.uio.ifi.in2000.team_21

import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import no.uio.ifi.in2000.team_21.model.Alert
import org.junit.Test

class SerializationTest{
    @Test
    fun testSerialization() {
        val jsonSnippet = "{\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"type\": \"Feature\",\n" +
                "      \"geometry\": {\n" +
                "        \"type\": \"Polygon\",\n" +
                "        \"coordinates\": [[[10, 10], [20, 20], [30, 30]]]\n" +
                "      },\n" +
                "      \"properties\": {\n" +
                "        \"area\": \"Test Area\",\n" +
                "        \"event\": \"Test Event\",\n" +
                "        \"severity\": \"Moderate\",\n" +
                "        \"resources\": [\n" +
                "          {\n" +
                "            \"description\": \"Test Resource\",\n" +
                "            \"mimeType\": \"application/json\",\n" +
                "            \"uri\": \"https://example.com\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      \"when\": {\n" +
                "        \"interval\": [\"2024-03-09T10:00:00+00:00\", \"2024-03-12T23:00:00+00:00\"]\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"lang\": \"en\",\n" +
                "  \"lastChange\": \"2024-03-09T10:00:00Z\",\n" +
                "  \"type\": \"TestType\"\n" +
                "}\n"
        val json = Json { ignoreUnknownKeys = true }

        // Deserialize JSON to Kotlin object
        val alert: Alert = json.decodeFromString(jsonSnippet)
        println("Deserialized object: $alert")

        // Serialize Kotlin object back to JSON
        val jsonString = json.encodeToString(alert)
        println("Serialized JSON: $jsonString")
    }
}
