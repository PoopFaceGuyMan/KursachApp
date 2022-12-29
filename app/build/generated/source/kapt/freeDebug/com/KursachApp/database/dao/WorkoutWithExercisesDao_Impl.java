package com.KursachApp.database.dao;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import com.KursachApp.database.TypeConverter;
import com.KursachApp.model.Exercise;
import com.KursachApp.model.ExerciseWithSets;
import com.KursachApp.model.Set;
import com.KursachApp.model.Workout;
import com.KursachApp.model.WorkoutWithExercises;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WorkoutWithExercisesDao_Impl implements WorkoutWithExercisesDao {
  private final RoomDatabase __db;

  private final TypeConverter __typeConverter = new TypeConverter();

  public WorkoutWithExercisesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public LiveData<WorkoutWithExercises> get(final UUID id) {
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
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","Exercise","workout"}, true, new Callable<WorkoutWithExercises>() {
      @Override
      public WorkoutWithExercises call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
            final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
            final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
            final ArrayMap<String, ArrayList<ExerciseWithSets>> _collectionExercises = new ArrayMap<String, ArrayList<ExerciseWithSets>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<ExerciseWithSets> _tmpExercisesCollection = _collectionExercises.get(_tmpKey);
              if (_tmpExercisesCollection == null) {
                _tmpExercisesCollection = new ArrayList<ExerciseWithSets>();
                _collectionExercises.put(_tmpKey, _tmpExercisesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(_collectionExercises);
            final WorkoutWithExercises _result;
            if(_cursor.moveToFirst()) {
              final Workout _tmpWorkout;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfDate) && _cursor.isNull(_cursorIndexOfReminder) && _cursor.isNull(_cursorIndexOfCompleted))) {
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
                _tmpWorkout = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
              }  else  {
                _tmpWorkout = null;
              }
              ArrayList<ExerciseWithSets> _tmpExercisesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpExercisesCollection_1 = _collectionExercises.get(_tmpKey_1);
              if (_tmpExercisesCollection_1 == null) {
                _tmpExercisesCollection_1 = new ArrayList<ExerciseWithSets>();
              }
              _result = new WorkoutWithExercises(_tmpWorkout,_tmpExercisesCollection_1);
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<WorkoutWithExercises>> getCompleted() {
    final String _sql = "SELECT * FROM workout WHERE completed = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","Exercise","workout"}, true, new Callable<List<WorkoutWithExercises>>() {
      @Override
      public List<WorkoutWithExercises> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
            final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
            final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
            final ArrayMap<String, ArrayList<ExerciseWithSets>> _collectionExercises = new ArrayMap<String, ArrayList<ExerciseWithSets>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<ExerciseWithSets> _tmpExercisesCollection = _collectionExercises.get(_tmpKey);
              if (_tmpExercisesCollection == null) {
                _tmpExercisesCollection = new ArrayList<ExerciseWithSets>();
                _collectionExercises.put(_tmpKey, _tmpExercisesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(_collectionExercises);
            final List<WorkoutWithExercises> _result = new ArrayList<WorkoutWithExercises>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final WorkoutWithExercises _item;
              final Workout _tmpWorkout;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfDate) && _cursor.isNull(_cursorIndexOfReminder) && _cursor.isNull(_cursorIndexOfCompleted))) {
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
                _tmpWorkout = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
              }  else  {
                _tmpWorkout = null;
              }
              ArrayList<ExerciseWithSets> _tmpExercisesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpExercisesCollection_1 = _collectionExercises.get(_tmpKey_1);
              if (_tmpExercisesCollection_1 == null) {
                _tmpExercisesCollection_1 = new ArrayList<ExerciseWithSets>();
              }
              _item = new WorkoutWithExercises(_tmpWorkout,_tmpExercisesCollection_1);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<WorkoutWithExercises> getMostRecentlyCompleted(final long today) {
    final String _sql = "SELECT * FROM workout WHERE completed = 1 AND date <= (?) ORDER BY date LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, today);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","Exercise","workout"}, true, new Callable<WorkoutWithExercises>() {
      @Override
      public WorkoutWithExercises call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
            final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
            final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
            final ArrayMap<String, ArrayList<ExerciseWithSets>> _collectionExercises = new ArrayMap<String, ArrayList<ExerciseWithSets>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<ExerciseWithSets> _tmpExercisesCollection = _collectionExercises.get(_tmpKey);
              if (_tmpExercisesCollection == null) {
                _tmpExercisesCollection = new ArrayList<ExerciseWithSets>();
                _collectionExercises.put(_tmpKey, _tmpExercisesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(_collectionExercises);
            final WorkoutWithExercises _result;
            if(_cursor.moveToFirst()) {
              final Workout _tmpWorkout;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfDate) && _cursor.isNull(_cursorIndexOfReminder) && _cursor.isNull(_cursorIndexOfCompleted))) {
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
                _tmpWorkout = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
              }  else  {
                _tmpWorkout = null;
              }
              ArrayList<ExerciseWithSets> _tmpExercisesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpExercisesCollection_1 = _collectionExercises.get(_tmpKey_1);
              if (_tmpExercisesCollection_1 == null) {
                _tmpExercisesCollection_1 = new ArrayList<ExerciseWithSets>();
              }
              _result = new WorkoutWithExercises(_tmpWorkout,_tmpExercisesCollection_1);
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<WorkoutWithExercises> getNext(final long now) {
    final String _sql = "SELECT * FROM workout WHERE completed = 0 AND date >= (?) ORDER BY date ASC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, now);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","Exercise","workout"}, true, new Callable<WorkoutWithExercises>() {
      @Override
      public WorkoutWithExercises call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
            final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
            final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
            final ArrayMap<String, ArrayList<ExerciseWithSets>> _collectionExercises = new ArrayMap<String, ArrayList<ExerciseWithSets>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<ExerciseWithSets> _tmpExercisesCollection = _collectionExercises.get(_tmpKey);
              if (_tmpExercisesCollection == null) {
                _tmpExercisesCollection = new ArrayList<ExerciseWithSets>();
                _collectionExercises.put(_tmpKey, _tmpExercisesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(_collectionExercises);
            final WorkoutWithExercises _result;
            if(_cursor.moveToFirst()) {
              final Workout _tmpWorkout;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfDate) && _cursor.isNull(_cursorIndexOfReminder) && _cursor.isNull(_cursorIndexOfCompleted))) {
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
                _tmpWorkout = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
              }  else  {
                _tmpWorkout = null;
              }
              ArrayList<ExerciseWithSets> _tmpExercisesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpExercisesCollection_1 = _collectionExercises.get(_tmpKey_1);
              if (_tmpExercisesCollection_1 == null) {
                _tmpExercisesCollection_1 = new ArrayList<ExerciseWithSets>();
              }
              _result = new WorkoutWithExercises(_tmpWorkout,_tmpExercisesCollection_1);
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<WorkoutWithExercises> getLast(final long now) {
    final String _sql = "SELECT * FROM workout WHERE completed = 1 AND date <= (?) ORDER BY date DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, now);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","Exercise","workout"}, true, new Callable<WorkoutWithExercises>() {
      @Override
      public WorkoutWithExercises call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
            final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
            final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
            final ArrayMap<String, ArrayList<ExerciseWithSets>> _collectionExercises = new ArrayMap<String, ArrayList<ExerciseWithSets>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<ExerciseWithSets> _tmpExercisesCollection = _collectionExercises.get(_tmpKey);
              if (_tmpExercisesCollection == null) {
                _tmpExercisesCollection = new ArrayList<ExerciseWithSets>();
                _collectionExercises.put(_tmpKey, _tmpExercisesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(_collectionExercises);
            final WorkoutWithExercises _result;
            if(_cursor.moveToFirst()) {
              final Workout _tmpWorkout;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfDate) && _cursor.isNull(_cursorIndexOfReminder) && _cursor.isNull(_cursorIndexOfCompleted))) {
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
                _tmpWorkout = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
              }  else  {
                _tmpWorkout = null;
              }
              ArrayList<ExerciseWithSets> _tmpExercisesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpExercisesCollection_1 = _collectionExercises.get(_tmpKey_1);
              if (_tmpExercisesCollection_1 == null) {
                _tmpExercisesCollection_1 = new ArrayList<ExerciseWithSets>();
              }
              _result = new WorkoutWithExercises(_tmpWorkout,_tmpExercisesCollection_1);
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<WorkoutWithExercises>> getCompletedOrderByDate(final boolean asc) {
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
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","Exercise","workout"}, true, new Callable<List<WorkoutWithExercises>>() {
      @Override
      public List<WorkoutWithExercises> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
            final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
            final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
            final ArrayMap<String, ArrayList<ExerciseWithSets>> _collectionExercises = new ArrayMap<String, ArrayList<ExerciseWithSets>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<ExerciseWithSets> _tmpExercisesCollection = _collectionExercises.get(_tmpKey);
              if (_tmpExercisesCollection == null) {
                _tmpExercisesCollection = new ArrayList<ExerciseWithSets>();
                _collectionExercises.put(_tmpKey, _tmpExercisesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(_collectionExercises);
            final List<WorkoutWithExercises> _result = new ArrayList<WorkoutWithExercises>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final WorkoutWithExercises _item;
              final Workout _tmpWorkout;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfDate) && _cursor.isNull(_cursorIndexOfReminder) && _cursor.isNull(_cursorIndexOfCompleted))) {
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
                _tmpWorkout = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
              }  else  {
                _tmpWorkout = null;
              }
              ArrayList<ExerciseWithSets> _tmpExercisesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpExercisesCollection_1 = _collectionExercises.get(_tmpKey_1);
              if (_tmpExercisesCollection_1 == null) {
                _tmpExercisesCollection_1 = new ArrayList<ExerciseWithSets>();
              }
              _item = new WorkoutWithExercises(_tmpWorkout,_tmpExercisesCollection_1);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<WorkoutWithExercises>> getCompletedBetween(final long from, final long to) {
    final String _sql = "SELECT * FROM workout WHERE completed = 1 AND (?) <= date AND date <= (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, from);
    _argIndex = 2;
    _statement.bindLong(_argIndex, to);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","Exercise","workout"}, true, new Callable<List<WorkoutWithExercises>>() {
      @Override
      public List<WorkoutWithExercises> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
            final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
            final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
            final ArrayMap<String, ArrayList<ExerciseWithSets>> _collectionExercises = new ArrayMap<String, ArrayList<ExerciseWithSets>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<ExerciseWithSets> _tmpExercisesCollection = _collectionExercises.get(_tmpKey);
              if (_tmpExercisesCollection == null) {
                _tmpExercisesCollection = new ArrayList<ExerciseWithSets>();
                _collectionExercises.put(_tmpKey, _tmpExercisesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(_collectionExercises);
            final List<WorkoutWithExercises> _result = new ArrayList<WorkoutWithExercises>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final WorkoutWithExercises _item;
              final Workout _tmpWorkout;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfDate) && _cursor.isNull(_cursorIndexOfReminder) && _cursor.isNull(_cursorIndexOfCompleted))) {
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
                _tmpWorkout = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
              }  else  {
                _tmpWorkout = null;
              }
              ArrayList<ExerciseWithSets> _tmpExercisesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpExercisesCollection_1 = _collectionExercises.get(_tmpKey_1);
              if (_tmpExercisesCollection_1 == null) {
                _tmpExercisesCollection_1 = new ArrayList<ExerciseWithSets>();
              }
              _item = new WorkoutWithExercises(_tmpWorkout,_tmpExercisesCollection_1);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<WorkoutWithExercises>> getNonCompleted() {
    final String _sql = "SELECT * FROM workout WHERE completed = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","Exercise","workout"}, true, new Callable<List<WorkoutWithExercises>>() {
      @Override
      public List<WorkoutWithExercises> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
            final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
            final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
            final ArrayMap<String, ArrayList<ExerciseWithSets>> _collectionExercises = new ArrayMap<String, ArrayList<ExerciseWithSets>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<ExerciseWithSets> _tmpExercisesCollection = _collectionExercises.get(_tmpKey);
              if (_tmpExercisesCollection == null) {
                _tmpExercisesCollection = new ArrayList<ExerciseWithSets>();
                _collectionExercises.put(_tmpKey, _tmpExercisesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(_collectionExercises);
            final List<WorkoutWithExercises> _result = new ArrayList<WorkoutWithExercises>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final WorkoutWithExercises _item;
              final Workout _tmpWorkout;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfDate) && _cursor.isNull(_cursorIndexOfReminder) && _cursor.isNull(_cursorIndexOfCompleted))) {
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
                _tmpWorkout = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
              }  else  {
                _tmpWorkout = null;
              }
              ArrayList<ExerciseWithSets> _tmpExercisesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpExercisesCollection_1 = _collectionExercises.get(_tmpKey_1);
              if (_tmpExercisesCollection_1 == null) {
                _tmpExercisesCollection_1 = new ArrayList<ExerciseWithSets>();
              }
              _item = new WorkoutWithExercises(_tmpWorkout,_tmpExercisesCollection_1);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<WorkoutWithExercises>> getNonCompletedOrderByDate(final boolean asc) {
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
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","Exercise","workout"}, true, new Callable<List<WorkoutWithExercises>>() {
      @Override
      public List<WorkoutWithExercises> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
            final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
            final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
            final ArrayMap<String, ArrayList<ExerciseWithSets>> _collectionExercises = new ArrayMap<String, ArrayList<ExerciseWithSets>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<ExerciseWithSets> _tmpExercisesCollection = _collectionExercises.get(_tmpKey);
              if (_tmpExercisesCollection == null) {
                _tmpExercisesCollection = new ArrayList<ExerciseWithSets>();
                _collectionExercises.put(_tmpKey, _tmpExercisesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(_collectionExercises);
            final List<WorkoutWithExercises> _result = new ArrayList<WorkoutWithExercises>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final WorkoutWithExercises _item;
              final Workout _tmpWorkout;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfDate) && _cursor.isNull(_cursorIndexOfReminder) && _cursor.isNull(_cursorIndexOfCompleted))) {
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
                _tmpWorkout = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
              }  else  {
                _tmpWorkout = null;
              }
              ArrayList<ExerciseWithSets> _tmpExercisesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpExercisesCollection_1 = _collectionExercises.get(_tmpKey_1);
              if (_tmpExercisesCollection_1 == null) {
                _tmpExercisesCollection_1 = new ArrayList<ExerciseWithSets>();
              }
              _item = new WorkoutWithExercises(_tmpWorkout,_tmpExercisesCollection_1);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<WorkoutWithExercises>> getAll() {
    final String _sql = "SELECT * FROM workout";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","Exercise","workout"}, true, new Callable<List<WorkoutWithExercises>>() {
      @Override
      public List<WorkoutWithExercises> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
            final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
            final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
            final ArrayMap<String, ArrayList<ExerciseWithSets>> _collectionExercises = new ArrayMap<String, ArrayList<ExerciseWithSets>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<ExerciseWithSets> _tmpExercisesCollection = _collectionExercises.get(_tmpKey);
              if (_tmpExercisesCollection == null) {
                _tmpExercisesCollection = new ArrayList<ExerciseWithSets>();
                _collectionExercises.put(_tmpKey, _tmpExercisesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(_collectionExercises);
            final List<WorkoutWithExercises> _result = new ArrayList<WorkoutWithExercises>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final WorkoutWithExercises _item;
              final Workout _tmpWorkout;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfDate) && _cursor.isNull(_cursorIndexOfReminder) && _cursor.isNull(_cursorIndexOfCompleted))) {
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
                _tmpWorkout = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
              }  else  {
                _tmpWorkout = null;
              }
              ArrayList<ExerciseWithSets> _tmpExercisesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpExercisesCollection_1 = _collectionExercises.get(_tmpKey_1);
              if (_tmpExercisesCollection_1 == null) {
                _tmpExercisesCollection_1 = new ArrayList<ExerciseWithSets>();
              }
              _item = new WorkoutWithExercises(_tmpWorkout,_tmpExercisesCollection_1);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<WorkoutWithExercises>> getAllOrderByDate(final boolean asc) {
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
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","Exercise","workout"}, true, new Callable<List<WorkoutWithExercises>>() {
      @Override
      public List<WorkoutWithExercises> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
            final int _cursorIndexOfReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "reminder");
            final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
            final ArrayMap<String, ArrayList<ExerciseWithSets>> _collectionExercises = new ArrayMap<String, ArrayList<ExerciseWithSets>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<ExerciseWithSets> _tmpExercisesCollection = _collectionExercises.get(_tmpKey);
              if (_tmpExercisesCollection == null) {
                _tmpExercisesCollection = new ArrayList<ExerciseWithSets>();
                _collectionExercises.put(_tmpKey, _tmpExercisesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(_collectionExercises);
            final List<WorkoutWithExercises> _result = new ArrayList<WorkoutWithExercises>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final WorkoutWithExercises _item;
              final Workout _tmpWorkout;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfDate) && _cursor.isNull(_cursorIndexOfReminder) && _cursor.isNull(_cursorIndexOfCompleted))) {
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
                _tmpWorkout = new Workout(_tmpId,_tmpName,_tmpDate,_tmpReminder,_tmpCompleted);
              }  else  {
                _tmpWorkout = null;
              }
              ArrayList<ExerciseWithSets> _tmpExercisesCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpExercisesCollection_1 = _collectionExercises.get(_tmpKey_1);
              if (_tmpExercisesCollection_1 == null) {
                _tmpExercisesCollection_1 = new ArrayList<ExerciseWithSets>();
              }
              _item = new WorkoutWithExercises(_tmpWorkout,_tmpExercisesCollection_1);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshipSetAscomKursachAppModelSet(
      final ArrayMap<String, ArrayList<Set>> _map) {
    final java.util.Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      ArrayMap<String, ArrayList<Set>> _tmpInnerMap = new ArrayMap<String, ArrayList<Set>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipSetAscomKursachAppModelSet(_tmpInnerMap);
          _tmpInnerMap = new ArrayMap<String, ArrayList<Set>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipSetAscomKursachAppModelSet(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`weights`,`reps`,`completed`,`exercise` FROM `Set` WHERE `exercise` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      if (_item == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "exercise");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfWeights = CursorUtil.getColumnIndexOrThrow(_cursor, "weights");
      final int _cursorIndexOfReps = CursorUtil.getColumnIndexOrThrow(_cursor, "reps");
      final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
      final int _cursorIndexOfExercise = CursorUtil.getColumnIndexOrThrow(_cursor, "exercise");
      while(_cursor.moveToNext()) {
        final String _tmpKey = _cursor.getString(_itemKeyIndex);
        ArrayList<Set> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final Set _item_1;
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
          _item_1 = new Set(_tmpId,_tmpWeights,_tmpReps,_tmpCompleted,_tmpExercise);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }

  private void __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(
      final ArrayMap<String, ArrayList<ExerciseWithSets>> _map) {
    final java.util.Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      ArrayMap<String, ArrayList<ExerciseWithSets>> _tmpInnerMap = new ArrayMap<String, ArrayList<ExerciseWithSets>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(_tmpInnerMap);
          _tmpInnerMap = new ArrayMap<String, ArrayList<ExerciseWithSets>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipExerciseAscomKursachAppModelExerciseWithSets(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`name`,`completed`,`workout` FROM `Exercise` WHERE `workout` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      if (_item == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, true, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "workout");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
      final int _cursorIndexOfWorkout = CursorUtil.getColumnIndexOrThrow(_cursor, "workout");
      final ArrayMap<String, ArrayList<Set>> _collectionSets = new ArrayMap<String, ArrayList<Set>>();
      while (_cursor.moveToNext()) {
        final String _tmpKey = _cursor.getString(_cursorIndexOfId);
        ArrayList<Set> _tmpSetsCollection = _collectionSets.get(_tmpKey);
        if (_tmpSetsCollection == null) {
          _tmpSetsCollection = new ArrayList<Set>();
          _collectionSets.put(_tmpKey, _tmpSetsCollection);
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshipSetAscomKursachAppModelSet(_collectionSets);
      while(_cursor.moveToNext()) {
        final String _tmpKey_1 = _cursor.getString(_itemKeyIndex);
        ArrayList<ExerciseWithSets> _tmpRelation = _map.get(_tmpKey_1);
        if (_tmpRelation != null) {
          final ExerciseWithSets _item_1;
          final Exercise _tmpExercise;
          if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfCompleted) && _cursor.isNull(_cursorIndexOfWorkout))) {
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
            final boolean _tmpCompleted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_1 != 0;
            final UUID _tmpWorkout;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfWorkout)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfWorkout);
            }
            _tmpWorkout = __typeConverter.toUUID(_tmp_2);
            _tmpExercise = new Exercise(_tmpId,_tmpName,_tmpCompleted,_tmpWorkout);
          }  else  {
            _tmpExercise = null;
          }
          ArrayList<Set> _tmpSetsCollection_1 = null;
          final String _tmpKey_2 = _cursor.getString(_cursorIndexOfId);
          _tmpSetsCollection_1 = _collectionSets.get(_tmpKey_2);
          if (_tmpSetsCollection_1 == null) {
            _tmpSetsCollection_1 = new ArrayList<Set>();
          }
          _item_1 = new ExerciseWithSets(_tmpExercise,_tmpSetsCollection_1);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
