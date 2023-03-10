package com.KursachApp.ui.workoutdetails

import android.util.Log
import androidx.lifecycle.*
import com.KursachApp.database.Repository
import com.KursachApp.model.ExerciseWithSets
import com.KursachApp.model.WorkoutWithExercises
import java.util.*

private const val TAG = "WorkoutDetailsViewModel"
private const val WORKOUT_ID_LIVE_DATA_KEY = "WorkoutIdLiveData"
private const val DATE_KEY = "Date"

class WorkoutDetailsViewModel(private val state: SavedStateHandle): ViewModel() {

    private val repository = Repository.get()

    private val workoutIdLiveData = state.getLiveData<UUID>(WORKOUT_ID_LIVE_DATA_KEY)

    var workoutLiveData: LiveData<WorkoutWithExercises?> = (
            Transformations.switchMap(workoutIdLiveData) { workoutLiveData ->
                repository.getWorkoutWithExercises(workoutLiveData)
            })
        .distinctUntilChanged()

    var date: String? = state.get<String?>(DATE_KEY)
        set(value) {
            state.set(DATE_KEY, value)
            field = value
        }

    fun loadWorkout(workoutId: UUID) {
        Log.i(TAG, "Loading: $workoutId")
        workoutIdLiveData.value = workoutId
    }

    fun saveWorkout(workout: WorkoutWithExercises) {
        Log.i(TAG, "Saving: ${workout.workout.id}")
        repository.saveWorkout(workout.workout)
        workout.exercises.forEach { exercise ->
            repository.saveExercise(exercise.exercise)
            repository.saveSet(exercise.sets)
        }
    }

    fun saveExercise(exercise: ExerciseWithSets) {
        repository.saveExercise(exercise.exercise)
        repository.saveSet(exercise.sets)
    }

    fun deleteWorkout(workout: WorkoutWithExercises) {
        Log.i(TAG, "Deleting: ${workout.workout.id}")
        repository.deleteWorkout(workout.workout)
        workout.exercises.forEach { exercise ->
            repository.deleteExercise(exercise.exercise)
            repository.deleteSet(exercise.sets)
        }
    }

    fun deleteExercise(exercise: ExerciseWithSets) {
        Log.i(TAG, "Deleting exercise: ${exercise.exercise.id}")
        repository.deleteExercise(exercise.exercise)
        repository.deleteSet(exercise.sets)
    }

    fun deleteExercises(exercises: List<ExerciseWithSets>) {
        exercises.forEach { exercise ->
            repository.deleteExercise(exercise.exercise)
            repository.deleteSet(exercise.sets)
        }
    }
}