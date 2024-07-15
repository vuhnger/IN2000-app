package no.uio.ifi.in2000.team_21.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J+\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ5\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lno/uio/ifi/in2000/team_21/data/LocationForecastDataSource;", "", "()V", "client", "Lio/ktor/client/HttpClient;", "fetchLocationForecastByTime", "Lno/uio/ifi/in2000/team_21/model/locationforcast/LocationForecastTimeseries;", "time", "", "latitude", "", "longitude", "(Ljava/lang/String;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchLocationForecastResponse", "Lno/uio/ifi/in2000/team_21/model/locationforcast/LocationForecastResponse;", "(DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchLocationForecastTimeseries", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_debug"})
public final class LocationForecastDataSource {
    @org.jetbrains.annotations.NotNull
    private final io.ktor.client.HttpClient client = null;
    
    public LocationForecastDataSource() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object fetchLocationForecastResponse(double latitude, double longitude, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object fetchLocationForecastTimeseries(double latitude, double longitude, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.ArrayList<no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object fetchLocationForecastByTime(@org.jetbrains.annotations.NotNull
    java.lang.String time, double latitude, double longitude, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super no.uio.ifi.in2000.team_21.model.locationforcast.LocationForecastTimeseries> $completion) {
        return null;
    }
}