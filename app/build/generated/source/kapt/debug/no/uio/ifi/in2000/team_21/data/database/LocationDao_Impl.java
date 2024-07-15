package no.uio.ifi.in2000.team_21.data.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LocationDao_Impl implements LocationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserMarkerEntity> __insertionAdapterOfUserMarkerEntity;

  private final EntityDeletionOrUpdateAdapter<UserMarkerEntity> __deletionAdapterOfUserMarkerEntity;

  private final EntityDeletionOrUpdateAdapter<UserMarkerEntity> __updateAdapterOfUserMarkerEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByLatLong;

  public LocationDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserMarkerEntity = new EntityInsertionAdapter<UserMarkerEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `locations` (`annotationId`,`name`,`latitude`,`longitude`,`iconId`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserMarkerEntity entity) {
        if (entity.getAnnotationId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getAnnotationId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindDouble(3, entity.getLatitude());
        statement.bindDouble(4, entity.getLongitude());
        if (entity.getIconId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getIconId());
        }
      }
    };
    this.__deletionAdapterOfUserMarkerEntity = new EntityDeletionOrUpdateAdapter<UserMarkerEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `locations` WHERE `annotationId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserMarkerEntity entity) {
        if (entity.getAnnotationId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getAnnotationId());
        }
      }
    };
    this.__updateAdapterOfUserMarkerEntity = new EntityDeletionOrUpdateAdapter<UserMarkerEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `locations` SET `annotationId` = ?,`name` = ?,`latitude` = ?,`longitude` = ?,`iconId` = ? WHERE `annotationId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserMarkerEntity entity) {
        if (entity.getAnnotationId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getAnnotationId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindDouble(3, entity.getLatitude());
        statement.bindDouble(4, entity.getLongitude());
        if (entity.getIconId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getIconId());
        }
        if (entity.getAnnotationId() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getAnnotationId());
        }
      }
    };
    this.__preparedStmtOfDeleteByLatLong = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM locations WHERE latitude = ? AND longitude = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final UserMarkerEntity[] locations,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserMarkerEntity.insert(locations);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final UserMarkerEntity location,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUserMarkerEntity.handle(location);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final UserMarkerEntity location,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUserMarkerEntity.handle(location);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteByLatLong(final double lat, final double lng,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByLatLong.acquire();
        int _argIndex = 1;
        _stmt.bindDouble(_argIndex, lat);
        _argIndex = 2;
        _stmt.bindDouble(_argIndex, lng);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteByLatLong.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getAll(final Continuation<? super List<UserMarkerEntity>> $completion) {
    final String _sql = "SELECT * FROM locations";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<UserMarkerEntity>>() {
      @Override
      @NonNull
      public List<UserMarkerEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAnnotationId = CursorUtil.getColumnIndexOrThrow(_cursor, "annotationId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfIconId = CursorUtil.getColumnIndexOrThrow(_cursor, "iconId");
          final List<UserMarkerEntity> _result = new ArrayList<UserMarkerEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final UserMarkerEntity _item;
            final String _tmpAnnotationId;
            if (_cursor.isNull(_cursorIndexOfAnnotationId)) {
              _tmpAnnotationId = null;
            } else {
              _tmpAnnotationId = _cursor.getString(_cursorIndexOfAnnotationId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpIconId;
            if (_cursor.isNull(_cursorIndexOfIconId)) {
              _tmpIconId = null;
            } else {
              _tmpIconId = _cursor.getString(_cursorIndexOfIconId);
            }
            _item = new UserMarkerEntity(_tmpAnnotationId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpIconId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
