package no.uio.ifi.in2000.team_21.data.database

import com.mapbox.geojson.Point
import com.mapbox.maps.MapView
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager
import no.uio.ifi.in2000.team_21.ui.UserMarkerViewModel

class MapAnnotationHelper(private val mapView: MapView) {
    private var pointAnnotationManager: PointAnnotationManager? = null

    init {
        setupPointAnnotationManager()
    }

    private fun setupPointAnnotationManager() {
        val annotationPlugin = mapView.annotations
        pointAnnotationManager = annotationPlugin.createPointAnnotationManager()
    }

    fun saveLocation(name: String, point: Point, viewModel: UserMarkerViewModel) {
        val pointAnnotationOptions = PointAnnotationOptions()
            .withPoint(point)
            .withIconImage("custom-marker")
            .withTextField(name)
            .withTextOffset(listOf(0.0, 1.5))

        pointAnnotationManager?.let {
            val annotation = it.create(pointAnnotationOptions)
            viewModel.saveUserLocation(UserMarkerEntity(name = name, latitude = point.latitude(), longitude = point.longitude()))
            // Store the annotation ID if needed
        }
    }

    fun displaySavedMarkers(savedLocations: List<UserMarkerEntity>, viewModel: UserMarkerViewModel) {
        savedLocations.forEach { location ->
            val point = Point.fromLngLat(location.longitude, location.latitude)
            val pointAnnotationOptions = PointAnnotationOptions()
                .withPoint(point)
                .withIconImage("custom-marker")
                .withTextField(location.name)
                .withTextOffset(listOf(0.0, 1.5))

            pointAnnotationManager?.create(pointAnnotationOptions)?.let { annotation ->
                // Optionally store annotation id in your ViewModel if you need to reference it later
            }
        }
    }

    fun clearAnnotations() {
        pointAnnotationManager?.deleteAll()
    }
}
