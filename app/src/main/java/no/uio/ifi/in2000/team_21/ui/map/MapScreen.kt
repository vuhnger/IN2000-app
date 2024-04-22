package no.uio.ifi.in2000.team_21.ui.map

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.Color.parseColor
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.gson.Gson
import com.mapbox.geojson.Feature
import com.mapbox.geojson.FeatureCollection
import com.mapbox.geojson.Point
import com.mapbox.geojson.Polygon
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions
import com.mapbox.mapboxsdk.location.LocationComponentOptions
import com.mapbox.mapboxsdk.location.modes.CameraMode
import com.mapbox.mapboxsdk.location.modes.RenderMode
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.style.layers.FillLayer
import com.mapbox.mapboxsdk.style.layers.Property
import com.mapbox.mapboxsdk.style.layers.PropertyFactory
import com.mapbox.mapboxsdk.style.layers.SymbolLayer
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.R
import no.uio.ifi.in2000.team_21.container.MapBoxDataTransformer.convertFeaturesToFeatureCollection
import no.uio.ifi.in2000.team_21.model.AlertsInfo
import no.uio.ifi.in2000.team_21.model.Properties
import no.uio.ifi.in2000.team_21.model.locationforecast.Timeseries
import no.uio.ifi.in2000.team_21.ui.home.ForecastViewModel
import no.uio.ifi.in2000.team_21.ui.home.WeatherIcon
import kotlin.math.cos
import kotlin.math.sin
import no.uio.ifi.in2000.team_21.model.Feature as MyFeature


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MapboxMapView() {
    val context = LocalContext.current
    val mapView = rememberMapViewWithLifecycle(context)
    val mapboxMapState = remember { mutableStateOf<MapboxMap?>(null) }
    val lifecycleOwner = LocalLifecycleOwner.current
    val alertsViewModel: AlertsViewModel = viewModel()
    val filteredFeatures by alertsViewModel.filteredFeatures.observeAsState()
    val radius = remember { mutableStateOf(500.0) }
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    var userLocation by remember { mutableStateOf(LatLng()) }
    var cameraInitialized by remember { mutableStateOf(false)}
    var currentMarkerSource by remember { mutableStateOf<GeoJsonSource?>(null)}
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    val selectedLocationWeatherData = remember { mutableStateOf<List<Timeseries>?>(null)}
    val forecastViewModel: ForecastViewModel = viewModel()

    LocationPermissionRequest(onPermissionGranted = {
        val locationRequest = LocationRequest.create().apply {
            interval = 10000 // Update interval in milliseconds
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        }

        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {
                for (location in p0.locations) {
                    userLocation = LatLng(location.latitude, location.longitude)
                    // Zoom into user on launch
                    if (!cameraInitialized && userLocation.latitude != 0.0 && userLocation.longitude != 0.0) {
                        mapboxMapState.value?.animateCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 10.0))
                        cameraInitialized = true
                    }
                }
            }
        }

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper())
        }
    })

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            BottomSheetContent(timeseries = forecastViewModel.selectedLocationWeatherData.value)
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp)
        ) {
            AndroidView({ mapView }, Modifier.fillMaxSize()) { mapView ->
                mapView.getMapAsync { mapboxMap ->
                    mapboxMapState.value = mapboxMap
                    mapboxMap.setStyle(Style.MAPBOX_STREETS) { style ->
                        val customLocationComponentOptions = LocationComponentOptions.builder(context)
                            .trackingGesturesManagement(true)
                            .accuracyColor(ContextCompat.getColor(context, com.mapbox.mapboxsdk.R.color.mapbox_blue))
                            .build()

                        val locationComponentActivationOptions = LocationComponentActivationOptions.builder(context, style)
                            .locationComponentOptions(customLocationComponentOptions)
                            .build()

                        val locationComponent = mapboxMap.locationComponent

                        locationComponent.activateLocationComponent(locationComponentActivationOptions)

                        locationComponent.isLocationComponentEnabled = true
                        locationComponent.cameraMode = CameraMode.TRACKING
                        locationComponent.renderMode = RenderMode.COMPASS

                        // Marker handling
                        val customIcon = BitmapFactory.decodeResource(context.resources, R.drawable.pointer)
                        style.addImage("custom-marker", customIcon)

                        val markerSource = GeoJsonSource("marker-source")
                        style.addSource(markerSource)
                        currentMarkerSource = markerSource

                        style.addLayer(SymbolLayer("marker-layer", "marker-source").withProperties(
                            PropertyFactory.iconImage("custom-marker"),
                            PropertyFactory.iconAnchor(Property.ICON_ANCHOR_BOTTOM),
                            PropertyFactory.iconSize(0.05f),
                            PropertyFactory.iconAllowOverlap(true),
                            PropertyFactory.iconIgnorePlacement(true)
                        ))

                        mapboxMap.addOnMapClickListener { point ->
                            val screenPoint = mapboxMap.projection.toScreenLocation(point)
                            val features = mapboxMap.queryRenderedFeatures(screenPoint, "alerts-fill-layer")

                            if (features.isNotEmpty()) {
                                val selectedFeature = features.first()
                                val selectedFeatureProperties = parseFeatureProperties(selectedFeature)
                                selectedFeatureProperties?.let { properties ->
                                    showAlertDialog(context, properties)
                                }
                            } else {
                                val feature = Feature.fromGeometry(Point.fromLngLat(point.longitude, point.latitude))
                                currentMarkerSource?.setGeoJson(FeatureCollection.fromFeatures(arrayOf(feature)))
                                forecastViewModel.fetchWeatherForLocation(point.latitude, point.longitude)
                                coroutineScope.launch { bottomSheetState.show() }
                            }
                            true
                        }
                    }
                }
            }

            LaunchedEffect(filteredFeatures) {
                filteredFeatures?.let { features ->
                    Log.d("UI Display", "Displaying Features: ${features.map { it.properties }.joinToString()}")
                    mapView.getMapAsync { mapboxMap ->
                        mapboxMap.addAlertOverlay(context, features)
                    }
                }
            }

            RadiusSelector(
                radius = radius,
                onRadiusChange = { newRadius ->
                    alertsViewModel.fetchAndFilterAlerts(AlertsInfo(), userLocation, newRadius)
                    mapboxMapState.value?.updateSearchArea(userLocation, newRadius)
                    Log.d("RadiusSelector", "${mapboxMapState.value}")
                },
                mapboxMap = mapboxMapState.value,
                centerLocation = userLocation
            )
        }
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
fun MapboxMap.addAlertOverlay(context: Context, myFeatures: List<MyFeature>) {
    val featureCollection = convertFeaturesToFeatureCollection(myFeatures)
    val sourceId = "alerts-source"
    val fillLayerId = "alerts-fill-layer"

    getStyle { style ->
        if (style.getSource(sourceId) == null) {
            val geoJsonSource = GeoJsonSource(sourceId, featureCollection)
            style.addSource(geoJsonSource)
        } else {
            (style.getSourceAs<GeoJsonSource>(sourceId))?.setGeoJson(featureCollection)
        }

        if (style.getLayer(fillLayerId) == null) {
            val fillLayer = FillLayer(fillLayerId, sourceId).withProperties(
                // Default color set to red, in case no matrixColor is found
                PropertyFactory.fillColor("red")
            )
            style.addLayer(fillLayer)
        }

        myFeatures.firstOrNull()?.properties?.riskMatrixColor?.let { matrixColor ->
            val fillColor = when(matrixColor.lowercase()) {
                "red" -> "rgba(202, 0, 42, 0.5)"
                "yellow" -> "rgba(255, 176, 66, 0.5)"
                "green" -> "rgba(85, 107, 47, 0.5)"
                else -> "rgba(255, 0, 0, 0.5)" // Default color if riskMatrixColor not defined
            }
            val fillLayer = style.getLayerAs<FillLayer>(fillLayerId)
            fillLayer?.setProperties(PropertyFactory.fillColor(fillColor))
        }
/*
        addOnMapClickListener { point ->
            val screenPoint = projection.toScreenLocation(point)
            val features = queryRenderedFeatures(screenPoint, fillLayerId)

            if (features.isNotEmpty()) {
                val selectedFeature = features.first()
                val selectedFeatureProperties = parseFeatureProperties(selectedFeature)
                selectedFeatureProperties?.let { properties ->
                    showAlertDialog(context, properties)
                    Log.d("MAPSCREEN_ALERT", "Alert clicked: ${properties.title}")
                }
            } else {
                val markerSource = getStyle()?.getSourceAs<GeoJsonSource>("marker-source")
                val feature = Feature.fromGeometry(Point.fromLngLat(point.longitude, point.latitude))
                markerSource?.setGeoJson(FeatureCollection.fromFeatures(arrayOf(feature)))
                Log.d("MAPSCREEN_MARKER", "Marker placed on: ${point.longitude}, ${point.latitude}")
            }
            true
        }
 */
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
                PropertyFactory.fillOpacity(0.3f)
            )
            style.addLayer(fillLayer)
        }
    }
}

@Composable
fun RadiusSelector(radius: MutableState<Double>, onRadiusChange: (Double) -> Unit, mapboxMap: MapboxMap?, centerLocation: LatLng) {
    Slider(
        value = radius.value.toFloat(),
        onValueChange = { newValue ->
            radius.value = newValue.toDouble()
            mapboxMap?.updateSearchArea(centerLocation, radius.value)
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

fun showAlertDialog(context: Context, properties: Properties) {
    val message = createAlertMessage(properties.title ?: "N/A", properties)
    AlertDialog.Builder(context)
        .setTitle("Alert details")
        .setMessage(message)
        .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        .create()
        .show()
}

fun createAlertMessage(title: String, properties: Properties): String {
    val event = title.substringBefore(",") // Grab the first element in 'title' (Event)

    return buildString {
        append("Event: $event\n")
        append("Severity: ${properties.severity ?: "N/A"}\n")
        append("Area: ${properties.area ?: "N/A"}\n")
        append("Description: ${properties.description ?: "N/A"}\n")
        append("Instruction: ${properties.instruction ?: "N/A"}\n")
        append("Ending: ${properties.eventEndingTime ?: "N/A"}\n") // Funker ikke atm, må formatteres.
    }
}

fun parseFeatureProperties(feature: Feature): Properties? {
    feature.properties()?.let { propertiesMap ->
        val propertiesJson = Gson().toJson(propertiesMap)
        Log.d("PARSE_PROPERTIES", "Feature Properties JSON: $propertiesJson")
        return Gson().fromJson(propertiesJson, Properties::class.java)
    }
    return null
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationPermissionRequest(onPermissionGranted: () -> Unit) {
    val locationPermissionState = rememberPermissionState(permission = Manifest.permission.ACCESS_FINE_LOCATION)

    LaunchedEffect(key1 = locationPermissionState.permission) {
        if (locationPermissionState.status.isGranted) {
            onPermissionGranted()
        } else if (!locationPermissionState.status.shouldShowRationale) {
            // If permission is not granted and rationale should not be shown, request permission
            locationPermissionState.launchPermissionRequest()
        }
        // Case where showRationale
    }
}

@Composable
fun BottomSheetContent(timeseries: List<Timeseries>?) {
    timeseries?.firstOrNull()?.let { series ->
        val currentDetails = series.data?.instant
        val nextHoursDetails = series.data?.next_1_hours
        val next6HoursDetails = series.data?.next_6_hours

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text("Været nå:", style = MaterialTheme.typography.h6)
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                currentDetails?.let {
                    WeatherIcon(element = nextHoursDetails?.summary?.symbol_code)
                    Text("${it.details?.air_temperature}°", color = Color.Red, fontSize = 30.sp)
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Blue, fontSize = 30.sp)) {
                            append("${nextHoursDetails?.details?.precipitation_amount}")
                        }
                        withStyle(style = SpanStyle(color = Color.Blue, fontSize = 10.sp)) {
                            append(" mm")
                        }
                    })
                    //Text("${it.details?.wind_speed} m/s")
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(color = "#00145D".color, fontSize = 30.sp)) {
                            append("${it.details?.wind_speed}")
                        }
                        withStyle(style = SpanStyle(color = "#00145D".color, fontSize = 10.sp)) {
                            append(" m/s")
                        }
                    })
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Været neste 6 timene:", style = MaterialTheme.typography.h6)
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                next6HoursDetails?.let {
                    WeatherIcon(element = it.summary?.symbol_code)
                    Text("${it.details?.air_temperature_min} - ${it.details?.air_temperature_max}°", color = Color.Red, fontSize = 25.sp)
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Blue, fontSize = 25.sp)) {
                            append("${it.details?.precipitation_amount}")
                        }
                        withStyle(style = SpanStyle(color = Color.Blue, fontSize = 10.sp)) {
                            append(" mm")
                        }
                    })
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(color = "#00145D".color, fontSize = 25.sp)) {
                            append("${it.details?.probability_of_precipitation}")
                        }
                        withStyle(style = SpanStyle(color = "#00145D".color, fontSize = 10.sp)) {
                            append(" %")
                        }
                    })
                }
            }
        }
    }
}


// Function to simplify the process of applying hex colors.
val String.color
    get() = Color(parseColor(this))