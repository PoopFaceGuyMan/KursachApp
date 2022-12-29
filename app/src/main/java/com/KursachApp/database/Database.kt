package com.KursachApp.database

import androidx.room.*
import androidx.room.Database
import com.KursachApp.database.dao.*
import com.KursachApp.model.*
import com.KursachApp.model.Set

@Database(
    entities = [ Set::class, Exercise::class, Workout::class ],
    version = 1,
    exportSchema = true
)
@TypeConverters(TypeConverter::class)
abstract class Database : RoomDatabase() {

    abstract fun setDao() : SetDao

    abstract fun exerciseDao(): ExerciseDao

    abstract fun workoutDao(): WorkoutDao

    abstract fun exerciseWithSetsDao(): ExerciseWithSetsDao

    abstract fun workoutWithExercisesDao(): WorkoutWithExercisesDao
}