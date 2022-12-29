package com.KursachApp.ui.exercisecreate

import java.util.*
import androidx.lifecycle.*
import com.KursachApp.model.ExerciseWithSets
import com.KursachApp.ui.AbstractExerciseEditViewModel

class ExerciseCreateViewModel(private val state: SavedStateHandle):
    AbstractExerciseEditViewModel(state) {

    override val TAG = "ExerciseCreateViewModel"

    fun loadExercise(workoutId: UUID?) {
        if (state.contains(EXERCISE_ID_LIVE_DATA_KEY)) {
            return
        } else {
            val exercise = ExerciseWithSets.newInstance(workoutId)
            repository.saveExercise(exercise.exercise)
            exerciseIdLiveData.value = exercise.exercise.id
        }
    }

    fun deleteExercise(exercise: ExerciseWithSets) {
        repository.deleteExercise(exercise.exercise)
        repository.deleteSet(exercise.sets)
    }
}