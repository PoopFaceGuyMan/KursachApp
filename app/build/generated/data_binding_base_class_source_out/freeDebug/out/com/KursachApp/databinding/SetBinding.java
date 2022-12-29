// Generated by view binder compiler. Do not edit!
package com.KursachApp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.KursachApp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SetBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextInputEditText reps;

  @NonNull
  public final TextInputLayout repsLayout;

  @NonNull
  public final ConstraintLayout root;

  @NonNull
  public final TextInputEditText weights;

  @NonNull
  public final TextInputLayout weightsLayout;

  private SetBinding(@NonNull ConstraintLayout rootView, @NonNull TextInputEditText reps,
      @NonNull TextInputLayout repsLayout, @NonNull ConstraintLayout root,
      @NonNull TextInputEditText weights, @NonNull TextInputLayout weightsLayout) {
    this.rootView = rootView;
    this.reps = reps;
    this.repsLayout = repsLayout;
    this.root = root;
    this.weights = weights;
    this.weightsLayout = weightsLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SetBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.set, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.reps;
      TextInputEditText reps = rootView.findViewById(id);
      if (reps == null) {
        break missingId;
      }

      id = R.id.reps_layout;
      TextInputLayout repsLayout = rootView.findViewById(id);
      if (repsLayout == null) {
        break missingId;
      }

      ConstraintLayout root = (ConstraintLayout) rootView;

      id = R.id.weights;
      TextInputEditText weights = rootView.findViewById(id);
      if (weights == null) {
        break missingId;
      }

      id = R.id.weights_layout;
      TextInputLayout weightsLayout = rootView.findViewById(id);
      if (weightsLayout == null) {
        break missingId;
      }

      return new SetBinding((ConstraintLayout) rootView, reps, repsLayout, root, weights,
          weightsLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}