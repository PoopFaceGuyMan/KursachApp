package com.KursachApp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.KursachApp.model.WorkoutWithExercises

abstract class AbstractWorkoutOverviewViewModel: ViewModel() {

    abstract val workoutLiveData: LiveData<WorkoutWithExercises?>
}