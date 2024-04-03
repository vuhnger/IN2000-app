package no.uio.ifi.in2000.team_21.ui.map

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.location.Location
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.preference.PreferenceManager
import android.util.Log
import android.view.MotionEvent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import no.uio.ifi.in2000.team_21.data.OilRigViewModel
import no.uio.ifi.in2000.team_21.model.Feature
import org.osmdroid.config.Configuration
import org.osmdroid.events.MapEventsReceiver
import org.osmdroid.tileprovider.MapTileProviderBasic
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.tileprovider.tilesource.XYTileSource
import org.osmdroid.util.GeoPoint
//import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.MapEventsOverlay
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Overlay
import org.osmdroid.views.overlay.Polygon
import org.osmdroid.views.overlay.ScaleBarOverlay
import org.osmdroid.views.overlay.TilesOverlay
import org.osmdroid.views.overlay.compass.CompassOverlay
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import com.google.android.gms.location.LocationListener
import no.uio.ifi.in2000.team_21.data.LocationManager
import no.uio.ifi.in2000.team_21.model.AlertsInfo
import no.uio.ifi.in2000.team_21.model.MultiPolygon
import no.uio.ifi.in2000.team_21.model.Polygon as MyPolygon
import no.uio.ifi.in2000.team_21.model.Properties
import org.osmdroid.views.overlay.infowindow.BasicInfoWindow
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import kotlin.math.cos
import kotlin.math.sin

/*
@Composable
fun OsmMapView() {
    val context = LocalContext.current
    val viewModel: OilRigViewModel = viewModel()
    val alertsViewModel: AlertsViewModel = viewModel()
    //val alerts by alertsViewModel.alerts.observeAsState()
    val filteredFeatures by alertsViewModel.filteredFeatures.observeAsState()
    val locationManager = remember { LocationManager(context) }
    val mapViewState = remember { mutableStateOf<MapView?>(null)}
    val userLocation = remember { mutableStateOf<Location?>(null)}

    // Predefined location (because we don't have geolocation yet) in Bergen
    val predefinedLocation = GeoPoint(60.3913, 5.3221)
    val radius = remember { mutableStateOf(500.0) } // Default "search" radius for alerts

    val locationUpdateListener = remember {
        object : LocationListener {
            override fun onLocationChanged(p0: Location) {
                userLocation.value = p0
            }
        }
    }

    DisposableEffect(context) {
        locationManager.startLocationUpdates(locationUpdateListener)
        onDispose {
            locationManager.stopLocationUpdates(locationUpdateListener)
        }
    }

    LaunchedEffect(userLocation.value) {
        userLocation.value?.let { location ->
            mapViewState.value?.let { mapView ->
                updateUserLocation(mapView, location)
            }
        }
    }

    LaunchedEffect(filteredFeatures) {
        val mapView = mapViewState.value
        mapView?.overlays?.clear()
        filteredFeatures?.forEach { feature ->
            mapView?.addAlertOverlay(feature, context)
        }
        //mapViewState.value?.invalidate()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp),
            factory = { ctx ->
                Configuration.getInstance()
                    .load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
                MapView(ctx).apply {
                    setupMapView(ctx)
                    addTileOverlay(ctx)
                    addMapClickListener()
                    addOilRigMarkers(viewModel)
                    addCompassOverlay(context)
                    addButtonOverlay()
                    addScaleBarOverlay()
                    setInitialMapView()

                    // metAlerts
                    mapViewState.value = this
                }
            }
        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
        ) {
            RadiusSelector(
                radius = radius,
                onRadiusChange = { newRadius ->
                    alertsViewModel.fetchAndFilterAlerts(AlertsInfo(), predefinedLocation, newRadius)
                    mapViewState.value?.updateSearchArea(predefinedLocation, newRadius)
                    Log.d("RadiusSelector", "${mapViewState.value}")
                },
                mapView = mapViewState.value
            )
        }
    }
}*/

@Composable
fun MapboxMapView() {
    val context = LocalContext.current
    val alertsViewModel: AlertsViewModel = viewModel()
    //val alerts by alertsViewModel.alerts.observeAsState()
    val filteredFeatures by alertsViewModel.filteredFeatures.observeAsState()
    val locationManager = remember { LocationManager(context) }
    val mapViewState = rememberMapViewWithLifecycle()
    val userLocation = remember { mutableStateOf<Location?>(null)}

    AndroidView(factory = { ctx ->
        MapView(ctx).also { mapView ->
            mapView.getMapAsync { mapboxMap ->
                // Configure your map appearance here
                mapboxMap.setStyle(Style.MAPBOX_STREETS) {
                    // Ready to add overlays and interact with the map
                }

                // Example to center the map
                mapboxMap.cameraPosition = CameraPosition.Builder()
                    .target(LatLng(60.3913, 5.3221)) // Example: Bergen
                    .zoom(10.0)
                    .build()
            }
        }
    }, modifier = Modifier.fillMaxSize())
}

fun MapView.setupMapView(ctx: Context) {
    // Set the base layer to OpenStreetMap
    setTileSource(TileSourceFactory.MAPNIK)
    //setBuiltInZoomControls(true)
    setMultiTouchControls(true)
    // Set the minimum and maximum zoom levels
    setMinZoomLevel(6.0)
    setMaxZoomLevel(20.0)
}

fun MapView.addTileOverlay(ctx: Context) {
    // Add OpenSeaMap as an overlay
    val tileSource = XYTileSource(
        "OpenSeaMap",
        1, 18, 256, ".png",
        arrayOf("http://t1.openseamap.org/seamark/")
    )
    val provider = MapTileProviderBasic(ctx).apply {
        this.tileSource = tileSource
    }
    val overlay = TilesOverlay(provider, ctx)
    overlayManager.add(overlay)
}

fun MapView.addOilRigMarkers(viewModel: OilRigViewModel) {
    // Get the oil rig markers from the ViewModel
    val oilRigMarkers = viewModel.initializeRigs(this)
    // Add the markers to the map overlay
    overlayManager.addAll(oilRigMarkers)
}


fun MapView.addCompassOverlay(context: Context) {
    // Create a new CompassOverlay instance
    val compassOverlay = CompassOverlay(context, this)
    // Enable the compass
    compassOverlay.enableCompass()
    // Set the compass to the bottom left
    compassOverlay.setCompassCenter(40f, 670f)
    // Add the compass overlay to the map
    overlays.add(compassOverlay)
}

fun MapView.addButtonOverlay() {
    // Create a custom Overlay for the button
    val buttonOverlay = object : Overlay() {
        override fun draw(canvas: Canvas, mapView: MapView, shadow: Boolean) {
            val paint = Paint()
            paint.color = Color.BLUE
            paint.textSize = 50f
            val buttonText = "Center"
            val textWidth = paint.measureText(buttonText)
            val x = canvas.width - textWidth - 50
            canvas.drawText(buttonText, x, 50f, paint)
        }

        override fun onSingleTapConfirmed(e: MotionEvent?, mapView: MapView?): Boolean {
            // Check if the tap is within the bounds of the button
            val buttonLeft = mapView?.width?.minus(200) ?: 0
            val buttonRight = mapView?.width ?: 0
            val buttonTop = 0
            val buttonBottom = 100

            if (e != null && e.x > buttonLeft && e.x < buttonRight && e.y > buttonTop && e.y < buttonBottom) {
                // The button was clicked, center the map to the start point
                mapView?.controller?.setCenter(GeoPoint(60.3913, 5.3221))
                mapView?.controller?.setZoom(0.0)
                return true
            }
            return false
        }
    }

    overlays.add(buttonOverlay)
}

fun MapView.addScaleBarOverlay() {
    // Create a new ScaleBarOverlay
    val scaleBarOverlay = ScaleBarOverlay(this)
    // Set the alignment of the scale bar
    scaleBarOverlay.setAlignBottom(true) // Top
    scaleBarOverlay.setAlignRight(true) // Right
    overlays.add(scaleBarOverlay)
}

fun MapView.setInitialMapView() {
    Handler(Looper.getMainLooper()).postDelayed({
        // Center point to Bergen, Norway
        controller.setCenter(GeoPoint(60.3913, 5.3221))
        controller.setZoom(0.0)
        postInvalidate()
    }, 1000)
}

fun MapView.addMapClickListener() {
    val receiver = object : MapEventsReceiver {
        var lastUserMarker: Marker? = null

        override fun singleTapConfirmedHelper(p: GeoPoint): Boolean {
            val point = this@addMapClickListener.getProjection().toPixels(p, null)

            val e = MotionEvent.obtain(
                SystemClock.uptimeMillis(),
                SystemClock.uptimeMillis(),
                MotionEvent.ACTION_UP,
                point.x.toFloat(),
                point.y.toFloat(),
                0
            )

            for (overlay in overlays) {
                if (overlay is Marker && overlay.hitTest(e, this@addMapClickListener)) {
                    return true
                }
            }

            lastUserMarker?.let { overlays.remove(it) }

            val marker = Marker(this@addMapClickListener)
            marker.position = p
            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            marker.title = "Lat: ${p.latitude}, Lon: ${p.longitude}"
            overlays.add(marker)

            lastUserMarker = marker

            invalidate()

            return true
        }

        override fun longPressHelper(p: GeoPoint): Boolean {
            return false
        }
    }

    val overlay = MapEventsOverlay(receiver)
    overlays.add(overlay)
}

// Alert overlay from metAlerts
fun MapView.addAlertOverlay(feature: Feature, context: Context) {
    when (val geometry = feature.geometry) {
        is MyPolygon -> {
            // Directly add the overlay for Polygon
            geometry.coordinates.forEach { polygonCoordinates ->
                addPolygonOverlay(polygonCoordinates, feature.properties)
            }
        }
        is MultiPolygon -> {
            // For each polygon in MultiPolygon, add the overlay
            geometry.coordinates.forEach { multiPolygonCoordinates ->
                multiPolygonCoordinates.forEach { polygonCoordinates ->
                    addPolygonOverlay(polygonCoordinates, feature.properties)
                }
            }
        }
    }
}

private fun MapView.addPolygonOverlay(polygonCoordinates: List<List<Double>>, properties: Properties) {
    val geoPoints = polygonCoordinates.flatMap { coord ->
        listOf(GeoPoint(coord[1], coord[0]))
    }

    val polygon = Polygon().apply {
        points = geoPoints
        fillColor = Color.argb(50, 255, 0, 0)
        title = properties.title
        infoWindow = BasicInfoWindow(org.osmdroid.bonuspack.R.layout.bonuspack_bubble, this@addPolygonOverlay)
    }

    overlays.add(polygon)
}

@Composable
fun RadiusSelector(radius: MutableState<Double>, onRadiusChange: (Double) -> Unit, mapView: MapView?) {
    Slider(
        value = radius.value.toFloat(),
        onValueChange = { newValue ->
            radius.value = newValue.toDouble()
            mapView?.updateSearchArea(GeoPoint(60.3913, 5.3221), radius.value) // Replace Geopoint with geolocation when available
            },
        onValueChangeFinished = {
            onRadiusChange(radius.value)
        },
        valueRange = 1f..2500f,
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    )
}

var searchAreaOverlay: Polygon? = null // Peker til search sirkelen, så den kan fjernes på "value change", for å forhindre stacking av sirkler.
fun MapView.updateSearchArea(center: GeoPoint, radius: Double) {

    searchAreaOverlay?.let { overlays.remove(it) }

    val circlePoints = ArrayList<GeoPoint>()        // Må lage egen sirkel :( En plugin hadde vært bedre om noen finner
    val totalPoints = 100
    for (i in 0 until totalPoints) {
        val angle = Math.toRadians((i * (360.0 / totalPoints)))
        val dx = radius * cos(angle)
        val dy = radius * sin(angle)
        val point = GeoPoint(center.latitude + (dy / 111.3199), center.longitude + (dx / (cos(Math.toRadians(center.latitude)) * 111.3199)))
        circlePoints.add(point)
    }

    Log.d("updateSearchArea", "Total Circle Points: ${circlePoints.size}, First point: ${circlePoints.firstOrNull()}")

    val polygon = Polygon(this).apply {
        points = circlePoints
        fillColor = Color.argb(25, 0, 25, 90)
        strokeColor = Color.BLUE
        strokeWidth = 1f
    }

    searchAreaOverlay = polygon

    overlays.add(polygon)
    invalidate()
}

private var userLocationOverlay: Overlay? = null    // Peker til posisjon så den kan fjernes ved posisjonsoppdatering

private fun updateUserLocation(mapView: MapView, location: Location) {
    userLocationOverlay?.let { mapView.overlays.remove(it) }

    val userLocationOverlay = Marker(mapView).apply {
        position = GeoPoint(location.latitude, location.longitude)
        Log.d("UPDATE USER LOCATION", "User location: ${location.latitude}, ${location.longitude}")
        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
    }

    mapView.overlays.add(userLocationOverlay)
    mapView.invalidate()
}