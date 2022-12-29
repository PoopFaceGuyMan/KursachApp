package com.KursachApp.ui.exercisedetails

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import java.util.UUID
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class ExerciseDetailsFragmentArgs(
  public val exerciseId: UUID
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ExerciseDetailsFragmentArgs {
      bundle.setClassLoader(ExerciseDetailsFragmentArgs::class.java.classLoader)
      val __exerciseId : UUID?
      if (bundle.containsKey("exerciseId")) {
        if (Parcelable::class.java.isAssignableFrom(UUID::class.java) ||
            Serializable::class.java.isAssignableFrom(UUID::class.java)) {
          __exerciseId = bundle.get("exerciseId") as UUID?
        } else {
          throw UnsupportedOperationException(UUID::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__exerciseId == null) {
          throw IllegalArgumentException("Argument \"exerciseId\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"exerciseId\" is missing and does not have an android:defaultValue")
      }
      return ExerciseDetailsFragmentArgs(__exerciseId)
    }
  }
}
