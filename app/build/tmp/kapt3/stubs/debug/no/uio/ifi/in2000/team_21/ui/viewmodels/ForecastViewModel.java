package no.uio.ifi.in2000.team_21.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-J\u000e\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020-J\u0016\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020-J\u000e\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\tJ\u000e\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\u000fJ\u0016\u00108\u001a\u00020+2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u0018*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010 R\u001f\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\"\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R \u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b\'\u0010 R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0015\u00a8\u00069"}, d2 = {"Lno/uio/ifi/in2000/team_21/ui/viewmodels/ForecastViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "TIMEOUT_MS", "", "_forecast", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lno/uio/ifi/in2000/team_21/model/locationforcast/LocationForecastResponse;", "_selectedDate", "Ljava/time/LocalDate;", "_selectedLocationWeatherData", "Landroidx/compose/runtime/MutableState;", "", "Lno/uio/ifi/in2000/team_21/model/locationforcast/LocationForecastTimeseries;", "_selectedTime", "Ljava/time/LocalTime;", "_selected_time", "", "forecast", "Lkotlinx/coroutines/flow/StateFlow;", "getForecast", "()Lkotlinx/coroutines/flow/StateFlow;", "formatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "norwayZone", "Ljava/time/ZoneId;", "repository", "Lno/uio/ifi/in2000/team_21/data/LocationForecastDataRepository;", "selectedDate", "getSelectedDate", "setSelectedDate", "(Lkotlinx/coroutines/flow/StateFlow;)V", "selectedLocationWeatherData", "Landroidx/compose/runtime/State;", "getSelectedLocationWeatherData", "()Landroidx/compose/runtime/State;", "selectedTime", "getSelectedTime", "setSelectedTime", "selected_time", "getSelected_time", "continuousForecastUpdate", "", "latitude", "", "longitude", "describeCloudCover", "cloudAreaFraction", "fetchWeatherForLocation", "lat", "lon", "updateSelectedDate", "date", "updateSelectedTime", "time", "update_selected_time", "app_debug"})
@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
public final class ForecastViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.LocationForecastDataRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.util.List<no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries>> _selectedLocationWeatherData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<java.util.List<no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries>> selectedLocationWeatherData = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse> _forecast;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse> forecast = null;
    private final long TIMEOUT_MS = 300000L;
    private final java.time.ZoneId norwayZone = null;
    private final java.time.format.DateTimeFormatter formatter = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selected_time = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selected_time = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<java.time.LocalDate> _selectedDate;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<java.time.LocalTime> _selectedTime;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<java.time.LocalDate> selectedDate;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<java.time.LocalTime> selectedTime;
    
    public ForecastViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<java.util.List<no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries>> getSelectedLocationWeatherData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse> getForecast() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelected_time() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.time.LocalDate> getSelectedDate() {
        return null;
    }
    
    public final void setSelectedDate(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<java.time.LocalDate> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.time.LocalTime> getSelectedTime() {
        return null;
    }
    
    public final void setSelectedTime(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<java.time.LocalTime> p0) {
    }
    
    public final void update_selected_time(@org.jetbrains.annotations.NotNull
    java.time.LocalDate selectedDate, @org.jetbrains.annotations.NotNull
    java.time.LocalTime selectedTime) {
    }
    
    public final void updateSelectedTime(@org.jetbrains.annotations.NotNull
    java.time.LocalTime time) {
    }
    
    public final void updateSelectedDate(@org.jetbrains.annotations.NotNull
    java.time.LocalDate date) {
    }
    
    public final void continuousForecastUpdate(double latitude, double longitude) {
    }
    
    public final void fetchWeatherForLocation(double lat, double lon) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String describeCloudCover(double cloudAreaFraction) {
        return null;
    }
}