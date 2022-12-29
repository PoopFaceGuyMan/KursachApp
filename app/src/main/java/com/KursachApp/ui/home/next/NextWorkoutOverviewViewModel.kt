package com.KursachApp.ui.home.next

import androidx.lifecycle.LiveData
import androidx.lifecycle.distinctUntilChanged
import com.KursachApp.database.Repository
import com.KursachApp.model.WorkoutWithExercises
import com.KursachApp.ui.home.AbstractWorkoutOverviewViewModel

class NextWorkoutOverviewViewModel: AbstractWorkoutOverviewViewModel() {

    private val repository = Repository.get()

    override val workoutLiveData: LiveData<WorkoutWithExercises?> = (
            repository.getNextWorkoutWithExercises()
            )
        .distinctUntilChanged()
}