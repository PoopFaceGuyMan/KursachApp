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
import com.KursachApp.model.Workout;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WorkoutDao_Impl implements WorkoutDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Workout> __insertionAdapterOfWorkout;

  private final TypeConverter __typeConverter = new TypeConverter();

  private final EntityInsertionAdapter<Workout> __insertionAdapterOfWorkout_1;

  private final EntityDeletionOrUpdateAdapter<Workout> __deletionAdapterOfWorkout;

  private final EntityDeletionOrUpdateAdapter<Workout> __updateAdapterOfWorkout;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public WorkoutDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWorkout = new EntityInsertionAdapter<Workout>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Workout` (`id`,`name`,`date`,`reminder`,`completed`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Workout value) {
        final String _tmp;
        _tmp = __typeConverter.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        final Long _tmp_1;
        _tmp_1 = __typeConverter.fromDate(value.getDate());
        if (_tmp_1 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp_1);
        }
        if (value.getReminder() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getReminder());
        }
        final int _tmp_2;
        _tmp_2 = value.getCompleted() ? 1 : 0;
        stmt.bindLong(5, _tmp_2);
      }
    };
    this.__insertionAdapterOfWorkout_1 = new EntityInsertionAdapter<Workout>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Workout` (`id`,`name`,`date`,`reminder`,`completed`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Workout value) {
        final String _tmp;
        _tmp = __typeConverter.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        final Long _tmp_1;
        _tmp_1 = __typeConverter.fromDate(value.getDate());
        if (_tmp_1 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp_1);
        }
        if (value.getReminder() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getReminder());
        }
        final int _tmp_2;
        _tmp_2 = value.getCompleted() ? 1 : 0;
        stmt.bindLong(5, _tmp_2);
      }
    };
    this.__deletionAdapterOfWorkout = new EntityDeletionOrUpdateAdapter<Workout>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Workout` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Workout value) {
        final String _tmp;
        _tmp = __typeConverter.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
      }
    };
    this.__updateAdapterOfWorkout = new EntityDeletionOrUpdateAdapter<Workout>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `Workout` SET `id` = ?,`name` = ?,`date` = ?,`reminder` = ?,`completed` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Workout value) {
        final String _tmp;
        _tmp = __typeConverter.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        final Long _tmp_1;
        _tmp_1 = __typeConverter.fromDate(value.getDate());
        if (_tmp_1 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp_1);
        }
        if (value.getReminder() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getReminder());
        }
        final int _tmp_2;
        _tmp_2 = value.getCompleted() ? 1 : 0;
        stmt.bindLong(5, _tmp_2);
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
        final String _query = "DELETE FROM workout";
        return _query;
      }
    };
  }

  @Override
  public void save(final Workout t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkout.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void save(final Workout... t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkout.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void save(final List<? extends Workout> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkout.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long saveAndGetCount(final Workout t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfWorkout_1.insertAndReturnId(t);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Workout t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfWorkout.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Workout... t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfWorkout.handleMultiple(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<? extends Workout> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfWorkout.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Workout t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWorkout.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Workout... t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWorkout.handleMultiple(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final List<? extends Workout> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWorkout.handleMultiple(list);
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
  public LiveData<Workout> get(final UUID id) {
    final String _sql = "SELECT * FROM workout WHERE id=(?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp;
    _tmp = __typeConverter.fromUUID(id);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"workout"}, false, new Callable<Workout>() {
      @Override
      public Workout call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final Workout _result;
          if(_cursor.moveToFirst()) {
            final UUID _tmpId;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __typeConverter.toUUID(_tmp_1);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Date _tmpDate;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __typeConverter.toDate(_tmp_2);
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final boolean _tmpCompleted;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_3 != 0;
            _result = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
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
  public LiveData<List<Workout>> getCompleted() {
    final String _sql = "SELECT * FROM workout WHERE completed = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"workout"}, false, new Callable<List<Workout>>() {
      @Override
      public List<Workout> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final List<Workout> _result = new ArrayList<Workout>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Workout _item;
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __typeConverter.toUUID(_tmp);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Date _tmpDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __typeConverter.toDate(_tmp_1);
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final boolean _tmpCompleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_2 != 0;
            _item = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
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
  public LiveData<List<Workout>> getCompletedOrderByDate(final boolean asc) {
    final String _sql = "SELECT * FROM workout WHERE completed = 1 ORDER BY CASE WHEN ? = 1 THEN date END ASC, CASE WHEN ? = 0 then date END DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final int _tmp;
    _tmp = asc ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    final int _tmp_1;
    _tmp_1 = asc ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp_1);
    return __db.getInvalidationTracker().createLiveData(new String[]{"workout"}, false, new Callable<List<Workout>>() {
      @Override
      public List<Workout> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final List<Workout> _result = new ArrayList<Workout>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Workout _item;
            final UUID _tmpId;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __typeConverter.toUUID(_tmp_2);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Date _tmpDate;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __typeConverter.toDate(_tmp_3);
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final boolean _tmpCompleted;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_4 != 0;
            _item = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
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
  public LiveData<List<Workout>> getNonCompleted() {
    final String _sql = "SELECT * FROM workout WHERE completed = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"workout"}, false, new Callable<List<Workout>>() {
      @Override
      public List<Workout> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final List<Workout> _result = new ArrayList<Workout>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Workout _item;
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __typeConverter.toUUID(_tmp);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Date _tmpDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __typeConverter.toDate(_tmp_1);
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final boolean _tmpCompleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_2 != 0;
            _item = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
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
  public LiveData<List<Workout>> getNonCompletedOrderByDate(final boolean asc) {
    final String _sql = "SELECT * FROM workout WHERE completed = 0 ORDER BY CASE WHEN ? = 1 THEN date END ASC, CASE WHEN ? = 0 then date END DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final int _tmp;
    _tmp = asc ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    final int _tmp_1;
    _tmp_1 = asc ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp_1);
    return __db.getInvalidationTracker().createLiveData(new String[]{"workout"}, false, new Callable<List<Workout>>() {
      @Override
      public List<Workout> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final List<Workout> _result = new ArrayList<Workout>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Workout _item;
            final UUID _tmpId;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __typeConverter.toUUID(_tmp_2);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Date _tmpDate;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __typeConverter.toDate(_tmp_3);
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final boolean _tmpCompleted;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_4 != 0;
            _item = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
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
  public LiveData<List<Workout>> getAll() {
    final String _sql = "SELECT * FROM workout";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"workout"}, false, new Callable<List<Workout>>() {
      @Override
      public List<Workout> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final List<Workout> _result = new ArrayList<Workout>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Workout _item;
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __typeConverter.toUUID(_tmp);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Date _tmpDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __typeConverter.toDate(_tmp_1);
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final boolean _tmpCompleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_2 != 0;
            _item = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
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
    final String _sql = "SELECT * FROM workout";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }

  @Override
  public LiveData<List<Workout>> getAllOrderByDate(final boolean asc) {
    final String _sql = "SELECT * FROM workout ORDER BY CASE WHEN ? = 1 THEN date END ASC, CASE WHEN ? = 0 then date END DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final int _tmp;
    _tmp = asc ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    final int _tmp_1;
    _tmp_1 = asc ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp_1);
    return __db.getInvalidationTracker().createLiveData(new String[]{"workout"}, false, new Callable<List<Workout>>() {
      @Override
      public List<Workout> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final List<Workout> _result = new ArrayList<Workout>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Workout _item;
            final UUID _tmpId;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __typeConverter.toUUID(_tmp_2);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Date _tmpDate;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __typeConverter.toDate(_tmp_3);
            final Long _tmpReminder;
            if (_cursor.isNull(_cursorIndexOfReminder)) {
              _tmpReminder = null;
            } else {
              _tmpReminder = _cursor.getLong(_cursorIndexOfReminder);
            }
            final boolean _tmpCompleted;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_4 != 0;
            _item = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
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
  public long getCount() {
    final String _sql = "SELECT COUNT(*) FROM workout";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
