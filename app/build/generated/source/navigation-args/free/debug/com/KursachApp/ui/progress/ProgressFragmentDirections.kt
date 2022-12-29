package com.KursachApp.ui.progress

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.KursachApp.R
import com.KursachApp.model.ProgressItem
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class ProgressFragmentDirections private constructor() {
  private data class ActionNavProgressToNavProgressDetails(
    public val progressItem: ProgressItem
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_nav_progress_to_nav_progress_details

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
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
  }

  public companion object {
    public fun actionNavProgressToNavProgressDetails(progressItem: ProgressItem): NavDirections =
        ActionNavProgressToNavProgressDetails(progressItem)
  }
}
