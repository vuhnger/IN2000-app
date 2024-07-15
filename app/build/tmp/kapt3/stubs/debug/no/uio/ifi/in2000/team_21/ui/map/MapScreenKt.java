package no.uio.ifi.in2000.team_21.ui.map;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u00a0\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a2\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0016\u0010\u0010\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0007\u001a\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0007\u001a\b\u0010\u0016\u001a\u00020\u0006H\u0007\u001a<\u0010\u0017\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\u0016\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$\u001aF\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0019\u001a\u0010\u00100\u001a\u0004\u0018\u00010$2\u0006\u00101\u001a\u000202\u001a\u0010\u00103\u001a\u0002042\u0006\u0010\'\u001a\u00020(H\u0007\u001a\u000e\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u000204\u001aV\u00107\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00108\u001a\u0002092\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0019\u001a\u0016\u0010:\u001a\u00020\u00062\u0006\u0010\'\u001a\u00020(2\u0006\u0010#\u001a\u00020$\u001a&\u0010;\u001a\u00020\u00062\u0006\u0010\'\u001a\u00020(2\u0006\u0010&\u001a\u00020 2\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r\u001a \u0010=\u001a\u00020\u0006*\u00020\u001e2\u0006\u0010\'\u001a\u00020(2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\b\u001a\n\u0010@\u001a\u00020\u0006*\u00020\u001e\u001a\u001a\u0010A\u001a\u00020\u0006*\u00020\u001e2\u0006\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020\u001a\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006D"}, d2 = {"color", "Landroidx/compose/ui/graphics/Color;", "", "getColor", "(Ljava/lang/String;)J", "BottomSheetContent", "", "timeseries", "", "Lno/uio/ifi/in2000/team_21/model/locationforcast/LocationForecastTimeseries;", "marker", "Lno/uio/ifi/in2000/team_21/data/database/UserMarkerEntity;", "annotationHelper", "Lno/uio/ifi/in2000/team_21/data/database/MapAnnotationHelper;", "userMarkerViewModel", "Lno/uio/ifi/in2000/team_21/ui/viewmodels/UserMarkerViewModel;", "LocationPermissionRequest", "onPermissionGranted", "Lkotlin/Function0;", "MapScreen", "navController", "Landroidx/navigation/NavController;", "MapboxMapView", "RadiusSelector", "radius", "Landroidx/compose/runtime/MutableState;", "", "onRadiusChange", "Lkotlin/Function1;", "mapboxMap", "Lcom/mapbox/maps/MapboxMap;", "centerLocation", "Lcom/mapbox/geojson/Point;", "createAlertMessage", "title", "properties", "Lno/uio/ifi/in2000/team_21/model/Properties;", "handleMapClick", "point", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "forecastViewModel", "Lno/uio/ifi/in2000/team_21/ui/viewmodels/ForecastViewModel;", "bottomSheetState", "Landroidx/compose/material/ModalBottomSheetState;", "selectedMarker", "parseFeatureProperties", "queriedRenderedFeature", "Lcom/mapbox/maps/QueriedRenderedFeature;", "rememberMapViewWithLifecycle", "Lcom/mapbox/maps/MapView;", "setupLocationComponent", "mapView", "setupMapInteractions", "style", "Lcom/mapbox/maps/Style;", "showAlertDialog", "showSaveLocationDialog", "viewModel", "addAlertOverlay", "myFeatures", "Lno/uio/ifi/in2000/team_21/model/Feature;", "clearSearchArea", "updateSearchArea", "center", "radiusKm", "app_debug"})
public final class MapScreenKt {
    
    @androidx.compose.runtime.Composable
    public static final void MapScreen(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material.ExperimentalMaterialApi.class})
    @androidx.compose.runtime.Composable
    public static final void MapboxMapView() {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material.ExperimentalMaterialApi.class})
    public static final void setupMapInteractions(@org.jetbrains.annotations.NotNull
    com.mapbox.maps.MapboxMap mapboxMap, @org.jetbrains.annotations.NotNull
    com.mapbox.maps.Style style, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.ForecastViewModel forecastViewModel, @org.jetbrains.annotations.NotNull
    androidx.compose.material.ModalBottomSheetState bottomSheetState, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.UserMarkerViewModel userMarkerViewModel, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.MapAnnotationHelper annotationHelper, @org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity> selectedMarker) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material.ExperimentalMaterialApi.class})
    public static final void handleMapClick(@org.jetbrains.annotations.NotNull
    com.mapbox.geojson.Point point, @org.jetbrains.annotations.NotNull
    com.mapbox.maps.MapboxMap mapboxMap, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.ForecastViewModel forecastViewModel, @org.jetbrains.annotations.NotNull
    androidx.compose.material.ModalBottomSheetState bottomSheetState, @org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity> selectedMarker) {
    }
    
    @androidx.compose.runtime.Composable
    @org.jetbrains.annotations.NotNull
    public static final com.mapbox.maps.MapView rememberMapViewWithLifecycle(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    public static final void addAlertOverlay(@org.jetbrains.annotations.NotNull
    com.mapbox.maps.MapboxMap $this$addAlertOverlay, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<no.uio.ifi.in2000.team_21.model.Feature> myFeatures) {
    }
    
    public static final void updateSearchArea(@org.jetbrains.annotations.NotNull
    com.mapbox.maps.MapboxMap $this$updateSearchArea, @org.jetbrains.annotations.NotNull
    com.mapbox.geojson.Point center, double radiusKm) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RadiusSelector(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.Double> radius, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Double, kotlin.Unit> onRadiusChange, @org.jetbrains.annotations.Nullable
    com.mapbox.maps.MapboxMap mapboxMap, @org.jetbrains.annotations.NotNull
    com.mapbox.geojson.Point centerLocation) {
    }
    
    public static final void clearSearchArea(@org.jetbrains.annotations.NotNull
    com.mapbox.maps.MapboxMap $this$clearSearchArea) {
    }
    
    public static final void showAlertDialog(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.Properties properties) {
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String createAlertMessage(@org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.Properties properties) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final no.uio.ifi.in2000.team_21.model.Properties parseFeatureProperties(@org.jetbrains.annotations.NotNull
    com.mapbox.maps.QueriedRenderedFeature queriedRenderedFeature) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {com.google.accompanist.permissions.ExperimentalPermissionsApi.class})
    @androidx.compose.runtime.Composable
    public static final void LocationPermissionRequest(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onPermissionGranted) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void BottomSheetContent(@org.jetbrains.annotations.Nullable
    java.util.List<no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries> timeseries, @org.jetbrains.annotations.Nullable
    no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity marker, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.MapAnnotationHelper annotationHelper, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.UserMarkerViewModel userMarkerViewModel) {
    }
    
    public static final void showSaveLocationDialog(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.mapbox.geojson.Point point, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.UserMarkerViewModel viewModel, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.MapAnnotationHelper annotationHelper) {
    }
    
    public static final void setupLocationComponent(@org.jetbrains.annotations.NotNull
    com.mapbox.maps.MapView mapView) {
    }
    
    public static final long getColor(@org.jetbrains.annotations.NotNull
    java.lang.String $this$color) {
        return 0L;
    }
}