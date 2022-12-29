package com.KursachApp.ui.progressdetails

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.KursachApp.model.ProgressItem
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class ProgressDetailsFragmentArgs(
  public val progressItem: ProgressItem
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(ProgressItem::class.java)) {
      result.putParcelable("progressItem", this.progressItem as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(ProgressItem::class.java)) {
      result.putSerializable("progressItem", this.progressItem as Serializable)
    } else {
      throw UnsupportedOperationException(ProgressItem::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ProgressDetailsFragmentArgs {
      bundle.setClassLoader(ProgressDetailsFragmentArgs::class.java.classLoader)
      val __progressItem : ProgressItem?
      if (bundle.containsKey("progressItem")) {
        if (Parcelable::class.java.isAssignableFrom(ProgressItem::class.java) ||
            Serializable::class.java.isAssignableFrom(ProgressItem::class.java)) {
          __progressItem = bundle.get("progressItem") as ProgressItem?
        } else {
          throw UnsupportedOperationException(ProgressItem::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__progressItem == null) {
          throw IllegalArgumentException("Argument \"progressItem\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"progressItem\" is missing and does not have an android:defaultValue")
      }
      return ProgressDetailsFragmentArgs(__progressItem)
    }
  }
}
