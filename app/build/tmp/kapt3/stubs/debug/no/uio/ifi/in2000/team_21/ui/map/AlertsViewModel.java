package no.uio.ifi.in2000.team_21.ui.map;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lno/uio/ifi/in2000/team_21/ui/map/AlertsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lno/uio/ifi/in2000/team_21/data/AlertsRepository;", "(Lno/uio/ifi/in2000/team_21/data/AlertsRepository;)V", "_alerts", "Landroidx/lifecycle/MutableLiveData;", "Lno/uio/ifi/in2000/team_21/model/Alert;", "_filteredFeatures", "", "Lno/uio/ifi/in2000/team_21/model/Feature;", "alerts", "Landroidx/lifecycle/LiveData;", "getAlerts", "()Landroidx/lifecycle/LiveData;", "filteredFeatures", "getFilteredFeatures", "fetchAlerts", "", "parameters", "Lno/uio/ifi/in2000/team_21/model/AlertsInfo;", "fetchAndFilterAlerts", "userLocation", "Lcom/mapbox/geojson/Point;", "radius", "", "app_debug"})
public final class AlertsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.AlertsRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<no.uio.ifi.in2000.team_21.model.Alert> _alerts = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<no.uio.ifi.in2000.team_21.model.Alert> alerts = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<no.uio.ifi.in2000.team_21.model.Feature>> _filteredFeatures = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<no.uio.ifi.in2000.team_21.model.Feature>> filteredFeatures = null;
    
    public AlertsViewModel(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.AlertsRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<no.uio.ifi.in2000.team_21.model.Alert> getAlerts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<no.uio.ifi.in2000.team_21.model.Feature>> getFilteredFeatures() {
        return null;
    }
    
    public final void fetchAlerts(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.AlertsInfo parameters) {
    }
    
    public final void fetchAndFilterAlerts(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.AlertsInfo parameters, @org.jetbrains.annotations.NotNull
    com.mapbox.geojson.Point userLocation, double radius) {
    }
    
    public AlertsViewModel() {
        super();
    }
}