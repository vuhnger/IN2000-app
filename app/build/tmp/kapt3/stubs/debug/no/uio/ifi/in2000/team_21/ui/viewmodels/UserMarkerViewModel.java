package no.uio.ifi.in2000.team_21.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u000bJ \u0010\u0014\u001a\u00020\u000e2\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0017\u0012\u0004\u0012\u00020\u000e0\u0016J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lno/uio/ifi/in2000/team_21/ui/viewmodels/UserMarkerViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "dao", "Lno/uio/ifi/in2000/team_21/data/database/LocationDao;", "database", "Lno/uio/ifi/in2000/team_21/data/database/AppDatabase;", "markerMap", "", "", "Lno/uio/ifi/in2000/team_21/data/database/UserMarkerEntity;", "addMarkerToMap", "", "userMarkerEntity", "markerId", "deleteUserMarker", "getMarkerById", "id", "loadSavedMarkers", "onMarkersLoaded", "Lkotlin/Function1;", "", "saveUserLocation", "updateUserMarker", "app_debug"})
public final class UserMarkerViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.database.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.database.LocationDao dao = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity> markerMap = null;
    
    public UserMarkerViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    public final void saveUserLocation(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity userMarkerEntity) {
    }
    
    public final void addMarkerToMap(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity userMarkerEntity, @org.jetbrains.annotations.NotNull
    java.lang.String markerId) {
    }
    
    public final void deleteUserMarker(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity userMarkerEntity) {
    }
    
    public final void updateUserMarker(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity userMarkerEntity) {
    }
    
    public final void loadSavedMarkers(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity>, kotlin.Unit> onMarkersLoaded) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity getMarkerById(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
        return null;
    }
}