package no.uio.ifi.in2000.team_21.model;

@kotlinx.serialization.Serializable(with = no.uio.ifi.in2000.team_21.model.GeometrySerializer.class)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lno/uio/ifi/in2000/team_21/model/Geometry;", "", "()V", "type", "", "getType", "()Ljava/lang/String;", "Companion", "Lno/uio/ifi/in2000/team_21/model/MultiPolygon;", "Lno/uio/ifi/in2000/team_21/model/Polygon;", "app_debug"})
public abstract class Geometry {
    @org.jetbrains.annotations.NotNull
    public static final no.uio.ifi.in2000.team_21.model.Geometry.Companion Companion = null;
    
    private Geometry() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getType();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lno/uio/ifi/in2000/team_21/model/Geometry$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lno/uio/ifi/in2000/team_21/model/Geometry;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<no.uio.ifi.in2000.team_21.model.Geometry> serializer() {
            return null;
        }
    }
}