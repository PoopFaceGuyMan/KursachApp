package com.KursachApp.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.KursachApp.database.dao.ExerciseDao;
import com.KursachApp.database.dao.ExerciseDao_Impl;
import com.KursachApp.database.dao.ExerciseWithSetsDao;
import com.KursachApp.database.dao.ExerciseWithSetsDao_Impl;
import com.KursachApp.database.dao.SetDao;
import com.KursachApp.database.dao.SetDao_Impl;
import com.KursachApp.database.dao.WorkoutDao;
import com.KursachApp.database.dao.WorkoutDao_Impl;
import com.KursachApp.database.dao.WorkoutWithExercisesDao;
import com.KursachApp.database.dao.WorkoutWithExercisesDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class Database_Impl extends Database {
  private volatile SetDao _setDao;

  private volatile ExerciseDao _exerciseDao;

  private volatile WorkoutDao _workoutDao;

  private volatile ExerciseWithSetsDao _exerciseWithSetsDao;

  private volatile WorkoutWithExercisesDao _workoutWithExercisesDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Set` (`id` TEXT NOT NULL, `weights` REAL NOT NULL, `reps` INTEGER NOT NULL, `completed` INTEGER NOT NULL, `exercise` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`exercise`) REFERENCES `Exercise`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_Set_exercise` ON `Set` (`exercise`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Exercise` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `completed` INTEGER NOT NULL, `workout` TEXT, PRIMARY KEY(`id`), FOREIGN KEY(`workout`) REFERENCES `Workout`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_Exercise_workout` ON `Exercise` (`workout`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Workout` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `date` INTEGER, `reminder` INTEGER, `completed` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e3c20dd2123b44d6e3fd6c75e6d1aad3')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Set`");
        _db.execSQL("DROP TABLE IF EXISTS `Exercise`");
        _db.execSQL("DROP TABLE IF EXISTS `Workout`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsSet = new HashMap<String, TableInfo.Column>(5);
        _columnsSet.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSet.put("weights", new TableInfo.Column("weights", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSet.put("reps", new TableInfo.Column("reps", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSet.put("completed", new TableInfo.Column("completed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSet.put("exercise", new TableInfo.Column("exercise", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSet = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSet.add(new TableInfo.ForeignKey("Exercise", "CASCADE", "NO ACTION",Arrays.asList("exercise"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesSet = new HashSet<TableInfo.Index>(1);
        _indicesSet.add(new TableInfo.Index("index_Set_exercise", false, Arrays.asList("exercise")));
        final TableInfo _infoSet = new TableInfo("Set", _columnsSet, _foreignKeysSet, _indicesSet);
        final TableInfo _existingSet = TableInfo.read(_db, "Set");
        if (! _infoSet.equals(_existingSet)) {
          return new RoomOpenHelper.ValidationResult(false, "Set(com.KursachApp.model.Set).\n"
                  + " Expected:\n" + _infoSet + "\n"
                  + " Found:\n" + _existingSet);
        }
        final HashMap<String, TableInfo.Column> _columnsExercise = new HashMap<String, TableInfo.Column>(4);
        _columnsExercise.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercise.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercise.put("completed", new TableInfo.Column("completed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercise.put("workout", new TableInfo.Column("workout", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExercise = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysExercise.add(new TableInfo.ForeignKey("Workout", "CASCADE", "NO ACTION",Arrays.asList("workout"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesExercise = new HashSet<TableInfo.Index>(1);
        _indicesExercise.add(new TableInfo.Index("index_Exercise_workout", false, Arrays.asList("workout")));
        final TableInfo _infoExercise = new TableInfo("Exercise", _columnsExercise, _foreignKeysExercise, _indicesExercise);
        final TableInfo _existingExercise = TableInfo.read(_db, "Exercise");
        if (! _infoExercise.equals(_existingExercise)) {
          return new RoomOpenHelper.ValidationResult(false, "Exercise(com.KursachApp.model.Exercise).\n"
                  + " Expected:\n" + _infoExercise + "\n"
                  + " Found:\n" + _existingExercise);
        }
        final HashMap<String, TableInfo.Column> _columnsWorkout = new HashMap<String, TableInfo.Column>(5);
        _columnsWorkout.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("date", new TableInfo.Column("date", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("reminder", new TableInfo.Column("reminder", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkout.put("completed", new TableInfo.Column("completed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkout = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWorkout = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkout = new TableInfo("Workout", _columnsWorkout, _foreignKeysWorkout, _indicesWorkout);
        final TableInfo _existingWorkout = TableInfo.read(_db, "Workout");
        if (! _infoWorkout.equals(_existingWorkout)) {
          return new RoomOpenHelper.ValidationResult(false, "Workout(com.KursachApp.model.Workout).\n"
                  + " Expected:\n" + _infoWorkout + "\n"
                  + " Found:\n" + _existingWorkout);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "e3c20dd2123b44d6e3fd6c75e6d1aad3", "ff7321b5cbdc070f66424d897dacc1ee");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Set","Exercise","Workout");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `Set`");
      _db.execSQL("DELETE FROM `Exercise`");
      _db.execSQL("DELETE FROM `Workout`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(SetDao.class, SetDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ExerciseDao.class, ExerciseDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WorkoutDao.class, WorkoutDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ExerciseWithSetsDao.class, ExerciseWithSetsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WorkoutWithExercisesDao.class, WorkoutWithExercisesDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  protected Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  protected List<Migration> getAutoMigrations() {
    return Arrays.asList();
  }

  @Override
  public SetDao setDao() {
    if (_setDao != null) {
      return _setDao;
    } else {
      synchronized(this) {
        if(_setDao == null) {
          _setDao = new SetDao_Impl(this);
        }
        return _setDao;
      }
    }
  }

  @Override
  public ExerciseDao exerciseDao() {
    if (_exerciseDao != null) {
      return _exerciseDao;
    } else {
      synchronized(this) {
        if(_exerciseDao == null) {
          _exerciseDao = new ExerciseDao_Impl(this);
        }
        return _exerciseDao;
      }
    }
  }

  @Override
  public WorkoutDao workoutDao() {
    if (_workoutDao != null) {
      return _workoutDao;
    } else {
      synchronized(this) {
        if(_workoutDao == null) {
          _workoutDao = new WorkoutDao_Impl(this);
        }
        return _workoutDao;
      }
    }
  }

  @Override
  public ExerciseWithSetsDao exerciseWithSetsDao() {
    if (_exerciseWithSetsDao != null) {
      return _exerciseWithSetsDao;
    } else {
      synchronized(this) {
        if(_exerciseWithSetsDao == null) {
          _exerciseWithSetsDao = new ExerciseWithSetsDao_Impl(this);
        }
        return _exerciseWithSetsDao;
      }
    }
  }

  @Override
  public WorkoutWithExercisesDao workoutWithExercisesDao() {
    if (_workoutWithExercisesDao != null) {
      return _workoutWithExercisesDao;
    } else {
      synchronized(this) {
        if(_workoutWithExercisesDao == null) {
          _workoutWithExercisesDao = new WorkoutWithExercisesDao_Impl(this);
        }
        return _workoutWithExercisesDao;
      }
    }
  }
}
