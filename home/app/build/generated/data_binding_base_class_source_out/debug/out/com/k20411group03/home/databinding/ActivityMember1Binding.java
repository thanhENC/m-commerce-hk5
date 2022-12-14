// Generated by view binder compiler. Do not edit!
package com.k20411group03.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class ActivityMember1Binding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout btnDieukhoanvabaomat;

  @NonNull
  public final LinearLayout btnDonhang;

  @NonNull
  public final LinearLayout btnLienhe;

  @NonNull
  public final LinearLayout btnNgonngu;

  @NonNull
  public final LinearLayout btnThietlaptaikhoan;

  @NonNull
  public final LinearLayout btnTrungtamtrogiup;

  @NonNull
  public final LinearLayout btnVouchercuatoi;

  @NonNull
  public final LinearLayout btnYeuthich;

  @NonNull
  public final ImageView imvBack;

  @NonNull
  public final TextView txtTitleGioHang;

  private ActivityMember1Binding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout btnDieukhoanvabaomat, @NonNull LinearLayout btnDonhang,
      @NonNull LinearLayout btnLienhe, @NonNull LinearLayout btnNgonngu,
      @NonNull LinearLayout btnThietlaptaikhoan, @NonNull LinearLayout btnTrungtamtrogiup,
      @NonNull LinearLayout btnVouchercuatoi, @NonNull LinearLayout btnYeuthich,
      @NonNull ImageView imvBack, @NonNull TextView txtTitleGioHang) {
    this.rootView = rootView;
    this.btnDieukhoanvabaomat = btnDieukhoanvabaomat;
    this.btnDonhang = btnDonhang;
    this.btnLienhe = btnLienhe;
    this.btnNgonngu = btnNgonngu;
    this.btnThietlaptaikhoan = btnThietlaptaikhoan;
    this.btnTrungtamtrogiup = btnTrungtamtrogiup;
    this.btnVouchercuatoi = btnVouchercuatoi;
    this.btnYeuthich = btnYeuthich;
    this.imvBack = imvBack;
    this.txtTitleGioHang = txtTitleGioHang;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMember1Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMember1Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_member1, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMember1Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_dieukhoanvabaomat;
      LinearLayout btnDieukhoanvabaomat = ViewBindings.findChildViewById(rootView, id);
      if (btnDieukhoanvabaomat == null) {
        break missingId;
      }

      id = R.id.btn_donhang;
      LinearLayout btnDonhang = ViewBindings.findChildViewById(rootView, id);
      if (btnDonhang == null) {
        break missingId;
      }

      id = R.id.btn_lienhe;
      LinearLayout btnLienhe = ViewBindings.findChildViewById(rootView, id);
      if (btnLienhe == null) {
        break missingId;
      }

      id = R.id.btn_ngonngu;
      LinearLayout btnNgonngu = ViewBindings.findChildViewById(rootView, id);
      if (btnNgonngu == null) {
        break missingId;
      }

      id = R.id.btn_thietlaptaikhoan;
      LinearLayout btnThietlaptaikhoan = ViewBindings.findChildViewById(rootView, id);
      if (btnThietlaptaikhoan == null) {
        break missingId;
      }

      id = R.id.btn_trungtamtrogiup;
      LinearLayout btnTrungtamtrogiup = ViewBindings.findChildViewById(rootView, id);
      if (btnTrungtamtrogiup == null) {
        break missingId;
      }

      id = R.id.btn_vouchercuatoi;
      LinearLayout btnVouchercuatoi = ViewBindings.findChildViewById(rootView, id);
      if (btnVouchercuatoi == null) {
        break missingId;
      }

      id = R.id.btn_yeuthich;
      LinearLayout btnYeuthich = ViewBindings.findChildViewById(rootView, id);
      if (btnYeuthich == null) {
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

      return new ActivityMember1Binding((LinearLayout) rootView, btnDieukhoanvabaomat, btnDonhang,
          btnLienhe, btnNgonngu, btnThietlaptaikhoan, btnTrungtamtrogiup, btnVouchercuatoi,
          btnYeuthich, imvBack, txtTitleGioHang);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
