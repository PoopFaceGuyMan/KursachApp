// Generated by view binder compiler. Do not edit!
package com.KursachApp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.KursachApp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentWorkoutStopwatchBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final StopwatchButtonBar0Binding buttonBar0;

  @NonNull
  public final StopwatchButtonBar1Binding buttonBar1;

  @NonNull
  public final StopwatchButtonBar2Binding buttonBar2;

  @NonNull
  public final TextView i0;

  @NonNull
  public final TextView i1;

  @NonNull
  public final TextView i2;

  @NonNull
  public final TextView i3;

  @NonNull
  public final TextView i4;

  @NonNull
  public final TextView i5;

  @NonNull
  public final TextView i6;

  @NonNull
  public final LinearLayout padding;

  @NonNull
  public final ViewFlipper vf;

  private FragmentWorkoutStopwatchBinding(@NonNull LinearLayout rootView,
      @NonNull StopwatchButtonBar0Binding buttonBar0,
      @NonNull StopwatchButtonBar1Binding buttonBar1,
      @NonNull StopwatchButtonBar2Binding buttonBar2, @NonNull TextView i0, @NonNull TextView i1,
      @NonNull TextView i2, @NonNull TextView i3, @NonNull TextView i4, @NonNull TextView i5,
      @NonNull TextView i6, @NonNull LinearLayout padding, @NonNull ViewFlipper vf) {
    this.rootView = rootView;
    this.buttonBar0 = buttonBar0;
    this.buttonBar1 = buttonBar1;
    this.buttonBar2 = buttonBar2;
    this.i0 = i0;
    this.i1 = i1;
    this.i2 = i2;
    this.i3 = i3;
    this.i4 = i4;
    this.i5 = i5;
    this.i6 = i6;
    this.padding = padding;
    this.vf = vf;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentWorkoutStopwatchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentWorkoutStopwatchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_workout_stopwatch, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentWorkoutStopwatchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_bar_0;
      View buttonBar0 = rootView.findViewById(id);
      if (buttonBar0 == null) {
        break missingId;
      }
      StopwatchButtonBar0Binding binding_buttonBar0 = StopwatchButtonBar0Binding.bind(buttonBar0);

      id = R.id.button_bar_1;
      View buttonBar1 = rootView.findViewById(id);
      if (buttonBar1 == null) {
        break missingId;
      }
      StopwatchButtonBar1Binding binding_buttonBar1 = StopwatchButtonBar1Binding.bind(buttonBar1);

      id = R.id.button_bar_2;
      View buttonBar2 = rootView.findViewById(id);
      if (buttonBar2 == null) {
        break missingId;
      }
      StopwatchButtonBar2Binding binding_buttonBar2 = StopwatchButtonBar2Binding.bind(buttonBar2);

      id = R.id.i0;
      TextView i0 = rootView.findViewById(id);
      if (i0 == null) {
        break missingId;
      }

      id = R.id.i1;
      TextView i1 = rootView.findViewById(id);
      if (i1 == null) {
        break missingId;
      }

      id = R.id.i2;
      TextView i2 = rootView.findViewById(id);
      if (i2 == null) {
        break missingId;
      }

      id = R.id.i3;
      TextView i3 = rootView.findViewById(id);
      if (i3 == null) {
        break missingId;
      }

      id = R.id.i4;
      TextView i4 = rootView.findViewById(id);
      if (i4 == null) {
        break missingId;
      }

      id = R.id.i5;
      TextView i5 = rootView.findViewById(id);
      if (i5 == null) {
        break missingId;
      }

      id = R.id.i6;
      TextView i6 = rootView.findViewById(id);
      if (i6 == null) {
        break missingId;
      }

      id = R.id.padding;
      LinearLayout padding = rootView.findViewById(id);
      if (padding == null) {
        break missingId;
      }

      id = R.id.vf;
      ViewFlipper vf = rootView.findViewById(id);
      if (vf == null) {
        break missingId;
      }

      return new FragmentWorkoutStopwatchBinding((LinearLayout) rootView, binding_buttonBar0,
          binding_buttonBar1, binding_buttonBar2, i0, i1, i2, i3, i4, i5, i6, padding, vf);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}