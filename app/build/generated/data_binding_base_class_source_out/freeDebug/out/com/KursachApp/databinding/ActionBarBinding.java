// Generated by view binder compiler. Do not edit!
package com.KursachApp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.KursachApp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActionBarBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout actionBar;

  @NonNull
  public final Button delete;

  @NonNull
  public final Button edit;

  private ActionBarBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout actionBar,
      @NonNull Button delete, @NonNull Button edit) {
    this.rootView = rootView;
    this.actionBar = actionBar;
    this.delete = delete;
    this.edit = edit;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActionBarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActionBarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.action_bar, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActionBarBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      LinearLayout actionBar = (LinearLayout) rootView;

      id = R.id.delete;
      Button delete = rootView.findViewById(id);
      if (delete == null) {
        break missingId;
      }

      id = R.id.edit;
      Button edit = rootView.findViewById(id);
      if (edit == null) {
        break missingId;
      }

      return new ActionBarBinding((LinearLayout) rootView, actionBar, delete, edit);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}