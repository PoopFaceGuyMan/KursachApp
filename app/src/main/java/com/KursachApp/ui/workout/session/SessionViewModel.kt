package com.KursachApp.ui.workout.session

import java.util.*
import androidx.lifecycle.*
import com.KursachApp.database.Repository
import com.KursachApp.model.*

private const val TAG = "WorkoutViewModel"
private const val WORKOUT_ID_LIVE_DATA_KEY = "WorkoutIdLiveData"

class SessionViewModel(private val state: SavedStateHandle) : ViewModel() {

    private val repository = Repository.get()

    private val workoutIdLiveData = state.getLiveData<UUID>(WORKOUT_ID_LIVE_DATA_KEY)

    val workoutLiveData: LiveData<WorkoutWithExercises?> = (
            Transformations.switchMap(workoutIdLiveData) { workoutId ->
                repository.getWorkoutWithExercises(workoutId)
            })
        .distinctUntilChanged()

    fun loadWorkout(workoutId: UUID) {
        workoutIdLiveData.value = workoutId
    }

    fun saveWorkout(workout: WorkoutWithExercises) {
        repository.saveWorkout(workout.workout)
        workout.exercises.forEach { exercise ->
            repository.saveExercise(exercise.exercise)
            repository.saveSet(exercise.sets)
        }
    }
}