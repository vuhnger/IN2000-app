package no.uio.ifi.in2000.team_21.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J#\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J+\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J)\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR-\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lno/uio/ifi/in2000/team_21/data/LocationForecastDataRepository;", "", "dataSource", "Lno/uio/ifi/in2000/team_21/data/LocationForecastDataSource;", "(Lno/uio/ifi/in2000/team_21/data/LocationForecastDataSource;)V", "cachedResponseData", "Ljava/util/HashMap;", "", "Lno/uio/ifi/in2000/team_21/model/locationforcast/LocationForecastResponse;", "Lkotlin/collections/HashMap;", "getCachedResponseData", "()Ljava/util/HashMap;", "cachedTimeseriesData", "Lno/uio/ifi/in2000/team_21/model/locationforcast/LocationForecastTimeseries;", "getCachedTimeseriesData", "fetchForecast", "latitude", "", "longitude", "(DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchLocationForecastTimeseriesByTime", "time", "(Ljava/lang/String;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchWeatherDataForLocation", "", "lat", "lon", "app_debug"})
public final class LocationForecastDataRepository {
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.LocationForecastDataSource dataSource = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.HashMap<java.lang.String, no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse> cachedResponseData = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.HashMap<java.lang.String, no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries> cachedTimeseriesData = null;
    
    public LocationForecastDataRepository(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.LocationForecastDataSource dataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse> getCachedResponseData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries> getCachedTimeseriesData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object fetchForecast(double latitude, double longitude, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object fetchWeatherDataForLocation(double lat, double lon, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object fetchLocationForecastTimeseriesByTime(@org.jetbrains.annotations.NotNull
    java.lang.String time, double latitude, double longitude, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries> $completion) {
        return null;
    }
    
    public LocationForecastDataRepository() {
        super();
    }
}