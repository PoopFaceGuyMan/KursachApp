package com.KursachApp.ui.home.last

import androidx.lifecycle.LiveData
import androidx.lifecycle.distinctUntilChanged
import com.KursachApp.database.Repository
import com.KursachApp.model.WorkoutWithExercises
import com.KursachApp.ui.home.AbstractWorkoutOverviewViewModel

class LastWorkoutOverviewViewModel : AbstractWorkoutOverviewViewModel() {

    private val repository = Repository.get()

    override val workoutLiveData: LiveData<WorkoutWithExercises?> = (
            repository.getLastWorkoutWithExercises()
            )
        .distinctUntilChanged()

}