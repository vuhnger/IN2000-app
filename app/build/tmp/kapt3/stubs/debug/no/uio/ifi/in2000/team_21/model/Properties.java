package no.uio.ifi.in2000.team_21.model;

@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 c2\u00020\u0001:\u0002bcB\u0095\u0002\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u00a2\u0006\u0002\u0010!B\u00b1\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\"J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fH\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000fH\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u00b5\u0002\u0010U\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010Y\u001a\u00020\u0003H\u00d6\u0001J\t\u0010Z\u001a\u00020\u0005H\u00d6\u0001J!\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u00c7\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010$R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010.R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010$R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010$\u00a8\u0006d"}, d2 = {"Lno/uio/ifi/in2000/team_21/model/Properties;", "", "seen1", "", "MunicipalityId", "", "administrativeId", "area", "awarenessResponse", "awarenessSeriousness", "awareness_level", "awareness_type", "certainty", "consequences", "county", "", "description", "event", "eventAwarenessName", "eventEndingTime", "geographicDomain", "id", "incidentName", "instruction", "resources", "Lno/uio/ifi/in2000/team_21/model/Resource;", "riskMatrixColor", "severity", "title", "triggerLevel", "type", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMunicipalityId", "()Ljava/lang/String;", "getAdministrativeId", "getArea", "getAwarenessResponse", "getAwarenessSeriousness", "getAwareness_level", "getAwareness_type", "getCertainty", "getConsequences", "getCounty", "()Ljava/util/List;", "getDescription", "getEvent", "getEventAwarenessName", "getEventEndingTime", "getGeographicDomain", "getId", "getIncidentName", "getInstruction", "getResources", "getRiskMatrixColor", "getSeverity", "getTitle", "getTriggerLevel", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "app_debug"})
public final class Properties {
    @org.jetbrains.annotations.Nullable
    private final java.lang.String MunicipalityId = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String administrativeId = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String area = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String awarenessResponse = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String awarenessSeriousness = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String awareness_level = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String awareness_type = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String certainty = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String consequences = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<java.lang.String> county = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String description = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String event = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String eventAwarenessName = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String eventEndingTime = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String geographicDomain = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String id = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String incidentName = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String instruction = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<no.uio.ifi.in2000.team_21.model.Resource> resources = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String riskMatrixColor = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String severity = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String title = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String triggerLevel = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String type = null;
    @org.jetbrains.annotations.NotNull
    public static final no.uio.ifi.in2000.team_21.model.Properties.Companion Companion = null;
    
    public Properties(@org.jetbrains.annotations.Nullable
    java.lang.String MunicipalityId, @org.jetbrains.annotations.Nullable
    java.lang.String administrativeId, @org.jetbrains.annotations.Nullable
    java.lang.String area, @org.jetbrains.annotations.Nullable
    java.lang.String awarenessResponse, @org.jetbrains.annotations.Nullable
    java.lang.String awarenessSeriousness, @org.jetbrains.annotations.Nullable
    java.lang.String awareness_level, @org.jetbrains.annotations.Nullable
    java.lang.String awareness_type, @org.jetbrains.annotations.Nullable
    java.lang.String certainty, @org.jetbrains.annotations.Nullable
    java.lang.String consequences, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> county, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.Nullable
    java.lang.String event, @org.jetbrains.annotations.Nullable
    java.lang.String eventAwarenessName, @org.jetbrains.annotations.Nullable
    java.lang.String eventEndingTime, @org.jetbrains.annotations.Nullable
    java.lang.String geographicDomain, @org.jetbrains.annotations.Nullable
    java.lang.String id, @org.jetbrains.annotations.Nullable
    java.lang.String incidentName, @org.jetbrains.annotations.Nullable
    java.lang.String instruction, @org.jetbrains.annotations.Nullable
    java.util.List<no.uio.ifi.in2000.team_21.model.Resource> resources, @org.jetbrains.annotations.Nullable
    java.lang.String riskMatrixColor, @org.jetbrains.annotations.Nullable
    java.lang.String severity, @org.jetbrains.annotations.Nullable
    java.lang.String title, @org.jetbrains.annotations.Nullable
    java.lang.String triggerLevel, @org.jetbrains.annotations.Nullable
    java.lang.String type) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMunicipalityId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAdministrativeId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getArea() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAwarenessResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAwarenessSeriousness() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAwareness_level() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAwareness_type() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCertainty() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getConsequences() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getCounty() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getEventAwarenessName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getEventEndingTime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getGeographicDomain() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getIncidentName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getInstruction() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<no.uio.ifi.in2000.team_21.model.Resource> getResources() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getRiskMatrixColor() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSeverity() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTriggerLevel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getType() {
        return null;
    }
    
    public Properties() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<no.uio.ifi.in2000.team_21.model.Resource> component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component24() {
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
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final no.uio.ifi.in2000.team_21.model.Properties copy(@org.jetbrains.annotations.Nullable
    java.lang.String MunicipalityId, @org.jetbrains.annotations.Nullable
    java.lang.String administrativeId, @org.jetbrains.annotations.Nullable
    java.lang.String area, @org.jetbrains.annotations.Nullable
    java.lang.String awarenessResponse, @org.jetbrains.annotations.Nullable
    java.lang.String awarenessSeriousness, @org.jetbrains.annotations.Nullable
    java.lang.String awareness_level, @org.jetbrains.annotations.Nullable
    java.lang.String awareness_type, @org.jetbrains.annotations.Nullable
    java.lang.String certainty, @org.jetbrains.annotations.Nullable
    java.lang.String consequences, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> county, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.Nullable
    java.lang.String event, @org.jetbrains.annotations.Nullable
    java.lang.String eventAwarenessName, @org.jetbrains.annotations.Nullable
    java.lang.String eventEndingTime, @org.jetbrains.annotations.Nullable
    java.lang.String geographicDomain, @org.jetbrains.annotations.Nullable
    java.lang.String id, @org.jetbrains.annotations.Nullable
    java.lang.String incidentName, @org.jetbrains.annotations.Nullable
    java.lang.String instruction, @org.jetbrains.annotations.Nullable
    java.util.List<no.uio.ifi.in2000.team_21.model.Resource> resources, @org.jetbrains.annotations.Nullable
    java.lang.String riskMatrixColor, @org.jetbrains.annotations.Nullable
    java.lang.String severity, @org.jetbrains.annotations.Nullable
    java.lang.String title, @org.jetbrains.annotations.Nullable
    java.lang.String triggerLevel, @org.jetbrains.annotations.Nullable
    java.lang.String type) {
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
    
    @kotlin.jvm.JvmStatic
    public static final void write$Self(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.model.Properties self, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"no/uio/ifi/in2000/team_21/model/Properties.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lno/uio/ifi/in2000/team_21/model/Properties;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_debug"})
    @java.lang.Deprecated
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<no.uio.ifi.in2000.team_21.model.Properties> {
        @org.jetbrains.annotations.NotNull
        public static final no.uio.ifi.in2000.team_21.model.Properties.$serializer INSTANCE = null;
        
        private $serializer() {
            super();
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] childSerializers() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public no.uio.ifi.in2000.team_21.model.Properties deserialize(@org.jetbrains.annotations.NotNull
        kotlinx.serialization.encoding.Decoder decoder) {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
            return null;
        }
        
        @java.lang.Override
        public void serialize(@org.jetbrains.annotations.NotNull
        kotlinx.serialization.encoding.Encoder encoder, @org.jetbrains.annotations.NotNull
        no.uio.ifi.in2000.team_21.model.Properties value) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lno/uio/ifi/in2000/team_21/model/Properties$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lno/uio/ifi/in2000/team_21/model/Properties;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<no.uio.ifi.in2000.team_21.model.Properties> serializer() {
            return null;
        }
    }
}