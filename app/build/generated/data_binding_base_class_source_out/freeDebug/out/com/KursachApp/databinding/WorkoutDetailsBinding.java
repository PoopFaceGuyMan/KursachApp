// Generated by view binder compiler. Do not edit!
package com.KursachApp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import com.KursachApp.R;
import com.KursachApp.widget.AutoFitRecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class WorkoutDetailsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppCompatEditText date;

  @NonNull
  public final TextInputLayout dateLayout;

  @NonNull
  public final AutoCompleteTextView dropdown;

  @NonNull
  public final TextInputLayout dropdownLayout;

  @NonNull
  public final TextInputEditText name;

  @NonNull
  public final AutoFitRecyclerView recyclerView;

  private WorkoutDetailsBinding(@NonNull LinearLayout rootView, @NonNull AppCompatEditText date,
      @NonNull TextInputLayout dateLayout, @NonNull AutoCompleteTextView dropdown,
      @NonNull TextInputLayout dropdownLayout, @NonNull TextInputEditText name,
      @NonNull AutoFitRecyclerView recyclerView) {
    this.rootView = rootView;
    this.date = date;
    this.dateLayout = dateLayout;
    this.dropdown = dropdown;
    this.dropdownLayout = dropdownLayout;
    this.name = name;
    this.recyclerView = recyclerView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static WorkoutDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static WorkoutDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.workout_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static WorkoutDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.date;
      AppCompatEditText date = rootView.findViewById(id);
      if (date == null) {
        break missingId;
      }

      id = R.id.date_layout;
      TextInputLayout dateLayout = rootView.findViewById(id);
      if (dateLayout == null) {
        break missingId;
      }

      id = R.id.dropdown;
      AutoCompleteTextView dropdown = rootView.findViewById(id);
      if (dropdown == null) {
        break missingId;
      }

      id = R.id.dropdown_layout;
      TextInputLayout dropdownLayout = rootView.findViewById(id);
      if (dropdownLayout == null) {
        break missingId;
      }

      id = R.id.name;
      TextInputEditText name = rootView.findViewById(id);
      if (name == null) {
        break missingId;
      }

      id = R.id.recycler_view;
      AutoFitRecyclerView recyclerView = rootView.findViewById(id);
      if (recyclerView == null) {
        break missingId;
      }

      return new WorkoutDetailsBinding((LinearLayout) rootView, date, dateLayout, dropdown,
          dropdownLayout, name, recyclerView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}