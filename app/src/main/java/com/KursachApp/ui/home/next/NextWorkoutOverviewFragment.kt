package com.KursachApp.ui.home.next

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.KursachApp.R
import com.KursachApp.ui.home.AbstractWorkoutOverviewFragment
import com.KursachApp.ui.home.AbstractWorkoutOverviewViewModel

class NextWorkoutOverviewFragment : AbstractWorkoutOverviewFragment() {

    override val vm: AbstractWorkoutOverviewViewModel by viewModels<NextWorkoutOverviewViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title.text = resources.getString(R.string.next_workout_title)
        binding.chronometer.isCountDown = true
    }

    companion object {

        fun newInstance(): NextWorkoutOverviewFragment {
            return NextWorkoutOverviewFragment()
        }
    }
}