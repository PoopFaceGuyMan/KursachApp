package com.KursachApp.ui.workoutdetailsfinal

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.UnsupportedOperationException
import java.util.UUID
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class WorkoutDetailsFinalFragmentArgs(
  public val workoutId: UUID? = null
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(UUID::class.java)) {
      result.putParcelable("workoutId", this.workoutId as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(UUID::class.java)) {
      result.putSerializable("workoutId", this.workoutId as Serializable?)
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): WorkoutDetailsFinalFragmentArgs {
      bundle.setClassLoader(WorkoutDetailsFinalFragmentArgs::class.java.classLoader)
      val __workoutId : UUID?
      if (bundle.containsKey("workoutId")) {
        if (Parcelable::class.java.isAssignableFrom(UUID::class.java) ||
            Serializable::class.java.isAssignableFrom(UUID::class.java)) {
          __workoutId = bundle.get("workoutId") as UUID?
        } else {
          throw UnsupportedOperationException(UUID::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __workoutId = null
      }
      return WorkoutDetailsFinalFragmentArgs(__workoutId)
    }
  }
}
