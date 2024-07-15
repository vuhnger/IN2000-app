package no.uio.ifi.in2000.team_21.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0011\"\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lno/uio/ifi/in2000/team_21/data/database/LocationDao;", "", "delete", "", "location", "Lno/uio/ifi/in2000/team_21/data/database/UserMarkerEntity;", "(Lno/uio/ifi/in2000/team_21/data/database/UserMarkerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByLatLong", "lat", "", "lng", "(DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "locations", "", "([Lno/uio/ifi/in2000/team_21/data/database/UserMarkerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "app_debug"})
@androidx.room.Dao
public abstract interface LocationDao {
    
    @androidx.room.Query(value = "SELECT * FROM locations")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity>> $completion);
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity[] locations, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity location, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity location, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM locations WHERE latitude = :lat AND longitude = :lng")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteByLatLong(double lat, double lng, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}