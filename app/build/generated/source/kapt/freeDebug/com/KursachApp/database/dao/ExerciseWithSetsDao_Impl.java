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
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ExerciseWithSetsDao_Impl implements ExerciseWithSetsDao {
  private final RoomDatabase __db;

  private final TypeConverter __typeConverter = new TypeConverter();

  public ExerciseWithSetsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public LiveData<ExerciseWithSets> get(final UUID id) {
    final String _sql = "SELECT * FROM exercise WHERE id=(?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp;
    _tmp = __typeConverter.fromUUID(id);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","exercise"}, true, new Callable<ExerciseWithSets>() {
      @Override
      public ExerciseWithSets call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
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
            final ExerciseWithSets _result;
            if(_cursor.moveToFirst()) {
              final Exercise _tmpExercise;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfCompleted) && _cursor.isNull(_cursorIndexOfWorkout))) {
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
                final boolean _tmpCompleted;
                final int _tmp_2;
                _tmp_2 = _cursor.getInt(_cursorIndexOfCompleted);
                _tmpCompleted = _tmp_2 != 0;
                final UUID _tmpWorkout;
                final String _tmp_3;
                if (_cursor.isNull(_cursorIndexOfWorkout)) {
                  _tmp_3 = null;
                } else {
                  _tmp_3 = _cursor.getString(_cursorIndexOfWorkout);
                }
                _tmpWorkout = __typeConverter.toUUID(_tmp_3);
                _tmpExercise = new Exercise(_tmpId,_tmpName,_tmpCompleted,_tmpWorkout);
              }  else  {
                _tmpExercise = null;
              }
              ArrayList<Set> _tmpSetsCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpSetsCollection_1 = _collectionSets.get(_tmpKey_1);
              if (_tmpSetsCollection_1 == null) {
                _tmpSetsCollection_1 = new ArrayList<Set>();
              }
              _result = new ExerciseWithSets(_tmpExercise,_tmpSetsCollection_1);
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
  public LiveData<List<ExerciseWithSets>> getTemplates() {
    final String _sql = "SELECT * FROM exercise WHERE workout is null";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","exercise"}, true, new Callable<List<ExerciseWithSets>>() {
      @Override
      public List<ExerciseWithSets> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
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
            final List<ExerciseWithSets> _result = new ArrayList<ExerciseWithSets>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final ExerciseWithSets _item;
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
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpSetsCollection_1 = _collectionSets.get(_tmpKey_1);
              if (_tmpSetsCollection_1 == null) {
                _tmpSetsCollection_1 = new ArrayList<Set>();
              }
              _item = new ExerciseWithSets(_tmpExercise,_tmpSetsCollection_1);
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
  public LiveData<List<ExerciseWithSets>> getTemplatesOrderByName() {
    final String _sql = "SELECT * FROM exercise WHERE workout is null ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","exercise"}, true, new Callable<List<ExerciseWithSets>>() {
      @Override
      public List<ExerciseWithSets> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
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
            final List<ExerciseWithSets> _result = new ArrayList<ExerciseWithSets>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final ExerciseWithSets _item;
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
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpSetsCollection_1 = _collectionSets.get(_tmpKey_1);
              if (_tmpSetsCollection_1 == null) {
                _tmpSetsCollection_1 = new ArrayList<Set>();
              }
              _item = new ExerciseWithSets(_tmpExercise,_tmpSetsCollection_1);
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
  public LiveData<List<ExerciseWithSets>> getCompleted() {
    final String _sql = "SELECT * FROM exercise WHERE workout is not null AND completed = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","exercise"}, true, new Callable<List<ExerciseWithSets>>() {
      @Override
      public List<ExerciseWithSets> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
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
            final List<ExerciseWithSets> _result = new ArrayList<ExerciseWithSets>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final ExerciseWithSets _item;
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
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpSetsCollection_1 = _collectionSets.get(_tmpKey_1);
              if (_tmpSetsCollection_1 == null) {
                _tmpSetsCollection_1 = new ArrayList<Set>();
              }
              _item = new ExerciseWithSets(_tmpExercise,_tmpSetsCollection_1);
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
  public LiveData<List<ExerciseWithSets>> getNonCompleted() {
    final String _sql = "SELECT * FROM exercise WHERE workout is not null AND completed = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","exercise"}, true, new Callable<List<ExerciseWithSets>>() {
      @Override
      public List<ExerciseWithSets> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
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
            final List<ExerciseWithSets> _result = new ArrayList<ExerciseWithSets>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final ExerciseWithSets _item;
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
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpSetsCollection_1 = _collectionSets.get(_tmpKey_1);
              if (_tmpSetsCollection_1 == null) {
                _tmpSetsCollection_1 = new ArrayList<Set>();
              }
              _item = new ExerciseWithSets(_tmpExercise,_tmpSetsCollection_1);
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
  public LiveData<List<ExerciseWithSets>> getAll() {
    final String _sql = "SELECT * FROM exercise";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Set","exercise"}, true, new Callable<List<ExerciseWithSets>>() {
      @Override
      public List<ExerciseWithSets> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
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
            final List<ExerciseWithSets> _result = new ArrayList<ExerciseWithSets>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final ExerciseWithSets _item;
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
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              _tmpSetsCollection_1 = _collectionSets.get(_tmpKey_1);
              if (_tmpSetsCollection_1 == null) {
                _tmpSetsCollection_1 = new ArrayList<Set>();
              }
              _item = new ExerciseWithSets(_tmpExercise,_tmpSetsCollection_1);
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
}
