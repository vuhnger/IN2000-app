package no.uio.ifi.in2000.team_21.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0012J$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u001c\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J)\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b%J!\u0010&\u001a\u00020\'2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c0\u001bH\u0000\u00a2\u0006\u0002\b(R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lno/uio/ifi/in2000/team_21/ui/viewmodels/ActivityConditionCheckerViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_activities", "Landroidx/lifecycle/MutableLiveData;", "", "Lno/uio/ifi/in2000/team_21/model/activity/ActivityModel;", "activities", "Landroidx/lifecycle/LiveData;", "getActivities", "()Landroidx/lifecycle/LiveData;", "locationRepository", "Lno/uio/ifi/in2000/team_21/data/LocationForecastDataRepository;", "oceanRepository", "Lno/uio/ifi/in2000/team_21/data/OceanForecastRepository;", "checkActivityConditions", "", "time", "", "latitude", "", "longitude", "get", "activityName", "getConditionDescription", "activity", "conditionsMet", "", "", "getRelevantWeatherDetails", "Lno/uio/ifi/in2000/team_21/ui/viewmodels/ActivityConditionCheckerViewModel$WeatherDetails;", "oceanDetails", "Lno/uio/ifi/in2000/team_21/model/oceanforecast/Details;", "locationDetails", "Lno/uio/ifi/in2000/team_21/model/locationforcast/Details;", "getWeatherConditionsMet", "weatherDetails", "getWeatherConditionsMet$app_debug", "isWeatherOptimalForActivity", "Lno/uio/ifi/in2000/team_21/model/activity/ConditionStatus;", "isWeatherOptimalForActivity$app_debug", "WeatherDetails", "app_debug"})
public class ActivityConditionCheckerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.OceanForecastRepository oceanRepository = null;
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.LocationForecastDataRepository locationRepository = null;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.util.List<no.uio.ifi.in2000.team_21.model.activity.ActivityModel>> _activities;
    
    public ActivityConditionCheckerViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<no.uio.ifi.in2000.team_21.model.activity.ActivityModel>> getActivities() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final no.uio.ifi.in2000.team_21.model.activity.ActivityModel get(@org.jetbrains.annotations.NotNull
    java.lang.String activityName) {
        return null;
    }
    
    public final void checkActivityConditions(@org.jetbrains.annotations.NotNull
    java.lang.String time, double latitude, double longitude) {
    }
    
    private final no.uio.ifi.in2000.team_21.ui.viewmodels.ActivityConditionCheckerViewModel.WeatherDetails getRelevantWeatherDetails(no.uio.ifi.in2000.team_21.model.oceanforecast.Details oceanDetails, no.uio.ifi.in2000.team_21.model.locationforcast.Details locationDetails) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.Boolean> getWeatherConditionsMet$app_debug(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.ui.viewmodels.ActivityConditionCheckerViewModel.WeatherDetails weatherDetails, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.activity.ActivityModel activity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final no.uio.ifi.in2000.team_21.model.activity.ConditionStatus isWeatherOptimalForActivity$app_debug(@org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.Boolean> conditionsMet) {
        return null;
    }
    
    private final java.lang.String getConditionDescription(no.uio.ifi.in2000.team_21.model.activity.ActivityModel activity, java.util.Map<java.lang.String, java.lang.Boolean> conditionsMet) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJJ\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n\u00a8\u0006\u001e"}, d2 = {"Lno/uio/ifi/in2000/team_21/ui/viewmodels/ActivityConditionCheckerViewModel$WeatherDetails;", "", "seaWaterTemperature", "", "seaWaterSpeed", "seaSurfaceWaveHeight", "airTemperature", "windSpeed", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getAirTemperature", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSeaSurfaceWaveHeight", "getSeaWaterSpeed", "getSeaWaterTemperature", "getWindSpeed", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lno/uio/ifi/in2000/team_21/ui/viewmodels/ActivityConditionCheckerViewModel$WeatherDetails;", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class WeatherDetails {
        @org.jetbrains.annotations.Nullable
        private final java.lang.Double seaWaterTemperature = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.Double seaWaterSpeed = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.Double seaSurfaceWaveHeight = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.Double airTemperature = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.Double windSpeed = null;
        
        public WeatherDetails(@org.jetbrains.annotations.Nullable
        java.lang.Double seaWaterTemperature, @org.jetbrains.annotations.Nullable
        java.lang.Double seaWaterSpeed, @org.jetbrains.annotations.Nullable
        java.lang.Double seaSurfaceWaveHeight, @org.jetbrains.annotations.Nullable
        java.lang.Double airTemperature, @org.jetbrains.annotations.Nullable
        java.lang.Double windSpeed) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Double getSeaWaterTemperature() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Double getSeaWaterSpeed() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Double getSeaSurfaceWaveHeight() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Double getAirTemperature() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Double getWindSpeed() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Double component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Double component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Double component3() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Double component4() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Double component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final no.uio.ifi.in2000.team_21.ui.viewmodels.ActivityConditionCheckerViewModel.WeatherDetails copy(@org.jetbrains.annotations.Nullable
        java.lang.Double seaWaterTemperature, @org.jetbrains.annotations.Nullable
        java.lang.Double seaWaterSpeed, @org.jetbrains.annotations.Nullable
        java.lang.Double seaSurfaceWaveHeight, @org.jetbrains.annotations.Nullable
        java.lang.Double airTemperature, @org.jetbrains.annotations.Nullable
        java.lang.Double windSpeed) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}