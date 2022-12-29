package com.KursachApp.ui.home.last

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.KursachApp.R
import com.KursachApp.ui.home.AbstractWorkoutOverviewFragment
import com.KursachApp.ui.home.AbstractWorkoutOverviewViewModel

class LastWorkoutOverviewFragment : AbstractWorkoutOverviewFragment() {

    override val vm: AbstractWorkoutOverviewViewModel by viewModels<LastWorkoutOverviewViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title.text = resources.getString(R.string.last_workout_title)
    }

    companion object {

        fun newInstance(): LastWorkoutOverviewFragment {
            return LastWorkoutOverviewFragment()
        }
    }
}