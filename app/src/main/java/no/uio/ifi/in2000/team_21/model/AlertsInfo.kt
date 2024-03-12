package no.uio.ifi.in2000.team_21.model

import kotlinx.serialization.Serializable

/* Data fra endepunktet.
* Kan tilpasses, om det er behov for å hente flere felt
*/

// Parametere til API'en.
data class AlertsInfo(
    val cap: String?,                // Retrieve CAP XML message with given guid
    val lang: String,                // Output language "no" or "en"
    val event: String?,              // Filter by CAP eventType
    val incidentName: String?,       // Filter by incident
    val geographicDomain: String?,   // Filter by land or marine
    val county: String?,             // fylke
    val lat: Double?,                // latitude
    val lon: Double?,                // longitude
    val period: String?,             // Only used with /archive method
    val sort: String,                // area, event, incidentName, t_onset, t_published, type
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
    val MunicipalityId: String,
    val administrativeId: String,
    val area: String,
    val awarenessResponse: String,
    val awarenessSeriousness: String,
    val awareness_level: String,
    val awareness_type: String,
    val certainty: String,
    val consequences: String,
    val county: List<String>,
    val description: String,
    val event: String,
    val eventAwarenessName: String,
    val eventEndingTime: String,
    val geographicDomain: String,
    val id: String,
    val incidentName: String,
    val instruction: String,
    //val resources: List<Resource>,
    val riskMatrixColor: String,
    val severity: String,
    val title: String,
    val triggerLevel: String,
    val type: String
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
