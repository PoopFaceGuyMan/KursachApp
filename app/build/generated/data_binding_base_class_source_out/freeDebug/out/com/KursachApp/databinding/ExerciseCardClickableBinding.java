// Generated by view binder compiler. Do not edit!
package com.KursachApp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.KursachApp.R;
import com.KursachApp.widget.InterceptTouchCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ExerciseCardClickableBinding implements ViewBinding {
  @NonNull
  private final InterceptTouchCardView rootView;

  @NonNull
  public final CheckMarkBinding back;

  @NonNull
  public final ExerciseBinding body;

  @NonNull
  public final InterceptTouchCardView cardView;

  private ExerciseCardClickableBinding(@NonNull InterceptTouchCardView rootView,
      @NonNull CheckMarkBinding back, @NonNull ExerciseBinding body,
      @NonNull InterceptTouchCardView cardView) {
    this.rootView = rootView;
    this.back = back;
    this.body = body;
    this.cardView = cardView;
  }

  @Override
  @NonNull
  public InterceptTouchCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ExerciseCardClickableBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ExerciseCardClickableBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.exercise_card_clickable, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ExerciseCardClickableBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back;
      View back = rootView.findViewById(id);
      if (back == null) {
        break missingId;
      }
      CheckMarkBinding binding_back = CheckMarkBinding.bind(back);

      id = R.id.body;
      View body = rootView.findViewById(id);
      if (body == null) {
        break missingId;
      }
      ExerciseBinding binding_body = ExerciseBinding.bind(body);

      InterceptTouchCardView cardView = (InterceptTouchCardView) rootView;

      return new ExerciseCardClickableBinding((InterceptTouchCardView) rootView, binding_back,
          binding_body, cardView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
