package com.KursachApp.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.KursachApp.database.TypeConverter;
import com.KursachApp.model.Set;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SetDao_Impl implements SetDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Set> __insertionAdapterOfSet;

  private final TypeConverter __typeConverter = new TypeConverter();

  private final EntityInsertionAdapter<Set> __insertionAdapterOfSet_1;

  private final EntityDeletionOrUpdateAdapter<Set> __deletionAdapterOfSet;

  private final EntityDeletionOrUpdateAdapter<Set> __updateAdapterOfSet;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SetDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSet = new EntityInsertionAdapter<Set>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Set` (`id`,`weights`,`reps`,`completed`,`exercise`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Set value) {
        final String _tmp;
        _tmp = __typeConverter.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        stmt.bindDouble(2, value.getWeights());
        stmt.bindLong(3, value.getReps());
        final int _tmp_1;
        _tmp_1 = value.getCompleted() ? 1 : 0;
        stmt.bindLong(4, _tmp_1);
        final String _tmp_2;
        _tmp_2 = __typeConverter.fromUUID(value.getExercise());
        if (_tmp_2 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_2);
        }
      }
    };
    this.__insertionAdapterOfSet_1 = new EntityInsertionAdapter<Set>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Set` (`id`,`weights`,`reps`,`completed`,`exercise`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Set value) {
        final String _tmp;
        _tmp = __typeConverter.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        stmt.bindDouble(2, value.getWeights());
        stmt.bindLong(3, value.getReps());
        final int _tmp_1;
        _tmp_1 = value.getCompleted() ? 1 : 0;
        stmt.bindLong(4, _tmp_1);
        final String _tmp_2;
        _tmp_2 = __typeConverter.fromUUID(value.getExercise());
        if (_tmp_2 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_2);
        }
      }
    };
    this.__deletionAdapterOfSet = new EntityDeletionOrUpdateAdapter<Set>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Set` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Set value) {
        final String _tmp;
        _tmp = __typeConverter.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
      }
    };
    this.__updateAdapterOfSet = new EntityDeletionOrUpdateAdapter<Set>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `Set` SET `id` = ?,`weights` = ?,`reps` = ?,`completed` = ?,`exercise` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Set value) {
        final String _tmp;
        _tmp = __typeConverter.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        stmt.bindDouble(2, value.getWeights());
        stmt.bindLong(3, value.getReps());
        final int _tmp_1;
        _tmp_1 = value.getCompleted() ? 1 : 0;
        stmt.bindLong(4, _tmp_1);
        final String _tmp_2;
        _tmp_2 = __typeConverter.fromUUID(value.getExercise());
        if (_tmp_2 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_2);
        }
        final String _tmp_3;
        _tmp_3 = __typeConverter.fromUUID(value.getId());
        if (_tmp_3 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_3);
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM `set`";
        return _query;
      }
    };
  }

  @Override
  public void save(final Set t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSet.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void save(final Set... t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSet.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void save(final List<? extends Set> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSet.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long saveAndGetCount(final Set t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfSet_1.insertAndReturnId(t);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Set t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSet.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Set... t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSet.handleMultiple(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<? extends Set> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSet.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Set t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSet.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Set... t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSet.handleMultiple(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final List<? extends Set> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSet.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<Set> get(final UUID id) {
    final String _sql = "SELECT * FROM `set` WHERE id=(?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp;
    _tmp = __typeConverter.fromUUID(id);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"set"}, false, new Callable<Set>() {
      @Override
      public Set call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWeights = CursorUtil.getColumnIndexOrThrow(_cursor, "weights");
          final int _cursorIndexOfReps = CursorUtil.getColumnIndexOrThrow(_cursor, "reps");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfExercise = CursorUtil.getColumnIndexOrThrow(_cursor, "exercise");
          final Set _result;
          if(_cursor.moveToFirst()) {
            final UUID _tmpId;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __typeConverter.toUUID(_tmp_1);
            final double _tmpWeights;
            _tmpWeights = _cursor.getDouble(_cursorIndexOfWeights);
            final int _tmpReps;
            _tmpReps = _cursor.getInt(_cursorIndexOfReps);
            final boolean _tmpCompleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_2 != 0;
            final UUID _tmpExercise;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfExercise)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfExercise);
            }
            _tmpExercise = __typeConverter.toUUID(_tmp_3);
            _result = new Set(_tmpId,_tmpWeights,_tmpReps,_tmpCompleted,_tmpExercise);
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
  public LiveData<List<Set>> getAll() {
    final String _sql = "SELECT * FROM `set`";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"set"}, false, new Callable<List<Set>>() {
      @Override
      public List<Set> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWeights = CursorUtil.getColumnIndexOrThrow(_cursor, "weights");
          final int _cursorIndexOfReps = CursorUtil.getColumnIndexOrThrow(_cursor, "reps");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfExercise = CursorUtil.getColumnIndexOrThrow(_cursor, "exercise");
          final List<Set> _result = new ArrayList<Set>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Set _item;
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __typeConverter.toUUID(_tmp);
            final double _tmpWeights;
            _tmpWeights = _cursor.getDouble(_cursorIndexOfWeights);
            final int _tmpReps;
            _tmpReps = _cursor.getInt(_cursorIndexOfReps);
            final boolean _tmpCompleted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_1 != 0;
            final UUID _tmpExercise;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfExercise)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfExercise);
            }
            _tmpExercise = __typeConverter.toUUID(_tmp_2);
            _item = new Set(_tmpId,_tmpWeights,_tmpReps,_tmpCompleted,_tmpExercise);
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

  @Override
  public Cursor getAllRaw() {
    final String _sql = "SELECT * FROM `set`";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
