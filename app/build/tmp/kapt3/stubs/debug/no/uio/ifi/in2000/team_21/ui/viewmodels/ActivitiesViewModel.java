package no.uio.ifi.in2000.team_21.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'J\u000e\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u0004\u0018\u00010\'2\u0006\u0010,\u001a\u00020*J\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u001a2\u0006\u0010,\u001a\u00020*J\b\u0010/\u001a\u00020%H\u0002J\u0006\u00100\u001a\u00020%J\u0016\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020*2\u0006\u0010&\u001a\u00020\'J\u0016\u00103\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010&\u001a\u00020\'J\u000e\u00104\u001a\u00020%2\u0006\u0010,\u001a\u00020*R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\n0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001d\u00a8\u00065"}, d2 = {"Lno/uio/ifi/in2000/team_21/ui/viewmodels/ActivitiesViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_currentUser", "Lkotlinx/coroutines/flow/StateFlow;", "Lno/uio/ifi/in2000/team_21/data/database/UserEntity;", "_userLogs", "Landroidx/lifecycle/MutableLiveData;", "", "Lno/uio/ifi/in2000/team_21/data/database/UserLogEntity;", "<set-?>", "Lno/uio/ifi/in2000/team_21/ui/viewmodels/ActivitiesUIState;", "activityUIstate", "getActivityUIstate", "()Lno/uio/ifi/in2000/team_21/ui/viewmodels/ActivitiesUIState;", "setActivityUIstate", "(Lno/uio/ifi/in2000/team_21/ui/viewmodels/ActivitiesUIState;)V", "activityUIstate$delegate", "Landroidx/compose/runtime/MutableState;", "dao", "Lno/uio/ifi/in2000/team_21/data/database/ActivitiesDao;", "database", "Lno/uio/ifi/in2000/team_21/data/database/AppDatabase;", "favorites", "Landroidx/lifecycle/LiveData;", "Lno/uio/ifi/in2000/team_21/data/database/ActivityEntity;", "getFavorites", "()Landroidx/lifecycle/LiveData;", "logDao", "Lno/uio/ifi/in2000/team_21/data/database/UserLogDao;", "userDao", "Lno/uio/ifi/in2000/team_21/data/database/UserDao;", "userLogs", "getUserLogs", "addFavorite", "", "activity", "Lno/uio/ifi/in2000/team_21/model/activity/ActivityModel;", "getActivityLogs", "username", "", "getActivityModelByName", "activityName", "isFavorite", "", "loadFavorites", "loadUserLogs", "log", "time", "logActivity", "removeFavorite", "app_debug"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
public final class ActivitiesViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.database.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.database.ActivitiesDao dao = null;
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.database.UserLogDao logDao = null;
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.database.UserDao userDao = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<no.uio.ifi.in2000.team_21.data.database.UserLogEntity>> _userLogs = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<no.uio.ifi.in2000.team_21.data.database.ActivityEntity>> favorites = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<no.uio.ifi.in2000.team_21.data.database.UserEntity> _currentUser = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<no.uio.ifi.in2000.team_21.data.database.UserLogEntity>> userLogs = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState activityUIstate$delegate = null;
    
    public ActivitiesViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<no.uio.ifi.in2000.team_21.data.database.ActivityEntity>> getFavorites() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<no.uio.ifi.in2000.team_21.data.database.UserLogEntity>> getUserLogs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final no.uio.ifi.in2000.team_21.ui.viewmodels.ActivitiesUIState getActivityUIstate() {
        return null;
    }
    
    private final void setActivityUIstate(no.uio.ifi.in2000.team_21.ui.viewmodels.ActivitiesUIState p0) {
    }
    
    public final void log(@org.jetbrains.annotations.NotNull
    java.lang.String time, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.activity.ActivityModel activity) {
    }
    
    public final void addFavorite(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.activity.ActivityModel activity) {
    }
    
    public final void removeFavorite(@org.jetbrains.annotations.NotNull
    java.lang.String activityName) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isFavorite(@org.jetbrains.annotations.NotNull
    java.lang.String activityName) {
        return null;
    }
    
    private final void loadFavorites() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final no.uio.ifi.in2000.team_21.model.activity.ActivityModel getActivityModelByName(@org.jetbrains.annotations.NotNull
    java.lang.String activityName) {
        return null;
    }
    
    public final void logActivity(@org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.activity.ActivityModel activity) {
    }
    
    public final void getActivityLogs(@org.jetbrains.annotations.NotNull
    java.lang.String username) {
    }
    
    public final void loadUserLogs() {
    }
}