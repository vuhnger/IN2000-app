package no.uio.ifi.in2000.team_21.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile LocationDao _locationDao;

  private volatile ActivitiesDao _activitiesDao;

  private volatile UserLogDao _userLogDao;

  private volatile UserDao _userDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(11) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `locations` (`annotationId` TEXT NOT NULL, `name` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `iconId` TEXT NOT NULL, PRIMARY KEY(`annotationId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `activities` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `activity_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `username` TEXT NOT NULL, `activityName` TEXT NOT NULL, `timestamp` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`name` TEXT NOT NULL, `hobby` TEXT NOT NULL, `history` TEXT NOT NULL, `password` TEXT NOT NULL, `userName` TEXT NOT NULL, `isActive` INTEGER NOT NULL, PRIMARY KEY(`userName`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3a0cfbd899f3c373f62f911b9e418afb')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `locations`");
        db.execSQL("DROP TABLE IF EXISTS `activities`");
        db.execSQL("DROP TABLE IF EXISTS `activity_logs`");
        db.execSQL("DROP TABLE IF EXISTS `users`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsLocations = new HashMap<String, TableInfo.Column>(5);
        _columnsLocations.put("annotationId", new TableInfo.Column("annotationId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("iconId", new TableInfo.Column("iconId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocations = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLocations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLocations = new TableInfo("locations", _columnsLocations, _foreignKeysLocations, _indicesLocations);
        final TableInfo _existingLocations = TableInfo.read(db, "locations");
        if (!_infoLocations.equals(_existingLocations)) {
          return new RoomOpenHelper.ValidationResult(false, "locations(no.uio.ifi.in2000.team_21.data.database.UserMarkerEntity).\n"
                  + " Expected:\n" + _infoLocations + "\n"
                  + " Found:\n" + _existingLocations);
        }
        final HashMap<String, TableInfo.Column> _columnsActivities = new HashMap<String, TableInfo.Column>(2);
        _columnsActivities.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivities.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysActivities = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesActivities = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoActivities = new TableInfo("activities", _columnsActivities, _foreignKeysActivities, _indicesActivities);
        final TableInfo _existingActivities = TableInfo.read(db, "activities");
        if (!_infoActivities.equals(_existingActivities)) {
          return new RoomOpenHelper.ValidationResult(false, "activities(no.uio.ifi.in2000.team_21.data.database.ActivityEntity).\n"
                  + " Expected:\n" + _infoActivities + "\n"
                  + " Found:\n" + _existingActivities);
        }
        final HashMap<String, TableInfo.Column> _columnsActivityLogs = new HashMap<String, TableInfo.Column>(4);
        _columnsActivityLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLogs.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLogs.put("activityName", new TableInfo.Column("activityName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLogs.put("timestamp", new TableInfo.Column("timestamp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysActivityLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesActivityLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoActivityLogs = new TableInfo("activity_logs", _columnsActivityLogs, _foreignKeysActivityLogs, _indicesActivityLogs);
        final TableInfo _existingActivityLogs = TableInfo.read(db, "activity_logs");
        if (!_infoActivityLogs.equals(_existingActivityLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "activity_logs(no.uio.ifi.in2000.team_21.data.database.UserLogEntity).\n"
                  + " Expected:\n" + _infoActivityLogs + "\n"
                  + " Found:\n" + _existingActivityLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(6);
        _columnsUsers.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("hobby", new TableInfo.Column("hobby", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("history", new TableInfo.Column("history", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("userName", new TableInfo.Column("userName", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(no.uio.ifi.in2000.team_21.data.database.UserEntity).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "3a0cfbd899f3c373f62f911b9e418afb", "58391297a2f86a04806fa721f9815402");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "locations","activities","activity_logs","users");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `locations`");
      _db.execSQL("DELETE FROM `activities`");
      _db.execSQL("DELETE FROM `activity_logs`");
      _db.execSQL("DELETE FROM `users`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(LocationDao.class, LocationDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ActivitiesDao.class, ActivitiesDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserLogDao.class, UserLogDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public LocationDao locationDao() {
    if (_locationDao != null) {
      return _locationDao;
    } else {
      synchronized(this) {
        if(_locationDao == null) {
          _locationDao = new LocationDao_Impl(this);
        }
        return _locationDao;
      }
    }
  }

  @Override
  public ActivitiesDao activitiesDao() {
    if (_activitiesDao != null) {
      return _activitiesDao;
    } else {
      synchronized(this) {
        if(_activitiesDao == null) {
          _activitiesDao = new ActivitiesDao_Impl(this);
        }
        return _activitiesDao;
      }
    }
  }

  @Override
  public UserLogDao userLogDao() {
    if (_userLogDao != null) {
      return _userLogDao;
    } else {
      synchronized(this) {
        if(_userLogDao == null) {
          _userLogDao = new UserLogDao_Impl(this);
        }
        return _userLogDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }
}
