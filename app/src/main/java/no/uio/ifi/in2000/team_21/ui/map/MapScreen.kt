package no.uio.ifi.in2000.team_21.ui.map

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mapbox.geojson.FeatureCollection
import com.mapbox.geojson.Point
import com.mapbox.geojson.Polygon
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.style.layers.FillLayer
import com.mapbox.mapboxsdk.style.layers.PropertyFactory
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import no.uio.ifi.in2000.team_21.container.MapBoxDataTransformer.convertFeaturesToFeatureCollection
import no.uio.ifi.in2000.team_21.model.AlertsInfo
import kotlin.math.cos
import kotlin.math.sin
import no.uio.ifi.in2000.team_21.model.Feature as MyFeature

@Composable
fun MapboxMapView() {
    val context = LocalContext.current
    val mapView = rememberMapViewWithLifecycle(context)
    val mapboxMapState = remember { mutableStateOf<MapboxMap?>(null) }
    val lifecycleOwner = LocalLifecycleOwner.current
    val alertsViewModel: AlertsViewModel = viewModel()
    val filteredFeatures by alertsViewModel.filteredFeatures.observeAsState()
    val radius = remember { mutableStateOf(500.0) }
    // Predefined location, replace with geolocation when added
    val predefinedLocation = LatLng(60.3913, 5.3221)

    AndroidView({ mapView }, Modifier.fillMaxSize()) { mapView ->
        mapView.getMapAsync { mapboxMap ->
            mapboxMapState.value = mapboxMap
            mapboxMap.setStyle(Style.MAPBOX_STREETS) { style ->
                // additional map setup can be done here
            }

            // Start position on launch
            mapboxMap.cameraPosition = CameraPosition.Builder()
                .target(LatLng(60.3913, 5.3221)) // Bergen
                .zoom(10.0)
                .build()
        }
    }

    // Alerts
    LaunchedEffect(filteredFeatures) {
        filteredFeatures?.let { features ->
            mapView.getMapAsync { mapboxMap ->
                mapboxMap.addAlertOverlay(features)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 40.dp)
    ) {
        RadiusSelector(
            radius = radius,
            onRadiusChange = { newRadius ->
                // Your existing logic
                alertsViewModel.fetchAndFilterAlerts(AlertsInfo(), predefinedLocation, newRadius)
                mapboxMapState.value?.updateSearchArea(predefinedLocation, newRadius)
                Log.d("RadiusSelector", "${mapboxMapState.value}")
            },
            mapboxMap = mapboxMapState.value
        )
    }

}

@Composable
fun rememberMapViewWithLifecycle(context: Context): MapView {
    val mapView = remember {
        MapView(context).apply {
            onCreate(null)
        }
    }
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val lifecycle = lifecycleOwner.lifecycle
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> mapView.onStart()
                Lifecycle.Event.ON_RESUME -> mapView.onResume()
                Lifecycle.Event.ON_PAUSE -> mapView.onPause()
                Lifecycle.Event.ON_STOP -> mapView.onStop()
                Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
                else -> {}
            }
        }
        lifecycle.addObserver(observer)

        onDispose {
            lifecycle.removeObserver(observer)
        }
    }

    return mapView
}

// Alert overlay from metAlerts
fun MapboxMap.addAlertOverlay(myFeatures: List<MyFeature>) {
    val featureCollection = convertFeaturesToFeatureCollection(myFeatures)
    val sourceId = "alerts-source"
    val fillLayerId = "alerts-fill-layer"

    getStyle { style ->
        if (style.getSource(sourceId) != null) {
            (style.getSourceAs<GeoJsonSource>(sourceId))?.setGeoJson(featureCollection)
        } else {
            val geoJsonSource = GeoJsonSource(sourceId, featureCollection)
            style.addSource(geoJsonSource)
        }

        if (style.getLayer(fillLayerId) == null) {
            val fillLayer = FillLayer(fillLayerId, sourceId).withProperties(
                PropertyFactory.fillColor("red"), // Vil gjerne erstatte dette med farge fra farevarsel, men dataen der er litt ustabil.
                PropertyFactory.fillOpacity(0.5f)
            )
            style.addLayer(fillLayer)
        }
    }
}

fun MapboxMap.updateSearchArea(center: LatLng, radiusKm: Double) {
    val radiusM = radiusKm * 1000

    val circlePoints = mutableListOf<Point>()
    val steps = 64
    val distanceX = radiusM / (111320 * cos(Math.toRadians(center.latitude)))
    val distanceY = radiusM / 110540

    for (i in 0 until steps) {
        val theta = (i.toDouble() / steps) * (2 * Math.PI)
        val x = distanceX * cos(theta)
        val y = distanceY * sin(theta)
        circlePoints.add(Point.fromLngLat(center.longitude + x, center.latitude + y))
    }

    val polygon = Polygon.fromLngLats(listOf(circlePoints))
    val sourceId = "search-area-source"

    this.getStyle { style ->
        if (style.getSource(sourceId) != null) {
            (style.getSourceAs<GeoJsonSource>(sourceId))?.setGeoJson(polygon)
        } else {
            val geoJsonSource = GeoJsonSource(sourceId, polygon)
            style.addSource(geoJsonSource)

            val fillLayer = FillLayer("search-area-layer", sourceId).withProperties(
                PropertyFactory.fillColor("blue"),
                PropertyFactory.fillOpacity(0.5f)
            )
            style.addLayer(fillLayer)
        }
    }
}

@Composable
fun RadiusSelector(radius: MutableState<Double>, onRadiusChange: (Double) -> Unit, mapboxMap: MapboxMap?) {
    Slider(
        value = radius.value.toFloat(),
        onValueChange = { newValue ->
            radius.value = newValue.toDouble()
            val center = LatLng(60.3913, 5.3221) // Replace with geolocation when available
            mapboxMap?.updateSearchArea(center, radius.value)
        },
        onValueChangeFinished = {
            onRadiusChange(radius.value)
            mapboxMap?.clearSearchArea()
        },
        valueRange = 1f..2500f,
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    )
}

fun MapboxMap.clearSearchArea() {
    getStyle { style ->
        val sourceId = "search-area-source"
        (style.getSourceAs<GeoJsonSource>(sourceId))?.setGeoJson(FeatureCollection.fromFeatures(emptyList()))
    }
}