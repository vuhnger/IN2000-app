package no.uio.ifi.in2000.team_21.data.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
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
public final class UserLogDao_Impl implements UserLogDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserLogEntity> __insertionAdapterOfUserLogEntity;

  public UserLogDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserLogEntity = new EntityInsertionAdapter<UserLogEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `activity_logs` (`id`,`username`,`activityName`,`timestamp`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserLogEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getUsername() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUsername());
        }
        if (entity.getActivityName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getActivityName());
        }
        if (entity.getTimestamp() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTimestamp());
        }
      }
    };
  }

  @Override
  public Object logActivity(final UserLogEntity userLogEntity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserLogEntity.insert(userLogEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<UserLogEntity>> getUserLogs(final String username) {
    final String _sql = "SELECT * FROM activity_logs WHERE username = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"activity_logs"}, false, new Callable<List<UserLogEntity>>() {
      @Override
      @Nullable
      public List<UserLogEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfActivityName = CursorUtil.getColumnIndexOrThrow(_cursor, "activityName");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<UserLogEntity> _result = new ArrayList<UserLogEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final UserLogEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpActivityName;
            if (_cursor.isNull(_cursorIndexOfActivityName)) {
              _tmpActivityName = null;
            } else {
              _tmpActivityName = _cursor.getString(_cursorIndexOfActivityName);
            }
            final String _tmpTimestamp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = _cursor.getString(_cursorIndexOfTimestamp);
            }
            _item = new UserLogEntity(_tmpId,_tmpUsername,_tmpActivityName,_tmpTimestamp);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
