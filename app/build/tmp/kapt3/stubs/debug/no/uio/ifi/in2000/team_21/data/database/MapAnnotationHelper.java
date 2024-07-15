package no.uio.ifi.in2000.team_21.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\rJ\u0014\u0010\u0013\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015J&\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\tJ\b\u0010\u001f\u001a\u00020\tH\u0002R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lno/uio/ifi/in2000/team_21/data/database/MapAnnotationHelper;", "", "mapView", "Lcom/mapbox/maps/MapView;", "context", "Landroid/content/Context;", "onClick", "Lkotlin/Function1;", "Lno/uio/ifi/in2000/team_21/data/database/UserMarkerEntity;", "", "(Lcom/mapbox/maps/MapView;Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "annotationsMap", "", "", "pointAnnotationManager", "Lcom/mapbox/maps/plugin/annotation/generated/PointAnnotationManager;", "clearAnnotations", "deleteAnnotation", "annotationId", "displaySavedMarkers", "savedLocations", "", "saveLocation", "name", "point", "Lcom/mapbox/geojson/Point;", "iconResId", "", "viewModel", "Lno/uio/ifi/in2000/team_21/ui/viewmodels/UserMarkerViewModel;", "setupCustomIcons", "setupPointAnnotationManager", "app_debug"})
public final class MapAnnotationHelper {
    @org.jetbrains.annotations.NotNull
    private final com.mapbox.maps.MapView mapView = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity, kotlin.Unit> onClick = null;
    @org.jetbrains.annotations.Nullable
    private com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager pointAnnotationManager;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity> annotationsMap = null;
    
    public MapAnnotationHelper(@org.jetbrains.annotations.NotNull
    com.mapbox.maps.MapView mapView, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity, kotlin.Unit> onClick) {
        super();
    }
    
    private final void setupPointAnnotationManager() {
    }
    
    public final void saveLocation(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    com.mapbox.geojson.Point point, int iconResId, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.UserMarkerViewModel viewModel) {
    }
    
    public final void displaySavedMarkers(@org.jetbrains.annotations.NotNull
    java.util.List<no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity> savedLocations) {
    }
    
    public final void deleteAnnotation(@org.jetbrains.annotations.NotNull
    java.lang.String annotationId) {
    }
    
    public final void clearAnnotations() {
    }
    
    public final void setupCustomIcons() {
    }
}