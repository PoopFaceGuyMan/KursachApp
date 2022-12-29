package com.KursachApp.ui.workoutlist

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.KursachApp.R
import java.io.Serializable
import java.lang.UnsupportedOperationException
import java.util.UUID
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress

public class WorkoutListFragmentDirections private constructor() {
  private data class ActionNavWorkoutListToNavWorkoutDetails(
    public val workoutId: UUID
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_nav_workout_list_to_nav_workout_details

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(UUID::class.java)) {
        result.putParcelable("workoutId", this.workoutId as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(UUID::class.java)) {
        result.putSerializable("workoutId", this.workoutId as Serializable)
      } else {
        throw UnsupportedOperationException(UUID::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  private data class ActionNavWorkoutListToNavWorkoutDetailsFinal(
    public val workoutId: UUID? = null
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_nav_workout_list_to_nav_workout_details_final

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(UUID::class.java)) {
        result.putParcelable("workoutId", this.workoutId as Parcelable?)
      } else if (Serializable::class.java.isAssignableFrom(UUID::class.java)) {
        result.putSerializable("workoutId", this.workoutId as Serializable?)
      }
      return result
    }
  }

  private data class ActionNavWorkoutListToNavWorkoutViewPager(
    public val workoutId: UUID,
    public val pendingIntent: Boolean = false
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_nav_workout_list_to_nav_workout_view_pager

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(UUID::class.java)) {
        result.putParcelable("workoutId", this.workoutId as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(UUID::class.java)) {
        result.putSerializable("workoutId", this.workoutId as Serializable)
      } else {
        throw UnsupportedOperationException(UUID::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      result.putBoolean("pendingIntent", this.pendingIntent)
      return result
    }
  }

  public companion object {
    public fun actionNavWorkoutListToNavWorkoutDetails(workoutId: UUID): NavDirections =
        ActionNavWorkoutListToNavWorkoutDetails(workoutId)

    public fun actionNavWorkoutListToNavWorkoutDetailsFinal(workoutId: UUID? = null): NavDirections
        = ActionNavWorkoutListToNavWorkoutDetailsFinal(workoutId)

    public fun actionNavWorkoutListToNavWorkoutCreate(): NavDirections =
        ActionOnlyNavDirections(R.id.action_nav_workout_list_to_nav_workout_create)

    public fun actionNavWorkoutListToNavWorkoutViewPager(workoutId: UUID, pendingIntent: Boolean =
        false): NavDirections = ActionNavWorkoutListToNavWorkoutViewPager(workoutId, pendingIntent)
  }
}
