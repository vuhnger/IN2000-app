package no.uio.ifi.in2000.team_21.container

import com.mapbox.geojson.Feature
import com.mapbox.geojson.FeatureCollection
import com.mapbox.geojson.MultiPolygon
import com.mapbox.geojson.Point
import com.mapbox.geojson.Polygon
import no.uio.ifi.in2000.team_21.model.Properties
import no.uio.ifi.in2000.team_21.model.Feature as MyFeature
import no.uio.ifi.in2000.team_21.model.MultiPolygon as MyMultiPolygon
import no.uio.ifi.in2000.team_21.model.Polygon as MyPolygon

object MapBoxDataTransformer {
    fun convertFeaturesToFeatureCollection(myFeatures: List<MyFeature>): FeatureCollection {
        val mapboxFeatures = myFeatures.mapNotNull { feature ->
            when (feature.geometry) {
                is MyPolygon -> createMapboxPolygonFeature(feature.geometry, feature.properties)
                is MyMultiPolygon -> createMapboxMultiPolygonFeature(feature.geometry, feature.properties)
                else -> null
            }
        }
        return FeatureCollection.fromFeatures(mapboxFeatures)
    }

    private fun createMapboxPolygonFeature(myPolygon: MyPolygon, properties: Properties): Feature {
        val outerRingCoordinates = myPolygon.coordinates.first().map { Point.fromLngLat(it[0], it[1]) }
        val polygon = Polygon.fromLngLats(listOf(outerRingCoordinates))
        return Feature.fromGeometry(polygon).also { feature ->
            feature.addStringProperty("title", properties.title ?: "")
            feature.addStringProperty("severity", properties.severity ?: "")
            feature.addStringProperty("area", properties.area ?: "")
            feature.addStringProperty("description", properties.description ?: "")
            feature.addStringProperty("instruction", properties.instruction ?: "")
            feature.addStringProperty("End time", properties.eventEndingTime ?: "")
            feature.addStringProperty("Risk Color", properties.riskMatrixColor ?: "")
            // Kan legge til flere properties her
        }
    }

    private fun createMapboxMultiPolygonFeature(myMultiPolygon: MyMultiPolygon, properties: Properties): Feature {
        val multiPolygonCoordinates = myMultiPolygon.coordinates.map { polygon ->
            polygon.map { ring ->
                ring.map { Point.fromLngLat(it[0], it[1]) }
            }
        }
        val multiPolygon = MultiPolygon.fromLngLats(multiPolygonCoordinates)
        return Feature.fromGeometry(multiPolygon).also { feature ->
            feature.addStringProperty("title", properties.title ?: "")
        }
    }
}