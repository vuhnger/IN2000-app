package no.uio.ifi.in2000.team_21.model.locationforcast;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJz\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020)H\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0017\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\u000f\u00a8\u0006+"}, d2 = {"Lno/uio/ifi/in2000/team_21/model/locationforcast/WeatherData;", "", "time", "", "airTemperature", "", "windFromDirection", "windSpeed", "humidity", "chanceOfRain", "airPressureAtSeaLevel", "cloudAreaFraction", "uvIndex", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getAirPressureAtSeaLevel", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAirTemperature", "getChanceOfRain", "getCloudAreaFraction", "getHumidity", "getTime", "()Ljava/lang/String;", "getUvIndex", "getWindFromDirection", "getWindSpeed", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lno/uio/ifi/in2000/team_21/model/locationforcast/WeatherData;", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class WeatherData {
    @org.jetbrains.annotations.Nullable
    private final java.lang.String time = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double airTemperature = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double windFromDirection = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double windSpeed = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double humidity = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double chanceOfRain = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double airPressureAtSeaLevel = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double cloudAreaFraction = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double uvIndex = null;
    
    public WeatherData(@org.jetbrains.annotations.Nullable
    java.lang.String time, @org.jetbrains.annotations.Nullable
    java.lang.Double airTemperature, @org.jetbrains.annotations.Nullable
    java.lang.Double windFromDirection, @org.jetbrains.annotations.Nullable
    java.lang.Double windSpeed, @org.jetbrains.annotations.Nullable
    java.lang.Double humidity, @org.jetbrains.annotations.Nullable
    java.lang.Double chanceOfRain, @org.jetbrains.annotations.Nullable
    java.lang.Double airPressureAtSeaLevel, @org.jetbrains.annotations.Nullable
    java.lang.Double cloudAreaFraction, @org.jetbrains.annotations.Nullable
    java.lang.Double uvIndex) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getAirTemperature() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getWindFromDirection() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getWindSpeed() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getHumidity() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getChanceOfRain() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getAirPressureAtSeaLevel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getCloudAreaFraction() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getUvIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
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
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final no.uio.ifi.in2000.team_21.model.locationforcast.WeatherData copy(@org.jetbrains.annotations.Nullable
    java.lang.String time, @org.jetbrains.annotations.Nullable
    java.lang.Double airTemperature, @org.jetbrains.annotations.Nullable
    java.lang.Double windFromDirection, @org.jetbrains.annotations.Nullable
    java.lang.Double windSpeed, @org.jetbrains.annotations.Nullable
    java.lang.Double humidity, @org.jetbrains.annotations.Nullable
    java.lang.Double chanceOfRain, @org.jetbrains.annotations.Nullable
    java.lang.Double airPressureAtSeaLevel, @org.jetbrains.annotations.Nullable
    java.lang.Double cloudAreaFraction, @org.jetbrains.annotations.Nullable
    java.lang.Double uvIndex) {
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