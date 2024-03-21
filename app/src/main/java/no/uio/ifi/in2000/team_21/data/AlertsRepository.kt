package no.uio.ifi.in2000.team_21.data

import no.uio.ifi.in2000.team_21.model.Alert
import no.uio.ifi.in2000.team_21.model.AlertsInfo
import no.uio.ifi.in2000.team_21.model.Feature
import no.uio.ifi.in2000.team_21.model.MultiPolygon
import no.uio.ifi.in2000.team_21.model.Polygon
import org.osmdroid.util.GeoPoint
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

class AlertsRepository(private val dataSource: AlertsDataSource) {
    suspend fun fetchAlerts(parameters: AlertsInfo): Alert? {
        // Vet ikke om det er behov for noe ekstra manipulering av data enda, men det gjøres her.
        return dataSource.fetchAlerts(parameters)
    }

    suspend fun fetchAndFilterAlerts(parameters: AlertsInfo, userLocation: GeoPoint, radius: Double): List<Feature>? {
        val alertsResponse = fetchAlerts(parameters)
        val allFeatures = alertsResponse?.features ?: return null

        return filterAlertsByRadius(allFeatures, userLocation, radius).also { filteredFeatures ->

        }
    }

    private fun haversine(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val R = 6372.8 // Radius in kilometres (of the earth)
        val l1 = Math.toRadians(lat1)
        val l2 = Math.toRadians(lat2)
        val deltaLat = Math.toRadians(lat2 - lat1)
        val deltaLon = Math.toRadians(lon2 - lon1)

        val a = sin(deltaLat / 2).pow(2) + sin(deltaLon / 2).pow(2) * cos(l1) * cos(l2)
        val c = 2 * asin(sqrt(a))

        return R * c
    }

    private fun filterAlertsByRadius(allFeatures: List<Feature>, userLocation: GeoPoint, radius: Double): List<Feature> {
        return allFeatures.filter { feature ->
            val firstCoordinate = when (val geometry = feature.geometry) {
                is Polygon -> if (geometry.coordinates.isNotEmpty() && geometry.coordinates.first().isNotEmpty()) {
                    geometry.coordinates.first().first()
                } else {
                    null
                }
                is MultiPolygon -> if (geometry.coordinates.isNotEmpty() && geometry.coordinates.first().isNotEmpty() && geometry.coordinates.first().first().isNotEmpty()) {
                    geometry.coordinates.first().first().first()
                } else {
                    null
                }
            }

            firstCoordinate?.let { coords ->
                val alertLocation = GeoPoint(coords[1], coords[0])
                val distance = haversine(userLocation.latitude, userLocation.longitude, alertLocation.latitude, alertLocation.longitude)
                distance <= radius
            }?: false
        }
    }
}