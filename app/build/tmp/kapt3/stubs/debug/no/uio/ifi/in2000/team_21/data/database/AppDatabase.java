package no.uio.ifi.in2000.team_21.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lno/uio/ifi/in2000/team_21/data/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "activitiesDao", "Lno/uio/ifi/in2000/team_21/data/database/ActivitiesDao;", "locationDao", "Lno/uio/ifi/in2000/team_21/data/database/LocationDao;", "userDao", "Lno/uio/ifi/in2000/team_21/data/database/UserDao;", "userLogDao", "Lno/uio/ifi/in2000/team_21/data/database/UserLogDao;", "app_debug"})
@androidx.room.Database(entities = {no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity.class, no.uio.ifi.in2000.team_21.data.database.ActivityEntity.class, no.uio.ifi.in2000.team_21.data.database.UserLogEntity.class, no.uio.ifi.in2000.team_21.data.database.UserEntity.class}, version = 11)
@androidx.room.TypeConverters(value = {no.uio.ifi.in2000.team_21.data.database.ActivityLogConverter.class})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract no.uio.ifi.in2000.team_21.data.database.LocationDao locationDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract no.uio.ifi.in2000.team_21.data.database.ActivitiesDao activitiesDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract no.uio.ifi.in2000.team_21.data.database.UserLogDao userLogDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract no.uio.ifi.in2000.team_21.data.database.UserDao userDao();
}