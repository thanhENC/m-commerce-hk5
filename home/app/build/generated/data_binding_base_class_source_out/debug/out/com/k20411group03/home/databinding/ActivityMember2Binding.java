// Generated by view binder compiler. Do not edit!
package com.k20411group03.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.k20411group03.home.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMember2Binding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnCancelsetting;

  @NonNull
  public final Button btnSavesetting;

  @NonNull
  public final EditText edtDiachicongtysetting;

  @NonNull
  public final EditText edtDiachinhasetting;

  @NonNull
  public final EditText edtEmailsetting;

  @NonNull
  public final EditText edtHosetting;

  @NonNull
  public final EditText edtNamesetting;

  @NonNull
  public final EditText edtSodienthoaisetting;

  @NonNull
  public final EditText edtTklienket;

  @NonNull
  public final ImageView imvBack;

  @NonNull
  public final TextView txtTitleGioHang;

  private ActivityMember2Binding(@NonNull LinearLayout rootView, @NonNull Button btnCancelsetting,
      @NonNull Button btnSavesetting, @NonNull EditText edtDiachicongtysetting,
      @NonNull EditText edtDiachinhasetting, @NonNull EditText edtEmailsetting,
      @NonNull EditText edtHosetting, @NonNull EditText edtNamesetting,
      @NonNull EditText edtSodienthoaisetting, @NonNull EditText edtTklienket,
      @NonNull ImageView imvBack, @NonNull TextView txtTitleGioHang) {
    this.rootView = rootView;
    this.btnCancelsetting = btnCancelsetting;
    this.btnSavesetting = btnSavesetting;
    this.edtDiachicongtysetting = edtDiachicongtysetting;
    this.edtDiachinhasetting = edtDiachinhasetting;
    this.edtEmailsetting = edtEmailsetting;
    this.edtHosetting = edtHosetting;
    this.edtNamesetting = edtNamesetting;
    this.edtSodienthoaisetting = edtSodienthoaisetting;
    this.edtTklienket = edtTklienket;
    this.imvBack = imvBack;
    this.txtTitleGioHang = txtTitleGioHang;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMember2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMember2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_member2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMember2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_cancelsetting;
      Button btnCancelsetting = ViewBindings.findChildViewById(rootView, id);
      if (btnCancelsetting == null) {
        break missingId;
      }

      id = R.id.btn_savesetting;
      Button btnSavesetting = ViewBindings.findChildViewById(rootView, id);
      if (btnSavesetting == null) {
        break missingId;
      }

      id = R.id.edt_diachicongtysetting;
      EditText edtDiachicongtysetting = ViewBindings.findChildViewById(rootView, id);
      if (edtDiachicongtysetting == null) {
        break missingId;
      }

      id = R.id.edt_diachinhasetting;
      EditText edtDiachinhasetting = ViewBindings.findChildViewById(rootView, id);
      if (edtDiachinhasetting == null) {
        break missingId;
      }

      id = R.id.edt_emailsetting;
      EditText edtEmailsetting = ViewBindings.findChildViewById(rootView, id);
      if (edtEmailsetting == null) {
        break missingId;
      }

      id = R.id.edt_hosetting;
      EditText edtHosetting = ViewBindings.findChildViewById(rootView, id);
      if (edtHosetting == null) {
        break missingId;
      }

      id = R.id.edt_namesetting;
      EditText edtNamesetting = ViewBindings.findChildViewById(rootView, id);
      if (edtNamesetting == null) {
        break missingId;
      }

      id = R.id.edt_sodienthoaisetting;
      EditText edtSodienthoaisetting = ViewBindings.findChildViewById(rootView, id);
      if (edtSodienthoaisetting == null) {
        break missingId;
      }

      id = R.id.edt_tklienket;
      EditText edtTklienket = ViewBindings.findChildViewById(rootView, id);
      if (edtTklienket == null) {
        break missingId;
      }

      id = R.id.imv_Back;
      ImageView imvBack = ViewBindings.findChildViewById(rootView, id);
      if (imvBack == null) {
        break missingId;
      }

      id = R.id.txt_TitleGioHang;
      TextView txtTitleGioHang = ViewBindings.findChildViewById(rootView, id);
      if (txtTitleGioHang == null) {
        break missingId;
      }

      return new ActivityMember2Binding((LinearLayout) rootView, btnCancelsetting, btnSavesetting,
          edtDiachicongtysetting, edtDiachinhasetting, edtEmailsetting, edtHosetting,
          edtNamesetting, edtSodienthoaisetting, edtTklienket, imvBack, txtTitleGioHang);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}