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

public final class ActivityDiachinhanhangBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnConfirmaddress;

  @NonNull
  public final EditText edtDistrict;

  @NonNull
  public final EditText edtFirstname;

  @NonNull
  public final EditText edtNoteaddress;

  @NonNull
  public final EditText edtPhone;

  @NonNull
  public final EditText edtProvince;

  @NonNull
  public final EditText edtStreet;

  @NonNull
  public final EditText edtSurname;

  @NonNull
  public final EditText edtWard;

  @NonNull
  public final ImageView imvBack;

  @NonNull
  public final TextView txtTitleGioHang;

  private ActivityDiachinhanhangBinding(@NonNull LinearLayout rootView,
      @NonNull Button btnConfirmaddress, @NonNull EditText edtDistrict,
      @NonNull EditText edtFirstname, @NonNull EditText edtNoteaddress, @NonNull EditText edtPhone,
      @NonNull EditText edtProvince, @NonNull EditText edtStreet, @NonNull EditText edtSurname,
      @NonNull EditText edtWard, @NonNull ImageView imvBack, @NonNull TextView txtTitleGioHang) {
    this.rootView = rootView;
    this.btnConfirmaddress = btnConfirmaddress;
    this.edtDistrict = edtDistrict;
    this.edtFirstname = edtFirstname;
    this.edtNoteaddress = edtNoteaddress;
    this.edtPhone = edtPhone;
    this.edtProvince = edtProvince;
    this.edtStreet = edtStreet;
    this.edtSurname = edtSurname;
    this.edtWard = edtWard;
    this.imvBack = imvBack;
    this.txtTitleGioHang = txtTitleGioHang;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDiachinhanhangBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDiachinhanhangBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_diachinhanhang, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDiachinhanhangBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_confirmaddress;
      Button btnConfirmaddress = ViewBindings.findChildViewById(rootView, id);
      if (btnConfirmaddress == null) {
        break missingId;
      }

      id = R.id.edt_district;
      EditText edtDistrict = ViewBindings.findChildViewById(rootView, id);
      if (edtDistrict == null) {
        break missingId;
      }

      id = R.id.edt_firstname;
      EditText edtFirstname = ViewBindings.findChildViewById(rootView, id);
      if (edtFirstname == null) {
        break missingId;
      }

      id = R.id.edt_noteaddress;
      EditText edtNoteaddress = ViewBindings.findChildViewById(rootView, id);
      if (edtNoteaddress == null) {
        break missingId;
      }

      id = R.id.edt_phone;
      EditText edtPhone = ViewBindings.findChildViewById(rootView, id);
      if (edtPhone == null) {
        break missingId;
      }

      id = R.id.edt_province;
      EditText edtProvince = ViewBindings.findChildViewById(rootView, id);
      if (edtProvince == null) {
        break missingId;
      }

      id = R.id.edt_street;
      EditText edtStreet = ViewBindings.findChildViewById(rootView, id);
      if (edtStreet == null) {
        break missingId;
      }

      id = R.id.edt_surname;
      EditText edtSurname = ViewBindings.findChildViewById(rootView, id);
      if (edtSurname == null) {
        break missingId;
      }

      id = R.id.edt_ward;
      EditText edtWard = ViewBindings.findChildViewById(rootView, id);
      if (edtWard == null) {
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

      return new ActivityDiachinhanhangBinding((LinearLayout) rootView, btnConfirmaddress,
          edtDistrict, edtFirstname, edtNoteaddress, edtPhone, edtProvince, edtStreet, edtSurname,
          edtWard, imvBack, txtTitleGioHang);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
