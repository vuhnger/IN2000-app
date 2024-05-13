package no.uio.ifi.in2000.team_21.data.database

import android.content.Context
import android.graphics.BitmapFactory
import com.mapbox.geojson.Point
import com.mapbox.maps.MapView
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager
import no.uio.ifi.in2000.team_21.R
import no.uio.ifi.in2000.team_21.ui.viewmodels.UserMarkerViewModel

class MapAnnotationHelper(private val mapView: MapView, private val context: Context, private val onClick: (UserMarkerEntity) -> Unit) {
    private var pointAnnotationManager: PointAnnotationManager? = null
    private val annotationsMap = mutableMapOf<String, UserMarkerEntity>()

    init {
        setupPointAnnotationManager()
        setupCustomIcons()
    }

    private fun setupPointAnnotationManager() {
        val annotationPlugin = mapView.annotations
        pointAnnotationManager = annotationPlugin.createPointAnnotationManager().apply {
            addClickListener{ annotation ->
                annotationsMap[annotation.id]?.let { userMarker ->
                    onClick(userMarker)
                }
                true
            }
        }
    }


    fun saveLocation(name: String, point: Point, iconResId: Int, viewModel: UserMarkerViewModel) {
        val iconId = context.resources.getResourceEntryName(iconResId)
        val bitmap = BitmapFactory.decodeResource(context.resources, iconResId)

        mapView.mapboxMap.getStyle { style ->
            style.addImage(iconId, bitmap)
            val pointAnnotationOptions = PointAnnotationOptions()
                .withPoint(point)
                .withIconImage(iconId)
                .withTextField(name)
                .withTextOffset(listOf(0.0, 1.5))

            pointAnnotationManager?.let {
                val annotation = it.create(pointAnnotationOptions)
                val userMarker = UserMarkerEntity(
                    name = name,
                    latitude = point.latitude(),
                    longitude = point.longitude(),
                    annotationId = annotation.id,
                    iconId = iconId
                )
                annotationsMap[annotation.id] = userMarker
                viewModel.saveUserLocation(userMarker)
            }
        }
    }

    fun displaySavedMarkers(savedLocations: List<UserMarkerEntity>) {
        savedLocations.forEach { location ->
            val point = Point.fromLngLat(location.longitude, location.latitude)
            val pointAnnotationOptions = PointAnnotationOptions()
                .withPoint(point)
                .withIconImage(location.iconId)
                .withTextField(location.name)
                .withTextOffset(listOf(0.0, 1.5))

            pointAnnotationManager?.create(pointAnnotationOptions)?.let { annotation ->
                annotationsMap[annotation.id] = location
            }
        }
    }

    fun deleteAnnotation(annotationId: String) {
        annotationsMap[annotationId]?.let {
            pointAnnotationManager?.annotations?.find { it.id == annotationId }?.let { annotation ->
                pointAnnotationManager?.delete(annotation)
                mapView.mapboxMap.triggerRepaint()
            }
            annotationsMap.remove(annotationId)
        }
    }

    fun clearAnnotations() {
        pointAnnotationManager?.deleteAll()
        annotationsMap.clear()
    }

    fun setupCustomIcons() {
        mapView.mapboxMap.getStyle { style ->
            val icons = context.resources.getStringArray(R.array.icon_options)
            icons.forEach { iconId ->
                val resourceId = context.resources.getIdentifier(iconId, "drawable", context.packageName)
                if (resourceId != 0) {
                    val bitmap = BitmapFactory.decodeResource(context.resources, resourceId)
                    style.addImage(iconId, bitmap)
                }
            }
        }
    }
}
