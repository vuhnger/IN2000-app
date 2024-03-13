package no.uio.ifi.in2000.team_21.model

import kotlinx.serialization.Serializable

/* Data fra endepunktet.
* Kan tilpasses, om det er behov for å hente flere felt
*/

// Parametere til API'en.
data class AlertsInfo(
    val cap: String? = null,                // Retrieve CAP XML message with given guid
    val lang: String = "en",                // Output language "no" or "en"
    val event: String? = null,              // Filter by CAP eventType
    val incidentName: String? = null,       // Filter by incident
    val geographicDomain: String? = null,   // Filter by land or marine
    val county: String? = null,             // fylke
    val lat: Double? = null,                // latitude
    val lon: Double? = null,                // longitude
    val period: String? = null,             // Only used with /archive method
    val sort: String = "event",                // area, event, incidentName, t_onset, t_published, type
)

/*
@Serializable
data class Alert(
    val area: String,
    val event: String,
    val severity: String
)

@Serializable
data class AlertsResponse(
    val features: List<Feature>
)

@Serializable
data class Feature(
    val properties: Alert
)*/

@Serializable
data class Alert(
    val features: List<Feature>,
    val lang: String,
    val lastChange: String,
    val type: String
)

@Serializable
data class Feature(
    val geometry: Geometry,
    val properties: Properties,
    val type: String,
    val `when`: When
)

@Serializable
data class Geometry(
    val coordinates: List<List<List<Double>>>,              // Koordinatene følger (mest sannsynlig) fra venstre til høyre fra "laveste" punkt (lager en femkant (eller annen polygon))
    val type: String
)

@Serializable
data class Properties(
    val MunicipalityId: String? = null,
    val administrativeId: String? = null,
    val area: String? = null,
    val awarenessResponse: String? = null,
    val awarenessSeriousness: String? = null,
    val awareness_level: String? = null,
    val awareness_type: String? = null,
    val certainty: String? = null,
    val consequences: String? = null,
    val county: List<String>? = null,
    val description: String? = null,
    val event: String? = null,
    val eventAwarenessName: String? = null,
    val eventEndingTime: String? = null,
    val geographicDomain: String? = null,
    val id: String? = null,
    val incidentName: String? = null,
    val instruction: String? = null,
    val resources: List<Resource>? = null,
    val riskMatrixColor: String? = null,
    val severity: String? = null,
    val title: String? = null,
    val triggerLevel: String? = null,
    val type: String? = null
)

@Serializable
data class When(
    val interval: List<String>
)

@Serializable
data class Resource(
    val description: String,
    val mimeType: String,
    val uri: String
)
