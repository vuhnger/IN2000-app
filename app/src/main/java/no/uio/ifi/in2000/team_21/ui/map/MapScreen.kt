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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import no.uio.ifi.in2000.team_21.model.AlertsInfo
import no.uio.ifi.in2000.team_21.model.MultiPolygon
import no.uio.ifi.in2000.team_21.model.Polygon as MyPolygon
import no.uio.ifi.in2000.team_21.model.Properties
import org.osmdroid.views.overlay.infowindow.BasicInfoWindow


/** Constants for initialize of MapView */
object OsmMapViewConstants {
    val BOTTOM_PADDING = 56.dp
}


/** Sets up the OpenStreetmMap view */
@Composable
fun OsmMapView() {

    Log.d("MAPVIEW", "Setting up OsMapView...")

    val context = LocalContext.current
    val viewModel: OilRigViewModel = viewModel()
    val alertsViewModel: AlertsViewModel = viewModel()
    val alerts by alertsViewModel.alerts.observeAsState()

    val mapViewState = remember { mutableStateOf<MapView?>(null)}

    LaunchedEffect(Unit) {
        alertsViewModel.fetchAlerts(AlertsInfo())
    }

    LaunchedEffect(alerts) {
        mapViewState.value?.overlays?.clear()
        alerts?.features?.forEach { feature ->
            mapViewState.value?.addAlertOverlay(feature, context)
        }
        mapViewState.value?.invalidate()
    }

    AndroidView(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = OsmMapViewConstants.BOTTOM_PADDING),
        factory = { ctx ->
            Configuration.getInstance().load(ctx,
                PreferenceManager.getDefaultSharedPreferences(ctx))
            MapView(ctx).apply {
                setupMapView()
                Log.d("MAPVIEW", "MapView setup completed.")
                addTileOverlay(ctx)
                Log.d("MAPVIEW", "Tile overlay added.")
                addMapClickListener()
                Log.d("MAPVIEW", "Map click listener added.")
                addOilRigMarkers(viewModel)
                Log.d("MAPVIEW", "Oil rig markers added.")
                addCompassOverlay(context)
                Log.d("MAPVIEW", "Compass overlay added.")
                addButtonOverlay()
                Log.d("MAPVIEW", "Button overlay added.")
                addScaleBarOverlay()
                Log.d("MAPVIEW", "Scale bar overlay added.")
                setInitialMapView()
                Log.d("MAPVIEW", "Initial map view set.")
                // metAlerts
                mapViewState.value = this
            }
        }
    )
}

/** Constants for MapView setup */
object MapViewConstants {
    const val MIN_ZOOM_LEVEL = 7.0
    const val MAX_ZOOM_LEVEL = 20.0
}

/** Initialize setup for MapView with given settings. */
fun MapView.setupMapView() {
    Log.d("MAPVIEW_SETUP", "Setting up MapView...")

    // Set the base layer to OpenStreetMap
    setTileSource(TileSourceFactory.MAPNIK)
    Log.d("MAPVIEW_SETUP", "Tile layer set to OpenStreetMap.")

    // Enable multi touch controls
    setMultiTouchControls(true)
    Log.d("MAPVIEW_SETUP_MAPVIEW", "Multi touch controls on.")

    // Set the minimum and maximum zoom levels
    minZoomLevel = MapViewConstants.MIN_ZOOM_LEVEL
    maxZoomLevel = MapViewConstants.MAX_ZOOM_LEVEL

    Log.d("MAPVIEW_SETUP", "Zoom levels set to min: ${MapViewConstants.MIN_ZOOM_LEVEL}, max: ${MapViewConstants.MAX_ZOOM_LEVEL}.")

    Log.d("MAPVIEW_SETUP", "MapView setup completed.")
}

/** Constants for TileOverlay setup */
object TileOverlayConstants {
    const val TILE_SOURCE_NAME = "OpenSeaMap"
    const val MIN_ZOOM = 1
    const val MAX_ZOOM = 18
    const val TILE_SIZE = 256
    const val TILE_EXTENSION = ".png"
    val TILE_SOURCE_URL = arrayOf("http://tiles.openseamap.org/seamark/")
}

/** Adds a tile overlay to the MapView.  */
fun MapView.addTileOverlay(ctx: Context) {
    Log.d("MAPVIEW_ADD_TILE_OVERLAY", "Adding tile overlay...")

    // Create a new XYTileSource instance
    val tileSource = XYTileSource(
        TileOverlayConstants.TILE_SOURCE_NAME,
        TileOverlayConstants.MIN_ZOOM,
        TileOverlayConstants.MAX_ZOOM,
        TileOverlayConstants.TILE_SIZE,
        TileOverlayConstants.TILE_EXTENSION,
        TileOverlayConstants.TILE_SOURCE_URL,
    )

    Log.d("MAPVIEW_ADD_TILE_OVERLAY", "Tile source created.")

    // Make a new MapTileProvider instance and sets the tile source
    val provider = MapTileProviderBasic(ctx).apply {
        this.tileSource = tileSource
    }

    Log.d("MAPVIEW_ADD_TILE_OVERLAY", "Tile provider created and tile source set.")

    // Create a new TilesOverlay instance and add it to the overlay manager
    val overlay = TilesOverlay(provider, ctx)
    overlayManager.add(overlay)

    Log.d("MAPVIEW_ADD_TILE_OVERLAY", "Tile overlay created and added to overlay manager.")

    Log.d("MAPVIEW_ADD_TILE_OVERLAY", "Tile overlay setup completed.")
}

/**
 * Adds oil rig markers to the MapView.
 *
 *  @param viewModel The ViewModel that provides the oil rig data.
 * */
fun MapView.addOilRigMarkers(viewModel: OilRigViewModel) {

    Log.d("MAPVIEW_ADD_OIL-RIG_MARKERS", "Adding oil rig markers...")

    // Get the oil rig markers from the ViewModel
    val oilRigMarkers = viewModel.initializeRigs(this)

    Log.d("MAPVIEW_ADD_OIL-RIG_MARKERS", "Oil rig markers initialized.")

    // Add the markers to the map overlay
    overlayManager.addAll(oilRigMarkers)

    Log.d("MAPVIEW_ADD_OIL-RIG_MARKERS", "Oil rig markers added to overlay manager.")

    Log.d("MAPVIEW_ADD_OIL-RIG_MARKERS", "Oil rig markers setup completed.")
}

// Compass constants
object CompassConstants {
    const val COMPASS_CENTER_X = 40f
    const val COMPASS_CENTER_Y = 670f
}

fun MapView.addCompassOverlay(context: Context) {
    Log.d("MAPVIEW_ADD_COMPASS_OVERLAY", "Adding compass overlay...")

    // Create a new CompassOverlay instance
    val compassOverlay = CompassOverlay(context, this)

    // Enable the compass
    compassOverlay.enableCompass()

    // Set the compass to the bottom left
    compassOverlay.setCompassCenter(
        CompassConstants.COMPASS_CENTER_X,
        CompassConstants.COMPASS_CENTER_Y,
    )

    // Add the compass overlay to the map
    overlays.add(compassOverlay)

    Log.d("MAPVIEW_ADD_COMPASS_OVERLAY", "Compass overlay added successfully.")
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

/** Adds a scale bar overlay to the MapView. */
fun MapView.addScaleBarOverlay() {
    Log.d("MAPVIEW_ADD_SCALE_BAR_OVERLAY", "Adding scale bar overlay...")

    // Create a new ScaleBarOverlay instance
    val scaleBarOverlay = ScaleBarOverlay(this)

    // Set the alignment of the scale bar
    scaleBarOverlay.setAlignBottom(true)
    scaleBarOverlay.setAlignRight(true)

    overlays.add(scaleBarOverlay)

    Log.d("MAPVIEW_ADD_SCALE_BAR_OVERLAY", "Scale bar overlay added.")

}

/**
 * Constants for initial MapView setup
 * Start point set to Bergen, Norway
 * */
object InitialMapViewMapConstants {
    const val INITIAL_LAT = 60.39
    const val INITIAL_LON = 5.32
    const val INITIAL_ZOOM = 0.0
    const val DELAY_MILLIS = 1000L
}

/** Sets the initial view of the MapView. */
fun MapView.setInitialMapView() {
    Log.d("MAPVIEW_SET_INITIAL_MAPVIEW", "Setting initial MapView...")

    Handler(Looper.getMainLooper()).postDelayed({
        // Center point to Bergen, Norway
        controller.setCenter(GeoPoint(InitialMapViewMapConstants.INITIAL_LAT, InitialMapViewMapConstants.INITIAL_LON))

        controller.setZoom(InitialMapViewMapConstants.INITIAL_ZOOM)
        postInvalidate()

        Log.d("MAPVIEW_SET_INITIAL_MAPVIEW", "Initial MapView set.")

    }, InitialMapViewMapConstants.DELAY_MILLIS)
}

/**
 * Adds a map click listener to the MapView.
 */
fun MapView.addMapClickListener() {
    Log.d("MAPVIEW_ADD_MAP_CLICK_LISTENER", "Adding map click listener...")

    val receiver = object : MapEventsReceiver {
        var lastUserMarker: Marker? = null

        override fun singleTapConfirmedHelper(p: GeoPoint): Boolean {
            Log.d("MAPVIEW_ADD_MAP_CLICK_LISTENER", "Single click confirmed.")

            if (isMarkerClicked(p)) {
                return true
            }

            lastUserMarker?.let { overlays.remove(it) }

            lastUserMarker = addMarker(p)

            return true
        }

        override fun longPressHelper(p: GeoPoint): Boolean {
            Log.d("MAPVIEW_ADD_MAP_CLICK_LISTENER", "Long click detected.")
            return false
        }
    }
    overlays.add(MapEventsOverlay(receiver))

    Log.d("MAPVIEW_ADD_MAP_CLICK_LISTENER", "Map click listener added.")
}

private fun MapView.isMarkerClicked(p: GeoPoint): Boolean {
    Log.d("MAPVIEW_ADD_MAP_CLICK_LISTENER_IS_MARKER_CLICKED", "Checking if marker is clicked...")

    val point = this.getProjection().toPixels(p, null)
    val e = MotionEvent.obtain(
        SystemClock.uptimeMillis(),
        SystemClock.uptimeMillis(),
        MotionEvent.ACTION_UP,
        point.x.toFloat(),
        point.y.toFloat(),
        0
    )

    val isMarkerClicked = overlays.any { it is Marker && it.hitTest(e, this) }

    Log.d("MAPVIEW_ADD_MAP_CLICK_LISTENER_IS_MARKER_CLICKED", "Marker clicked: $isMarkerClicked")

    return isMarkerClicked
}

private fun MapView.addMarker(p: GeoPoint): Marker {
    Log.d("MAPVIEW_ADD_MAP_CLICK_LISTENER_ADD_MARKER", "Adding marker...")

    val marker = Marker(this).apply {
        position = p
        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        title = "Lat: ${String.format("%.2f", p.latitude)}, Lon: ${String.format("%.2f", p.longitude)}"
    }

    overlays.add(marker)

    Log.d("MAPVIEW_ADD_MAP_CLICK_LISTENER_ADD_MARKER", "Marker added at Lat: ${String.format("%.2f", p.latitude)}, Lon: ${String.format("%.2f", p.longitude)}.")

    //val overlay = MapEventsOverlay(receiver)
    //overlays.add(overlay)

    return marker
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