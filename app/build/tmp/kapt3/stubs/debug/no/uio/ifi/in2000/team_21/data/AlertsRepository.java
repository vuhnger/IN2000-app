package no.uio.ifi.in2000.team_21.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ1\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lno/uio/ifi/in2000/team_21/data/AlertsRepository;", "", "dataSource", "Lno/uio/ifi/in2000/team_21/data/AlertsDataSource;", "(Lno/uio/ifi/in2000/team_21/data/AlertsDataSource;)V", "fetchAlerts", "Lno/uio/ifi/in2000/team_21/model/Alert;", "parameters", "Lno/uio/ifi/in2000/team_21/model/AlertsInfo;", "(Lno/uio/ifi/in2000/team_21/model/AlertsInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAndFilterAlerts", "", "Lno/uio/ifi/in2000/team_21/model/Feature;", "userLocation", "Lcom/mapbox/geojson/Point;", "radius", "", "(Lno/uio/ifi/in2000/team_21/model/AlertsInfo;Lcom/mapbox/geojson/Point;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterAlertsByRadius", "allFeatures", "haversine", "lat1", "lon1", "lat2", "lon2", "app_debug"})
public final class AlertsRepository {
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.AlertsDataSource dataSource = null;
    
    public AlertsRepository(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.AlertsDataSource dataSource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object fetchAlerts(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.AlertsInfo parameters, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super no.uio.ifi.in2000.team_21.model.Alert> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object fetchAndFilterAlerts(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.AlertsInfo parameters, @org.jetbrains.annotations.NotNull
    com.mapbox.geojson.Point userLocation, double radius, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<no.uio.ifi.in2000.team_21.model.Feature>> $completion) {
        return null;
    }
    
    private final double haversine(double lat1, double lon1, double lat2, double lon2) {
        return 0.0;
    }
    
    private final java.util.List<no.uio.ifi.in2000.team_21.model.Feature> filterAlertsByRadius(java.util.List<no.uio.ifi.in2000.team_21.model.Feature> allFeatures, com.mapbox.geojson.Point userLocation, double radius) {
        return null;
    }
}