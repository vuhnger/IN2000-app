package no.uio.ifi.in2000.team_21.ui.map

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color.parseColor
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
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
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
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
import androidx.core.view.children
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.gson.Gson
import com.mapbox.geojson.FeatureCollection
import com.mapbox.geojson.Point
import com.mapbox.geojson.Polygon
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.MapboxMap
import com.mapbox.maps.QueriedRenderedFeature
import com.mapbox.maps.RenderedQueryGeometry
import com.mapbox.maps.RenderedQueryOptions
import com.mapbox.maps.ScreenCoordinate
import com.mapbox.maps.Style
import com.mapbox.maps.extension.style.expressions.generated.Expression
import com.mapbox.maps.extension.style.layers.addLayer
import com.mapbox.maps.extension.style.layers.generated.FillLayer
import com.mapbox.maps.extension.style.layers.generated.fillLayer
import com.mapbox.maps.extension.style.layers.getLayer
import com.mapbox.maps.extension.style.layers.getLayerAs
import com.mapbox.maps.extension.style.sources.addSource
import com.mapbox.maps.extension.style.sources.generated.GeoJsonSource
import com.mapbox.maps.extension.style.sources.generated.geoJsonSource
import com.mapbox.maps.extension.style.sources.getSourceAs
import com.mapbox.maps.plugin.gestures.addOnMapClickListener
import com.mapbox.maps.plugin.gestures.addOnMapLongClickListener
import com.mapbox.maps.plugin.locationcomponent.createDefault2DPuck
import com.mapbox.maps.plugin.locationcomponent.location
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.team_21.R
import no.uio.ifi.in2000.team_21.container.MapBoxDataTransformer.convertFeaturesToFeatureCollection
import no.uio.ifi.in2000.team_21.container.UserMarkerViewModelFactory
import no.uio.ifi.in2000.team_21.data.database.MapAnnotationHelper
import no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity
import no.uio.ifi.in2000.team_21.model.AlertsInfo
import no.uio.ifi.in2000.team_21.model.Properties
import no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries
import no.uio.ifi.in2000.team_21.model.oceanforecast.Timeseries
import no.uio.ifi.in2000.team_21.ui.home.TopBarComponent
import no.uio.ifi.in2000.team_21.ui.home.WeatherIcon
import no.uio.ifi.in2000.team_21.ui.theme.Background
import no.uio.ifi.in2000.team_21.ui.theme.MidnightBlue
import no.uio.ifi.in2000.team_21.ui.theme.Rain
import no.uio.ifi.in2000.team_21.ui.theme.Temperature
import no.uio.ifi.in2000.team_21.ui.theme.Wind
import no.uio.ifi.in2000.team_21.ui.viewmodels.ForecastViewModel
import no.uio.ifi.in2000.team_21.ui.viewmodels.UserMarkerViewModel
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin
import no.uio.ifi.in2000.team_21.model.Feature as MyFeature

@Composable
fun MapScreen(
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBarComponent(navController = navController)
        Box(modifier = Modifier.weight(1f)) {
            MapboxMapView()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MapboxMapView() {
    val context = LocalContext.current
    val mapView = rememberMapViewWithLifecycle(context)
    val mapboxMap = mapView.mapboxMap
    val mapboxMapState = remember { mutableStateOf<MapboxMap?>(null) }
    val lifecycleOwner = LocalLifecycleOwner.current
    val alertsViewModel: AlertsViewModel = viewModel()
    val filteredFeatures by alertsViewModel.filteredFeatures.observeAsState()
    //val annotationHelper = remember { MapAnnotationHelper(mapView) }
    val radius = remember { mutableStateOf(500.0) }
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    var userLocation by remember { mutableStateOf(Point.fromLngLat(0.0, 0.0)) }
    var cameraInitialized by remember { mutableStateOf(false)}
    val selectedMarker = remember { mutableStateOf<UserMarkerEntity?>(null) }
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    val selectedLocationWeatherData = remember { mutableStateOf<List<Timeseries>?>(null)}
    val forecastViewModel: ForecastViewModel = viewModel()
    val application = LocalContext.current.applicationContext as Application
    val userMarkerViewModel: UserMarkerViewModel = viewModel(factory = UserMarkerViewModelFactory(application))

    val annotationHelper = remember {
        MapAnnotationHelper(mapView, context) { marker ->
            selectedMarker.value = marker
            forecastViewModel.fetchWeatherForLocation(marker.latitude, marker.longitude)
            coroutineScope.launch {
                bottomSheetState.show()
            }
        }
    }


    LocationPermissionRequest(onPermissionGranted = {
        val locationRequest = LocationRequest.create().apply {
            interval = 10000 // Update interval in milliseconds
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        }

        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                locationResult.locations.firstOrNull()?.let { location ->
                    val newPoint = Point.fromLngLat(location.longitude, location.latitude)
                    userLocation = newPoint
                    if (!cameraInitialized) {
                        mapboxMap.setCamera(CameraOptions.Builder().center(newPoint).zoom(10.0).build())
                        cameraInitialized = true
                    }
                }
            }
        }

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper())
        } else {

        }
    })

    AndroidView({ mapView }, Modifier.fillMaxSize()) { mapView ->
        mapView.mapboxMap.loadStyle(Style.MAPBOX_STREETS) { style ->
            setupLocationComponent(mapView)
            setupMapInteractions(mapboxMap, style, context, coroutineScope, forecastViewModel, bottomSheetState, userMarkerViewModel, annotationHelper, selectedMarker)
        }
    }

    LaunchedEffect(annotationHelper) {
        userMarkerViewModel.loadSavedMarkers { markers ->
            annotationHelper.displaySavedMarkers(markers)
        }
    }

    LaunchedEffect(filteredFeatures) {
        filteredFeatures?.let { features ->
            mapView.mapboxMap.addAlertOverlay(context, features)
        }
    }

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            BottomSheetContent(
                timeseries = forecastViewModel.selectedLocationWeatherData.value,
                annotationHelper = annotationHelper,
                marker = selectedMarker.value,
                userMarkerViewModel = userMarkerViewModel,
                forecastViewModel = forecastViewModel
                )
        },
        sheetBackgroundColor = Background,
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 40.dp)) {
            RadiusSelector(
                radius = radius,
                onRadiusChange = { newRadius ->
                    alertsViewModel.fetchAndFilterAlerts(AlertsInfo(), userLocation, newRadius)
                    mapboxMap.updateSearchArea(userLocation, newRadius)
                },
                mapboxMap = mapboxMap,
                centerLocation = userLocation
            )
        }
    }
    DisposableEffect(Unit) {
        onDispose {

            mapView.location.enabled = false
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
fun setupMapInteractions(
    mapboxMap: MapboxMap,
    style: Style,
    context: Context,
    coroutineScope: CoroutineScope,
    forecastViewModel: ForecastViewModel,
    bottomSheetState: ModalBottomSheetState,
    userMarkerViewModel: UserMarkerViewModel,
    annotationHelper: MapAnnotationHelper,
    selectedMarker: MutableState<UserMarkerEntity?>
) {
    mapboxMap.addOnMapClickListener { point ->
        handleMapClick(point, mapboxMap, context, coroutineScope, forecastViewModel, bottomSheetState, selectedMarker)
        true
    }
    mapboxMap.addOnMapLongClickListener { point ->
        showSaveLocationDialog(context, point, userMarkerViewModel, annotationHelper)
        true
    }
}

@OptIn(ExperimentalMaterialApi::class)
fun handleMapClick(
    point: Point,
    mapboxMap: MapboxMap,
    context: Context,
    coroutineScope: CoroutineScope,
    forecastViewModel: ForecastViewModel,
    bottomSheetState: ModalBottomSheetState,
    selectedMarker: MutableState<UserMarkerEntity?>
) {
    val screenPoint = mapboxMap.pixelForCoordinate(point)
    val queryGeometry = RenderedQueryGeometry(ScreenCoordinate(screenPoint.x, screenPoint.y))
    val queryOptions = RenderedQueryOptions(listOf("alerts-fill-layer"), null)

    mapboxMap.queryRenderedFeatures(queryGeometry, queryOptions) { result ->
        result.value?.let { features ->
            if (features.isNotEmpty()) {
                val selectedFeature = features.first()
                val properties = parseFeatureProperties(selectedFeature)
                properties?.let {
                    showAlertDialog(context, it)
                }
            } else {
                forecastViewModel.fetchWeatherForLocation(point.latitude(), point.longitude())
                coroutineScope.launch {
                    bottomSheetState.show()
                }
                selectedMarker.value = null
            }
        }
    }
}

@Composable
fun rememberMapViewWithLifecycle(context: Context): MapView {
    return remember { MapView(context) }
}


fun MapboxMap.addAlertOverlay(context: Context, myFeatures: List<MyFeature>) {
    val featureCollection = convertFeaturesToFeatureCollection(myFeatures)
    val sourceId = "alerts-source"
    val fillLayerId = "alerts-fill-layer"

    this.getStyle { style ->
        var geoJsonSource = style.getSourceAs<GeoJsonSource>(sourceId)
        if (geoJsonSource == null) {
            geoJsonSource = GeoJsonSource.Builder(sourceId)
                .featureCollection(featureCollection)
                .build()
            style.addSource(geoJsonSource)
        } else {
            geoJsonSource.featureCollection(featureCollection)
        }

        var fillLayer = style.getLayerAs<FillLayer>(fillLayerId)
        if (fillLayer == null) {
            fillLayer = FillLayer(fillLayerId, sourceId).apply {
                fillColor("red")
            }
            style.addLayer(fillLayer)
        } else {
            fillLayer.fillColor(Expression.literal("red"))
        }

        myFeatures.firstOrNull()?.properties?.riskMatrixColor?.let { matrixColor ->
            val fillColor = when(matrixColor.lowercase()) {
                "red" -> "rgba(202, 0, 42, 0.5)"
                "yellow" -> "rgba(255, 176, 66, 0.5)"
                "green" -> "rgba(85, 107, 47, 0.5)"
                else -> "rgba(255, 176, 66, 0.5)"
            }
            fillLayer.fillColor(Expression.literal(fillColor))
        }
    }
}

fun MapboxMap.updateSearchArea(center: Point, radiusKm: Double) {
    val radiusM = radiusKm * 1000
    val circlePoints = mutableListOf<Point>()
    val steps = 64
    val centerLat = center.latitude()
    val centerLng = center.longitude()
    val distanceX = radiusM / (111320 * cos(Math.toRadians(centerLat)))
    val distanceY = radiusM / 110540

    for (i in 0 until steps) {
        val theta = (i.toDouble() / steps) * (2 * Math.PI)
        val x = distanceX * cos(theta)
        val y = distanceY * sin(theta)
        circlePoints.add(Point.fromLngLat(centerLng + x, centerLat + y))
    }

    val polygon = Polygon.fromLngLats(listOf(circlePoints))
    val sourceId = "search-area-source"

    this.getStyle { style ->
        val source = style.getSourceAs<GeoJsonSource>(sourceId)
        if (source == null) {
            style.addSource(geoJsonSource(sourceId) {
                data(polygon.toJson())
            })
            if (style.getLayer("search-area-layer") == null) {
                style.addLayer(fillLayer("search-area-layer", sourceId) {
                    fillColor("rgba(0, 0, 255, 0.3)")
                    fillOpacity(0.5)
                })
            }
        } else {
            source.geometry(polygon)
        }
    }
}

@Composable
fun RadiusSelector(radius: MutableState<Double>, onRadiusChange: (Double) -> Unit, mapboxMap: MapboxMap?, centerLocation: Point) {
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
        colors = SliderDefaults.colors(
            thumbColor = MidnightBlue,
            activeTrackColor = MidnightBlue,
            inactiveTrackColor = Background,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    )
}

fun MapboxMap.clearSearchArea() {
    this.getStyle { style ->
        val sourceId = "search-area-source"
        style.getSourceAs<GeoJsonSource>(sourceId)?.let { existingSource ->
            val emptyData = FeatureCollection.fromFeatures(emptyList()).toJson()
            existingSource.data(emptyData)
        }
    }
}

fun showAlertDialog(context: Context, properties: Properties) {
    val message = createAlertMessage(properties.title ?: "N/A", properties)
    AlertDialog.Builder(context)
        .setTitle("Varseldetaljer")
        .setMessage(message)
        .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        .create()
        .show()
}

fun createAlertMessage(title: String, properties: Properties): String {
    val event = title.substringBefore(",")

    return buildString {
        append("Event: $event\n")
        append("Severity: ${properties.severity ?: "N/A"}\n")
        append("Area: ${properties.area ?: "N/A"}\n")
        //append("Description: ${properties.description ?: "N/A"}\n")
        append("Instruction: ${properties.instruction ?: "N/A"}\n")
        append("Ending: ${properties.eventEndingTime ?: "N/A"}\n") // Funker ikke atm, må formatteres.
    }
}

fun parseFeatureProperties(queriedRenderedFeature: QueriedRenderedFeature): Properties? {
    val feature = queriedRenderedFeature.queriedFeature.feature
    val propertiesMap = feature.properties()
    val propertiesJson = Gson().toJson(propertiesMap)
    Log.d("PARSE_PROPERTIES", "Feature Properties JSON: $propertiesJson")

    // Deserialize JSON to Properties object
    return Gson().fromJson(propertiesJson, Properties::class.java)
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationPermissionRequest(onPermissionGranted: () -> Unit) {
    val locationPermissionState = rememberPermissionState(permission = Manifest.permission.ACCESS_FINE_LOCATION)

    LaunchedEffect(key1 = locationPermissionState) {
        when {
            locationPermissionState.status.isGranted -> {
                onPermissionGranted()
            }
            locationPermissionState.status.shouldShowRationale -> {

            }
            else -> {
                locationPermissionState.launchPermissionRequest()
            }
        }
    }
}

@Composable
fun BottomSheetContent(
    timeseries: List<LocationForecastTimeseries>?,
    marker: UserMarkerEntity?,
    annotationHelper: MapAnnotationHelper,
    userMarkerViewModel: UserMarkerViewModel,
    forecastViewModel: ForecastViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        marker?.name?.let {
            Text(marker.name, style = MaterialTheme.typography.h5, modifier = Modifier.padding(bottom = 8.dp))
        }

        timeseries?.firstOrNull()?.let { series ->
            val currentDetails = series.data?.instant
            val nextHoursDetails = series.data?.next_1_hours
            val next6HoursDetails = series.data?.next_6_hours

            Text("Været nå:", style = MaterialTheme.typography.h6, color = MidnightBlue)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                currentDetails?.let {
                    WeatherIcon(element = nextHoursDetails?.summary?.symbol_code)
                    Text("${it.details?.air_temperature}°", color = Temperature, fontSize = 30.sp)
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Rain, fontSize = 30.sp)) {
                            append("${nextHoursDetails?.details?.precipitation_amount}")
                        }
                        withStyle(style = SpanStyle(color = Rain, fontSize = 10.sp)) {
                            append(" mm")
                        }
                    })
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Wind, fontSize = 30.sp)) {
                            append("${it.details?.wind_speed}")
                        }
                        withStyle(style = SpanStyle(color = Wind, fontSize = 10.sp)) {
                            append(" m/s")
                        }
                    })
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Været neste 6 timene:", style = MaterialTheme.typography.h6, color = MidnightBlue)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                next6HoursDetails?.let {
                    WeatherIcon(element = it.summary?.symbol_code)
                    Text(
                        "H:${it.details?.air_temperature_max?.roundToInt()}° L:${it.details?.air_temperature_min?.roundToInt()}°",

                        color = Temperature,
                        fontSize = 25.sp
                    )/*
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Rain, fontSize = 25.sp)) {
                            append("${it.details?.precipitation_amount}")
                        }
                        withStyle(style = SpanStyle(color = Rain, fontSize = 10.sp)) {
                            append(" mm")
                        }
                    })*/
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Rain, fontSize = 25.sp)) {
                            append("${it.details?.probability_of_precipitation}%")
                        }
                        //test om denne er nødvendig
                        /*
                        withStyle(style = SpanStyle(color = Rain, fontSize = 10.sp)) {
                            append(" sjanse for regn")
                        }*/
                    })
                }
            }
            marker?.let {
                Button(
                    onClick = {
                        annotationHelper.deleteAnnotation(it.annotationId)
                        userMarkerViewModel.deleteUserMarker(it)
                        // TODO: Oppdatere view
                    },
                    modifier = Modifier.padding(top = 16.dp),
                ) {
                    Text("Slett punkt")
                }
            }
        }
    }
}

fun showSaveLocationDialog(context: Context, point: Point, viewModel: UserMarkerViewModel, annotationHelper: MapAnnotationHelper) {
    val dialogView = LayoutInflater.from(context).inflate(R.layout.save_location_dialog, null)
    val editTextName = dialogView.findViewById<EditText>(R.id.editTextLocationName)
    val iconsContainer = dialogView.findViewById<LinearLayout>(R.id.icon_selection_container)

    val icons = listOf(
        R.drawable.fishing,
        R.drawable.rowing,
        R.drawable.scuba,
        R.drawable.surfing,
        R.drawable.swimming,
        R.drawable.waterski
    )

    val dialog = AlertDialog.Builder(context).apply {
        setTitle("Lagre punkt")
        setView(dialogView)
        setPositiveButton("Lagre", null)
        setNegativeButton("Avbryt", null)
    }.create()

    var selectedIconResId: Int? = null

    icons.forEach { iconResId ->
        val imageView = ImageView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                marginEnd = 8
            }
            setImageResource(iconResId)
            setOnClickListener {
                selectedIconResId = iconResId
                iconsContainer.children.forEach { view ->
                    view.background = null
                }
                background = ContextCompat.getDrawable(context, R.drawable.selected_icon_background)
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).isEnabled = editTextName.text.toString().trim().isNotEmpty() && selectedIconResId != null
            }
        }
        iconsContainer.addView(imageView)
    }

    dialog.setOnShowListener {
        val positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        positiveButton.isEnabled = false

        positiveButton.setOnClickListener {
            val name = editTextName.text.toString().trim()
            if (selectedIconResId != null && name.isNotEmpty()) {
                annotationHelper.saveLocation(name, point, selectedIconResId!!, viewModel)
                dialog.dismiss()
            }
        }

        editTextName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                positiveButton.isEnabled = s.toString().trim().isNotEmpty() && selectedIconResId != null
            }
            override fun afterTextChanged(s: Editable) {}
        })
    }
    dialog.show()
}

fun setupLocationComponent(mapView: MapView) {
        mapView.location.apply {
            enabled = true
            locationPuck = createDefault2DPuck()
        }
}



val String.color
    get() = Color(parseColor(this))