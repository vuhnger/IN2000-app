package no.uio.ifi.in2000.team_21.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\'J\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lno/uio/ifi/in2000/team_21/data/database/UserDao;", "", "deactivateAllUsers", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUser", "userName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUser", "Landroidx/lifecycle/LiveData;", "Lno/uio/ifi/in2000/team_21/data/database/UserEntity;", "getUserByUsername", "insertUser", "user", "(Lno/uio/ifi/in2000/team_21/data/database/UserEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setActiveUser", "updateUser", "app_debug"})
@androidx.room.Dao
public abstract interface UserDao {
    
    @androidx.room.Insert(onConflict = 5)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.UserEntity user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE isActive = 1 LIMIT 1")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<no.uio.ifi.in2000.team_21.data.database.UserEntity> getCurrentUser();
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE userName = :userName")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserByUsername(@org.jetbrains.annotations.NotNull
    java.lang.String userName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super no.uio.ifi.in2000.team_21.data.database.UserEntity> $completion);
    
    @androidx.room.Query(value = "UPDATE users SET isActive = 0")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deactivateAllUsers(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE users SET isActive = 1 WHERE userName = :userName")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object setActiveUser(@org.jetbrains.annotations.NotNull
    java.lang.String userName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM users WHERE userName = :userName")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteUser(@org.jetbrains.annotations.NotNull
    java.lang.String userName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.UserEntity user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}