package com.KursachApp.ui.workoutdetails

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.KursachApp.R
import java.io.Serializable
import java.lang.UnsupportedOperationException
import java.util.UUID
import kotlin.Int
import kotlin.Suppress

public class WorkoutDetailsFragmentDirections private constructor() {
  private data class ActionNavWorkoutDetailsToNavExerciseImport(
    public val workoutId: UUID
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_nav_workout_details_to_nav_exercise_import

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

  private data class ActionNavWorkoutDetailsToNavExerciseCreate(
    public val workoutId: UUID? = null
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_nav_workout_details_to_nav_exercise_create

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

  private data class ActionNavWorkoutDetailsToNavExerciseDetails(
    public val exerciseId: UUID
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_nav_workout_details_to_nav_exercise_details

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(UUID::class.java)) {
        result.putParcelable("exerciseId", this.exerciseId as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(UUID::class.java)) {
        result.putSerializable("exerciseId", this.exerciseId as Serializable)
      } else {
        throw UnsupportedOperationException(UUID::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  public companion object {
    public fun actionNavWorkoutDetailsToNavExerciseImport(workoutId: UUID): NavDirections =
        ActionNavWorkoutDetailsToNavExerciseImport(workoutId)

    public fun actionNavWorkoutDetailsToNavExerciseCreate(workoutId: UUID? = null): NavDirections =
        ActionNavWorkoutDetailsToNavExerciseCreate(workoutId)

    public fun actionNavWorkoutDetailsToNavExerciseDetails(exerciseId: UUID): NavDirections =
        ActionNavWorkoutDetailsToNavExerciseDetails(exerciseId)
  }
}
