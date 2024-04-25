package no.uio.ifi.in2000.team_21.data.database

import com.mapbox.geojson.Point
import com.mapbox.maps.MapView
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotation
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager
import no.uio.ifi.in2000.team_21.ui.UserMarkerViewModel

class MapAnnotationHelper(private val mapView: MapView, private val onClick: (UserMarkerEntity) -> Unit) {
    private var pointAnnotationManager: PointAnnotationManager? = null
    private val annotationsMap = mutableMapOf<String, PointAnnotation>()

    init {
        setupPointAnnotationManager()
    }

    private fun setupPointAnnotationManager() {
        val annotationPlugin = mapView.annotations
        pointAnnotationManager = annotationPlugin.createPointAnnotationManager().apply {
            addClickListener{ annotation ->
                annotationsMap[annotation.id]?.let {
                    onClick(UserMarkerEntity(name = it.textField ?: "", latitude = it.point.latitude(), longitude = it.point.longitude(), annotationId = it.id))
                }
                true
            }
        }

    }

    fun saveLocation(name: String, point: Point, viewModel: UserMarkerViewModel) {
        val pointAnnotationOptions = PointAnnotationOptions()
            .withPoint(point)
            .withIconImage("custom-marker")
            .withTextField(name)
            .withTextOffset(listOf(0.0, 1.5))

        pointAnnotationManager?.let {
            val annotation = it.create(pointAnnotationOptions)
            annotationsMap[annotation.id] = annotation
            viewModel.saveUserLocation(UserMarkerEntity(
                name = name,
                latitude = point.latitude(),
                longitude = point.longitude(),
                annotationId = annotation.id
            ))
        }
    }

    fun displaySavedMarkers(savedLocations: List<UserMarkerEntity>) {
        savedLocations.forEach { location ->
            val point = Point.fromLngLat(location.longitude, location.latitude)
            val pointAnnotationOptions = PointAnnotationOptions()
                .withPoint(point)
                .withIconImage("custom-marker")
                .withTextField(location.name)
                .withTextOffset(listOf(0.0, 1.5))

            pointAnnotationManager?.create(pointAnnotationOptions)?.let { annotation ->
                annotationsMap[annotation.id] = annotation
            }
        }
    }

    fun deleteAnnotation(annotationId: String) {
        annotationsMap[annotationId]?.let {
            pointAnnotationManager?.delete(it)
            annotationsMap.remove(annotationId)
        }
    }

    fun clearAnnotations() {
        pointAnnotationManager?.deleteAll()
        annotationsMap.clear()
    }
}
