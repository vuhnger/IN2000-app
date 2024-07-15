package no.uio.ifi.in2000.team_21.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010$\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0082\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020,H\u00d6\u0001J\t\u0010-\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010\u00a8\u0006."}, d2 = {"Lno/uio/ifi/in2000/team_21/model/AlertsInfo;", "", "cap", "", "lang", "event", "incidentName", "geographicDomain", "county", "lat", "", "lon", "period", "sort", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)V", "getCap", "()Ljava/lang/String;", "getCounty", "getEvent", "getGeographicDomain", "getIncidentName", "getLang", "getLat", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLon", "getPeriod", "getSort", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)Lno/uio/ifi/in2000/team_21/model/AlertsInfo;", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class AlertsInfo {
    @org.jetbrains.annotations.Nullable
    private final java.lang.String cap = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String lang = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String event = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String incidentName = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String geographicDomain = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String county = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double lat = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double lon = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String period = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String sort = null;
    
    public AlertsInfo(@org.jetbrains.annotations.Nullable
    java.lang.String cap, @org.jetbrains.annotations.NotNull
    java.lang.String lang, @org.jetbrains.annotations.Nullable
    java.lang.String event, @org.jetbrains.annotations.Nullable
    java.lang.String incidentName, @org.jetbrains.annotations.Nullable
    java.lang.String geographicDomain, @org.jetbrains.annotations.Nullable
    java.lang.String county, @org.jetbrains.annotations.Nullable
    java.lang.Double lat, @org.jetbrains.annotations.Nullable
    java.lang.Double lon, @org.jetbrains.annotations.Nullable
    java.lang.String period, @org.jetbrains.annotations.NotNull
    java.lang.String sort) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLang() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getIncidentName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getGeographicDomain() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCounty() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getLat() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getLon() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPeriod() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSort() {
        return null;
    }
    
    public AlertsInfo() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
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
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final no.uio.ifi.in2000.team_21.model.AlertsInfo copy(@org.jetbrains.annotations.Nullable
    java.lang.String cap, @org.jetbrains.annotations.NotNull
    java.lang.String lang, @org.jetbrains.annotations.Nullable
    java.lang.String event, @org.jetbrains.annotations.Nullable
    java.lang.String incidentName, @org.jetbrains.annotations.Nullable
    java.lang.String geographicDomain, @org.jetbrains.annotations.Nullable
    java.lang.String county, @org.jetbrains.annotations.Nullable
    java.lang.Double lat, @org.jetbrains.annotations.Nullable
    java.lang.Double lon, @org.jetbrains.annotations.Nullable
    java.lang.String period, @org.jetbrains.annotations.NotNull
    java.lang.String sort) {
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