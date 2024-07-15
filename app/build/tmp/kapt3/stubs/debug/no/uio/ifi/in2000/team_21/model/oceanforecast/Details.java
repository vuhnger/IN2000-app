package no.uio.ifi.in2000.team_21.model.oceanforecast;

@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0BK\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fBA\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJJ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001J\t\u0010&\u001a\u00020\'H\u00d6\u0001J!\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u00c7\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\"\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\"\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011\u00a8\u00061"}, d2 = {"Lno/uio/ifi/in2000/team_21/model/oceanforecast/Details;", "", "seen1", "", "sea_surface_wave_from_direction", "", "sea_surface_wave_height", "sea_water_speed", "sea_water_temperature", "sea_water_to_direction", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getSea_surface_wave_from_direction", "()Ljava/lang/Double;", "setSea_surface_wave_from_direction", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getSea_surface_wave_height", "setSea_surface_wave_height", "getSea_water_speed", "setSea_water_speed", "getSea_water_temperature", "setSea_water_temperature", "getSea_water_to_direction", "setSea_water_to_direction", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lno/uio/ifi/in2000/team_21/model/oceanforecast/Details;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "app_debug"})
public final class Details {
    @com.google.gson.annotations.SerializedName(value = "sea_surface_wave_from_direction")
    @org.jetbrains.annotations.Nullable
    private java.lang.Double sea_surface_wave_from_direction;
    @com.google.gson.annotations.SerializedName(value = "sea_surface_wave_height")
    @org.jetbrains.annotations.Nullable
    private java.lang.Double sea_surface_wave_height;
    @com.google.gson.annotations.SerializedName(value = "sea_water_speed")
    @org.jetbrains.annotations.Nullable
    private java.lang.Double sea_water_speed;
    @com.google.gson.annotations.SerializedName(value = "sea_water_temperature")
    @org.jetbrains.annotations.Nullable
    private java.lang.Double sea_water_temperature;
    @com.google.gson.annotations.SerializedName(value = "sea_water_to_direction")
    @org.jetbrains.annotations.Nullable
    private java.lang.Double sea_water_to_direction;
    @org.jetbrains.annotations.NotNull
    public static final no.uio.ifi.in2000.team_21.model.oceanforecast.Details.Companion Companion = null;
    
    public Details(@org.jetbrains.annotations.Nullable
    java.lang.Double sea_surface_wave_from_direction, @org.jetbrains.annotations.Nullable
    java.lang.Double sea_surface_wave_height, @org.jetbrains.annotations.Nullable
    java.lang.Double sea_water_speed, @org.jetbrains.annotations.Nullable
    java.lang.Double sea_water_temperature, @org.jetbrains.annotations.Nullable
    java.lang.Double sea_water_to_direction) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getSea_surface_wave_from_direction() {
        return null;
    }
    
    public final void setSea_surface_wave_from_direction(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getSea_surface_wave_height() {
        return null;
    }
    
    public final void setSea_surface_wave_height(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getSea_water_speed() {
        return null;
    }
    
    public final void setSea_water_speed(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getSea_water_temperature() {
        return null;
    }
    
    public final void setSea_water_temperature(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getSea_water_to_direction() {
        return null;
    }
    
    public final void setSea_water_to_direction(@org.jetbrains.annotations.Nullable
    java.lang.Double p0) {
    }
    
    public Details() {
        super();
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
    public final no.uio.ifi.in2000.team_21.model.oceanforecast.Details copy(@org.jetbrains.annotations.Nullable
    java.lang.Double sea_surface_wave_from_direction, @org.jetbrains.annotations.Nullable
    java.lang.Double sea_surface_wave_height, @org.jetbrains.annotations.Nullable
    java.lang.Double sea_water_speed, @org.jetbrains.annotations.Nullable
    java.lang.Double sea_water_temperature, @org.jetbrains.annotations.Nullable
    java.lang.Double sea_water_to_direction) {
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
    no.uio.ifi.in2000.team_21.model.oceanforecast.Details self, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"no/uio/ifi/in2000/team_21/model/oceanforecast/Details.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lno/uio/ifi/in2000/team_21/model/oceanforecast/Details;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_debug"})
    @java.lang.Deprecated
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<no.uio.ifi.in2000.team_21.model.oceanforecast.Details> {
        @org.jetbrains.annotations.NotNull
        public static final no.uio.ifi.in2000.team_21.model.oceanforecast.Details.$serializer INSTANCE = null;
        
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
        public no.uio.ifi.in2000.team_21.model.oceanforecast.Details deserialize(@org.jetbrains.annotations.NotNull
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
        no.uio.ifi.in2000.team_21.model.oceanforecast.Details value) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lno/uio/ifi/in2000/team_21/model/oceanforecast/Details$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lno/uio/ifi/in2000/team_21/model/oceanforecast/Details;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<no.uio.ifi.in2000.team_21.model.oceanforecast.Details> serializer() {
            return null;
        }
    }
}