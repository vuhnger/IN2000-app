package no.uio.ifi.in2000.team_21.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lno/uio/ifi/in2000/team_21/data/database/UserLogDao;", "", "getUserLogs", "Landroidx/lifecycle/LiveData;", "", "Lno/uio/ifi/in2000/team_21/data/database/UserLogEntity;", "username", "", "logActivity", "", "userLogEntity", "(Lno/uio/ifi/in2000/team_21/data/database/UserLogEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface UserLogDao {
    
    @androidx.room.Insert(onConflict = 5)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object logActivity(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.UserLogEntity userLogEntity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM activity_logs WHERE username = :username ORDER BY id DESC")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<no.uio.ifi.in2000.team_21.data.database.UserLogEntity>> getUserLogs(@org.jetbrains.annotations.NotNull
    java.lang.String username);
}