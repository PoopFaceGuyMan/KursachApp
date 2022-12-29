// Generated by view binder compiler. Do not edit!
package com.KursachApp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.KursachApp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProgressItemAltBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView attendance;

  @NonNull
  public final TextView attendancePercentage;

  @NonNull
  public final TextView reps;

  @NonNull
  public final TextView repsPercentage;

  @NonNull
  public final LinearLayout root;

  @NonNull
  public final TextView title;

  @NonNull
  public final TextView weights;

  @NonNull
  public final TextView weightsPercentage;

  private ProgressItemAltBinding(@NonNull LinearLayout rootView, @NonNull TextView attendance,
      @NonNull TextView attendancePercentage, @NonNull TextView reps,
      @NonNull TextView repsPercentage, @NonNull LinearLayout root, @NonNull TextView title,
      @NonNull TextView weights, @NonNull TextView weightsPercentage) {
    this.rootView = rootView;
    this.attendance = attendance;
    this.attendancePercentage = attendancePercentage;
    this.reps = reps;
    this.repsPercentage = repsPercentage;
    this.root = root;
    this.title = title;
    this.weights = weights;
    this.weightsPercentage = weightsPercentage;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ProgressItemAltBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProgressItemAltBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.progress_item_alt, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProgressItemAltBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.attendance;
      TextView attendance = rootView.findViewById(id);
      if (attendance == null) {
        break missingId;
      }

      id = R.id.attendance_percentage;
      TextView attendancePercentage = rootView.findViewById(id);
      if (attendancePercentage == null) {
        break missingId;
      }

      id = R.id.reps;
      TextView reps = rootView.findViewById(id);
      if (reps == null) {
        break missingId;
      }

      id = R.id.reps_percentage;
      TextView repsPercentage = rootView.findViewById(id);
      if (repsPercentage == null) {
        break missingId;
      }

      LinearLayout root = (LinearLayout) rootView;

      id = R.id.title;
      TextView title = rootView.findViewById(id);
      if (title == null) {
        break missingId;
      }

      id = R.id.weights;
      TextView weights = rootView.findViewById(id);
      if (weights == null) {
        break missingId;
      }

      id = R.id.weights_percentage;
      TextView weightsPercentage = rootView.findViewById(id);
      if (weightsPercentage == null) {
        break missingId;
      }

      return new ProgressItemAltBinding((LinearLayout) rootView, attendance, attendancePercentage,
          reps, repsPercentage, root, title, weights, weightsPercentage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}