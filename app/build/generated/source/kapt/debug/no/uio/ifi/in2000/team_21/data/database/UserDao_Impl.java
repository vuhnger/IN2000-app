package no.uio.ifi.in2000.team_21.data.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
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
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import no.uio.ifi.in2000.team_21.model.activity.ActivityLog;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserEntity> __insertionAdapterOfUserEntity;

  private final ActivityLogConverter __activityLogConverter = new ActivityLogConverter();

  private final EntityDeletionOrUpdateAdapter<UserEntity> __updateAdapterOfUserEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeactivateAllUsers;

  private final SharedSQLiteStatement __preparedStmtOfSetActiveUser;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUser;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserEntity = new EntityInsertionAdapter<UserEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `users` (`name`,`hobby`,`history`,`password`,`userName`,`isActive`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserEntity entity) {
        if (entity.getName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getName());
        }
        if (entity.getHobby() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getHobby());
        }
        final String _tmp = __activityLogConverter.activityLogListToString(entity.getHistory());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        if (entity.getPassword() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPassword());
        }
        if (entity.getUserName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getUserName());
        }
        final int _tmp_1 = entity.isActive() ? 1 : 0;
        statement.bindLong(6, _tmp_1);
      }
    };
    this.__updateAdapterOfUserEntity = new EntityDeletionOrUpdateAdapter<UserEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `users` SET `name` = ?,`hobby` = ?,`history` = ?,`password` = ?,`userName` = ?,`isActive` = ? WHERE `userName` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserEntity entity) {
        if (entity.getName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getName());
        }
        if (entity.getHobby() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getHobby());
        }
        final String _tmp = __activityLogConverter.activityLogListToString(entity.getHistory());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        if (entity.getPassword() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPassword());
        }
        if (entity.getUserName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getUserName());
        }
        final int _tmp_1 = entity.isActive() ? 1 : 0;
        statement.bindLong(6, _tmp_1);
        if (entity.getUserName() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getUserName());
        }
      }
    };
    this.__preparedStmtOfDeactivateAllUsers = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET isActive = 0";
        return _query;
      }
    };
    this.__preparedStmtOfSetActiveUser = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET isActive = 1 WHERE userName = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteUser = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM users WHERE userName = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertUser(final UserEntity user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserEntity.insert(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUser(final UserEntity user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUserEntity.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deactivateAllUsers(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeactivateAllUsers.acquire();
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
          __preparedStmtOfDeactivateAllUsers.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object setActiveUser(final String userName, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfSetActiveUser.acquire();
        int _argIndex = 1;
        if (userName == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userName);
        }
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
          __preparedStmtOfSetActiveUser.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteUser(final String userName, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUser.acquire();
        int _argIndex = 1;
        if (userName == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userName);
        }
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
          __preparedStmtOfDeleteUser.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<UserEntity> getCurrentUser() {
    final String _sql = "SELECT * FROM users WHERE isActive = 1 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"users"}, false, new Callable<UserEntity>() {
      @Override
      @Nullable
      public UserEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfHobby = CursorUtil.getColumnIndexOrThrow(_cursor, "hobby");
          final int _cursorIndexOfHistory = CursorUtil.getColumnIndexOrThrow(_cursor, "history");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final UserEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpHobby;
            if (_cursor.isNull(_cursorIndexOfHobby)) {
              _tmpHobby = null;
            } else {
              _tmpHobby = _cursor.getString(_cursorIndexOfHobby);
            }
            final List<ActivityLog> _tmpHistory;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfHistory)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfHistory);
            }
            _tmpHistory = __activityLogConverter.stringToActivityLogList(_tmp);
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            final String _tmpUserName;
            if (_cursor.isNull(_cursorIndexOfUserName)) {
              _tmpUserName = null;
            } else {
              _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
            }
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            _result = new UserEntity(_tmpName,_tmpHobby,_tmpHistory,_tmpPassword,_tmpUserName,_tmpIsActive);
          } else {
            _result = null;
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

  @Override
  public Object getUserByUsername(final String userName,
      final Continuation<? super UserEntity> $completion) {
    final String _sql = "SELECT * FROM users WHERE userName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userName);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserEntity>() {
      @Override
      @Nullable
      public UserEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfHobby = CursorUtil.getColumnIndexOrThrow(_cursor, "hobby");
          final int _cursorIndexOfHistory = CursorUtil.getColumnIndexOrThrow(_cursor, "history");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final UserEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpHobby;
            if (_cursor.isNull(_cursorIndexOfHobby)) {
              _tmpHobby = null;
            } else {
              _tmpHobby = _cursor.getString(_cursorIndexOfHobby);
            }
            final List<ActivityLog> _tmpHistory;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfHistory)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfHistory);
            }
            _tmpHistory = __activityLogConverter.stringToActivityLogList(_tmp);
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            final String _tmpUserName;
            if (_cursor.isNull(_cursorIndexOfUserName)) {
              _tmpUserName = null;
            } else {
              _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
            }
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            _result = new UserEntity(_tmpName,_tmpHobby,_tmpHistory,_tmpPassword,_tmpUserName,_tmpIsActive);
          } else {
            _result = null;
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
