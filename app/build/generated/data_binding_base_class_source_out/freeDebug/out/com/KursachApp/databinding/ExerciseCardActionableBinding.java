// Generated by view binder compiler. Do not edit!
package com.KursachApp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.KursachApp.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ExerciseCardActionableBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final ActionBarBinding actionBar;

  @NonNull
  public final ExerciseBinding body;

  @NonNull
  public final MaterialCardView cardView;

  @NonNull
  public final LinearLayout empty;

  private ExerciseCardActionableBinding(@NonNull MaterialCardView rootView,
      @NonNull ActionBarBinding actionBar, @NonNull ExerciseBinding body,
      @NonNull MaterialCardView cardView, @NonNull LinearLayout empty) {
    this.rootView = rootView;
    this.actionBar = actionBar;
    this.body = body;
    this.cardView = cardView;
    this.empty = empty;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ExerciseCardActionableBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ExerciseCardActionableBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.exercise_card_actionable, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ExerciseCardActionableBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.action_bar;
      View actionBar = rootView.findViewById(id);
      if (actionBar == null) {
        break missingId;
      }
      ActionBarBinding binding_actionBar = ActionBarBinding.bind(actionBar);

      id = R.id.body;
      View body = rootView.findViewById(id);
      if (body == null) {
        break missingId;
      }
      ExerciseBinding binding_body = ExerciseBinding.bind(body);

      MaterialCardView cardView = (MaterialCardView) rootView;

      id = R.id.empty;
      LinearLayout empty = rootView.findViewById(id);
      if (empty == null) {
        break missingId;
      }

      return new ExerciseCardActionableBinding((MaterialCardView) rootView, binding_actionBar,
          binding_body, cardView, empty);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
