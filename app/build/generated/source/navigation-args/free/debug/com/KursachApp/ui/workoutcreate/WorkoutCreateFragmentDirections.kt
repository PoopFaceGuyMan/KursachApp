package com.KursachApp.ui.workoutcreate

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.KursachApp.R
import java.io.Serializable
import java.lang.UnsupportedOperationException
import java.util.UUID
import kotlin.Int
import kotlin.Suppress

public class WorkoutCreateFragmentDirections private constructor() {
  private data class ActionNavWorkoutCreateToNavExerciseImport(
    public val workoutId: UUID
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_nav_workout_create_to_nav_exercise_import

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

  private data class ActionNavWorkoutCreateToNavExerciseCreate(
    public val workoutId: UUID? = null
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_nav_workout_create_to_nav_exercise_create

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

  private data class ActionNavWorkoutCreateToNavExerciseDetails(
    public val exerciseId: UUID
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_nav_workout_create_to_nav_exercise_details

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
    public fun actionNavWorkoutCreateToNavExerciseImport(workoutId: UUID): NavDirections =
        ActionNavWorkoutCreateToNavExerciseImport(workoutId)

    public fun actionNavWorkoutCreateToNavExerciseCreate(workoutId: UUID? = null): NavDirections =
        ActionNavWorkoutCreateToNavExerciseCreate(workoutId)

    public fun actionNavWorkoutCreateToNavExerciseDetails(exerciseId: UUID): NavDirections =
        ActionNavWorkoutCreateToNavExerciseDetails(exerciseId)
  }
}
