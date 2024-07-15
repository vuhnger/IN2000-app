package no.uio.ifi.in2000.team_21.model.locationforcast;

@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278BI\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eB5\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u000fJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J9\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020\u0003H\u00d6\u0001J\t\u0010.\u001a\u00020/H\u00d6\u0001J!\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u00c7\u0001R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00069"}, d2 = {"Lno/uio/ifi/in2000/team_21/model/locationforcast/Data;", "", "seen1", "", "instant", "Lno/uio/ifi/in2000/team_21/model/locationforcast/Instant;", "next_12_hours", "Lno/uio/ifi/in2000/team_21/model/locationforcast/Next12Hours;", "next_1_hours", "Lno/uio/ifi/in2000/team_21/model/locationforcast/Next1Hours;", "next_6_hours", "Lno/uio/ifi/in2000/team_21/model/locationforcast/Next6Hours;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILno/uio/ifi/in2000/team_21/model/locationforcast/Instant;Lno/uio/ifi/in2000/team_21/model/locationforcast/Next12Hours;Lno/uio/ifi/in2000/team_21/model/locationforcast/Next1Hours;Lno/uio/ifi/in2000/team_21/model/locationforcast/Next6Hours;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lno/uio/ifi/in2000/team_21/model/locationforcast/Instant;Lno/uio/ifi/in2000/team_21/model/locationforcast/Next12Hours;Lno/uio/ifi/in2000/team_21/model/locationforcast/Next1Hours;Lno/uio/ifi/in2000/team_21/model/locationforcast/Next6Hours;)V", "getInstant$annotations", "()V", "getInstant", "()Lno/uio/ifi/in2000/team_21/model/locationforcast/Instant;", "setInstant", "(Lno/uio/ifi/in2000/team_21/model/locationforcast/Instant;)V", "getNext_12_hours$annotations", "getNext_12_hours", "()Lno/uio/ifi/in2000/team_21/model/locationforcast/Next12Hours;", "setNext_12_hours", "(Lno/uio/ifi/in2000/team_21/model/locationforcast/Next12Hours;)V", "getNext_1_hours$annotations", "getNext_1_hours", "()Lno/uio/ifi/in2000/team_21/model/locationforcast/Next1Hours;", "setNext_1_hours", "(Lno/uio/ifi/in2000/team_21/model/locationforcast/Next1Hours;)V", "getNext_6_hours$annotations", "getNext_6_hours", "()Lno/uio/ifi/in2000/team_21/model/locationforcast/Next6Hours;", "setNext_6_hours", "(Lno/uio/ifi/in2000/team_21/model/locationforcast/Next6Hours;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "app_debug"})
public final class Data {
    @org.jetbrains.annotations.Nullable
    private no.uio.ifi.in2000.team_21.model.locationforcast.Instant instant;
    @org.jetbrains.annotations.Nullable
    private no.uio.ifi.in2000.team_21.model.locationforcast.Next12Hours next_12_hours;
    @org.jetbrains.annotations.Nullable
    private no.uio.ifi.in2000.team_21.model.locationforcast.Next1Hours next_1_hours;
    @org.jetbrains.annotations.Nullable
    private no.uio.ifi.in2000.team_21.model.locationforcast.Next6Hours next_6_hours;
    @org.jetbrains.annotations.NotNull
    public static final no.uio.ifi.in2000.team_21.model.locationforcast.Data.Companion Companion = null;
    
    public Data(@org.jetbrains.annotations.Nullable
    no.uio.ifi.in2000.team_21.model.locationforcast.Instant instant, @org.jetbrains.annotations.Nullable
    no.uio.ifi.in2000.team_21.model.locationforcast.Next12Hours next_12_hours, @org.jetbrains.annotations.Nullable
    no.uio.ifi.in2000.team_21.model.locationforcast.Next1Hours next_1_hours, @org.jetbrains.annotations.Nullable
    no.uio.ifi.in2000.team_21.model.locationforcast.Next6Hours next_6_hours) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final no.uio.ifi.in2000.team_21.model.locationforcast.Instant getInstant() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "instant")
    @java.lang.Deprecated
    public static void getInstant$annotations() {
    }
    
    public final void setInstant(@org.jetbrains.annotations.Nullable
    no.uio.ifi.in2000.team_21.model.locationforcast.Instant p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final no.uio.ifi.in2000.team_21.model.locationforcast.Next12Hours getNext_12_hours() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "next_12_hours")
    @java.lang.Deprecated
    public static void getNext_12_hours$annotations() {
    }
    
    public final void setNext_12_hours(@org.jetbrains.annotations.Nullable
    no.uio.ifi.in2000.team_21.model.locationforcast.Next12Hours p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final no.uio.ifi.in2000.team_21.model.locationforcast.Next1Hours getNext_1_hours() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "next_1_hours")
    @java.lang.Deprecated
    public static void getNext_1_hours$annotations() {
    }
    
    public final void setNext_1_hours(@org.jetbrains.annotations.Nullable
    no.uio.ifi.in2000.team_21.model.locationforcast.Next1Hours p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final no.uio.ifi.in2000.team_21.model.locationforcast.Next6Hours getNext_6_hours() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "next_6_hours")
    @java.lang.Deprecated
    public static void getNext_6_hours$annotations() {
    }
    
    public final void setNext_6_hours(@org.jetbrains.annotations.Nullable
    no.uio.ifi.in2000.team_21.model.locationforcast.Next6Hours p0) {
    }
    
    public Data() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final no.uio.ifi.in2000.team_21.model.locationforcast.Instant component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final no.uio.ifi.in2000.team_21.model.locationforcast.Next12Hours component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final no.uio.ifi.in2000.team_21.model.locationforcast.Next1Hours component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final no.uio.ifi.in2000.team_21.model.locationforcast.Next6Hours component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final no.uio.ifi.in2000.team_21.model.locationforcast.Data copy(@org.jetbrains.annotations.Nullable
    no.uio.ifi.in2000.team_21.model.locationforcast.Instant instant, @org.jetbrains.annotations.Nullable
    no.uio.ifi.in2000.team_21.model.locationforcast.Next12Hours next_12_hours, @org.jetbrains.annotations.Nullable
    no.uio.ifi.in2000.team_21.model.locationforcast.Next1Hours next_1_hours, @org.jetbrains.annotations.Nullable
    no.uio.ifi.in2000.team_21.model.locationforcast.Next6Hours next_6_hours) {
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
    no.uio.ifi.in2000.team_21.model.locationforcast.Data self, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"no/uio/ifi/in2000/team_21/model/locationforcast/Data.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lno/uio/ifi/in2000/team_21/model/locationforcast/Data;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_debug"})
    @java.lang.Deprecated
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<no.uio.ifi.in2000.team_21.model.locationforcast.Data> {
        @org.jetbrains.annotations.NotNull
        public static final no.uio.ifi.in2000.team_21.model.locationforcast.Data.$serializer INSTANCE = null;
        
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
        public no.uio.ifi.in2000.team_21.model.locationforcast.Data deserialize(@org.jetbrains.annotations.NotNull
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
        no.uio.ifi.in2000.team_21.model.locationforcast.Data value) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lno/uio/ifi/in2000/team_21/model/locationforcast/Data$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lno/uio/ifi/in2000/team_21/model/locationforcast/Data;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<no.uio.ifi.in2000.team_21.model.locationforcast.Data> serializer() {
            return null;
        }
    }
}