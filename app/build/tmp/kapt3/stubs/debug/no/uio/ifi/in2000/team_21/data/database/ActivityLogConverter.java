package no.uio.ifi.in2000.team_21.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0006H\u0007J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lno/uio/ifi/in2000/team_21/data/database/ActivityLogConverter;", "", "()V", "gson", "Lcom/google/gson/Gson;", "activityLogListToString", "", "activityLogs", "", "Lno/uio/ifi/in2000/team_21/model/activity/ActivityLog;", "activityLogToString", "activityLog", "stringToActivityLog", "data", "stringToActivityLogList", "app_debug"})
public final class ActivityLogConverter {
    @org.jetbrains.annotations.NotNull
    private final com.google.gson.Gson gson = null;
    
    public ActivityLogConverter() {
        super();
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.lang.String activityLogToString(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.activity.ActivityLog activityLog) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final no.uio.ifi.in2000.team_21.model.activity.ActivityLog stringToActivityLog(@org.jetbrains.annotations.NotNull
    java.lang.String data) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.lang.String activityLogListToString(@org.jetbrains.annotations.NotNull
    java.util.List<no.uio.ifi.in2000.team_21.model.activity.ActivityLog> activityLogs) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.util.List<no.uio.ifi.in2000.team_21.model.activity.ActivityLog> stringToActivityLogList(@org.jetbrains.annotations.NotNull
    java.lang.String data) {
        return null;
    }
}