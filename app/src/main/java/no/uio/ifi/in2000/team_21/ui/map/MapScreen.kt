package no.uio.ifi.in2000.team_21.ui.map

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.preference.PreferenceManager
import android.util.Log
import android.view.MotionEvent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.MapEventsOverlay
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Overlay
import org.osmdroid.views.overlay.Polygon
import org.osmdroid.views.overlay.ScaleBarOverlay
import org.osmdroid.views.overlay.TilesOverlay
import org.osmdroid.views.overlay.compass.CompassOverlay
import androidx.compose.runtime.livedata.observeAsState
import no.uio.ifi.in2000.team_21.model.AlertsInfo
import no.uio.ifi.in2000.team_21.model.MultiPolygon
import no.uio.ifi.in2000.team_21.model.Polygon as MyPolygon
import no.uio.ifi.in2000.team_21.model.Properties


@Composable
fun OsmMapView() {
    val context = LocalContext.current
    val viewModel: OilRigViewModel = viewModel()
    val alertsViewModel: AlertsViewModel = viewModel()
    val alerts by alertsViewModel.alerts.observeAsState()

    LaunchedEffect(Unit) {
        alertsViewModel.fetchAlerts(AlertsInfo())
    }

    AndroidView(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 56.dp),
        factory = { ctx ->
            Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
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
                alerts?.features?.forEach { feature ->
                    addAlertOverlay(feature, context)
                }
            }
        }
    )
}

fun MapView.setupMapView(ctx: Context) {
    // Set the base layer to OpenStreetMap
    setTileSource(TileSourceFactory.MAPNIK)
    //setBuiltInZoomControls(true)
    setMultiTouchControls(true)
    // Set the minimum and maximum zoom levels
    setMinZoomLevel(7.0)
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
    }

    overlays.add(polygon)
}