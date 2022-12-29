package com.KursachApp.ui.exerciselist

import android.util.Log
import androidx.lifecycle.*
import com.KursachApp.database.Repository
import com.KursachApp.model.ExerciseWithSets

private const val TAG = "ExerciseListViewModel"

class ExerciseListViewModel(private val state: SavedStateHandle): ViewModel() {

    private val repository = Repository.get()

    val exerciseListLiveData: LiveData<List<ExerciseWithSets>> =
        repository.getOrderedTemplateExercisesWithSets()
            .apply {
                distinctUntilChanged()
            }

    fun saveExercise(exercise: ExerciseWithSets) {
        repository.saveExercise(exercise.exercise)
        repository.saveSet(exercise.sets)
    }

    fun deleteExercise(exercise: ExerciseWithSets) {
        Log.i(TAG, "Deleting: ${exercise.exercise.id}")
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