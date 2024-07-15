package no.uio.ifi.in2000.team_21.model.activity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u000eH\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u000bH\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u000eH\u00c6\u0003Jm\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010/\u001a\u00020\u000eJ\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000301J\u0006\u00102\u001a\u00020\u0003J\t\u00103\u001a\u00020\u000eH\u00d6\u0001J\t\u00104\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001c\u00a8\u00065"}, d2 = {"Lno/uio/ifi/in2000/team_21/model/activity/ActivityModel;", "", "activityName", "", "minWaterTemperature", "", "maxWaterSpeed", "maxWaveHeight", "maxWindSpeed", "minAirTemperature", "conditionStatus", "Lno/uio/ifi/in2000/team_21/model/activity/ConditionStatus;", "conditionDescription", "imageId", "", "icon", "(Ljava/lang/String;DDDDDLno/uio/ifi/in2000/team_21/model/activity/ConditionStatus;Ljava/lang/String;II)V", "getActivityName", "()Ljava/lang/String;", "getConditionDescription", "setConditionDescription", "(Ljava/lang/String;)V", "getConditionStatus", "()Lno/uio/ifi/in2000/team_21/model/activity/ConditionStatus;", "getIcon", "()I", "getImageId", "getMaxWaterSpeed", "()D", "getMaxWaveHeight", "getMaxWindSpeed", "getMinAirTemperature", "getMinWaterTemperature", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getFlagColorId", "getFlagData", "Lkotlin/Pair;", "getFlagDescription", "hashCode", "toString", "app_debug"})
public final class ActivityModel {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String activityName = null;
    private final double minWaterTemperature = 0.0;
    private final double maxWaterSpeed = 0.0;
    private final double maxWaveHeight = 0.0;
    private final double maxWindSpeed = 0.0;
    private final double minAirTemperature = 0.0;
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.model.activity.ConditionStatus conditionStatus = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String conditionDescription;
    private final int imageId = 0;
    private final int icon = 0;
    
    public ActivityModel(@org.jetbrains.annotations.NotNull
    java.lang.String activityName, double minWaterTemperature, double maxWaterSpeed, double maxWaveHeight, double maxWindSpeed, double minAirTemperature, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.activity.ConditionStatus conditionStatus, @org.jetbrains.annotations.NotNull
    java.lang.String conditionDescription, int imageId, int icon) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getActivityName() {
        return null;
    }
    
    public final double getMinWaterTemperature() {
        return 0.0;
    }
    
    public final double getMaxWaterSpeed() {
        return 0.0;
    }
    
    public final double getMaxWaveHeight() {
        return 0.0;
    }
    
    public final double getMaxWindSpeed() {
        return 0.0;
    }
    
    public final double getMinAirTemperature() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final no.uio.ifi.in2000.team_21.model.activity.ConditionStatus getConditionStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getConditionDescription() {
        return null;
    }
    
    public final void setConditionDescription(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getImageId() {
        return 0;
    }
    
    public final int getIcon() {
        return 0;
    }
    
    public final int getFlagColorId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFlagDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.Pair<java.lang.Integer, java.lang.String> getFlagData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final no.uio.ifi.in2000.team_21.model.activity.ConditionStatus component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final no.uio.ifi.in2000.team_21.model.activity.ActivityModel copy(@org.jetbrains.annotations.NotNull
    java.lang.String activityName, double minWaterTemperature, double maxWaterSpeed, double maxWaveHeight, double maxWindSpeed, double minAirTemperature, @org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.activity.ConditionStatus conditionStatus, @org.jetbrains.annotations.NotNull
    java.lang.String conditionDescription, int imageId, int icon) {
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