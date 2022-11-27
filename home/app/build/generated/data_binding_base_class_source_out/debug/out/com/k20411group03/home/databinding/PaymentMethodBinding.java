// Generated by view binder compiler. Do not edit!
package com.k20411group03.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.k20411group03.home.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PaymentMethodBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imvPaymentImage;

  @NonNull
  public final RadioButton rdbtnPayment;

  @NonNull
  public final TextView txtPaymentMethod;

  @NonNull
  public final TextView txtPaymentNote;

  private PaymentMethodBinding(@NonNull LinearLayout rootView, @NonNull ImageView imvPaymentImage,
      @NonNull RadioButton rdbtnPayment, @NonNull TextView txtPaymentMethod,
      @NonNull TextView txtPaymentNote) {
    this.rootView = rootView;
    this.imvPaymentImage = imvPaymentImage;
    this.rdbtnPayment = rdbtnPayment;
    this.txtPaymentMethod = txtPaymentMethod;
    this.txtPaymentNote = txtPaymentNote;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PaymentMethodBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PaymentMethodBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.payment_method, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PaymentMethodBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imv_PaymentImage;
      ImageView imvPaymentImage = ViewBindings.findChildViewById(rootView, id);
      if (imvPaymentImage == null) {
        break missingId;
      }

      id = R.id.rdbtn_Payment;
      RadioButton rdbtnPayment = ViewBindings.findChildViewById(rootView, id);
      if (rdbtnPayment == null) {
        break missingId;
      }

      id = R.id.txt_PaymentMethod;
      TextView txtPaymentMethod = ViewBindings.findChildViewById(rootView, id);
      if (txtPaymentMethod == null) {
        break missingId;
      }

      id = R.id.txt_PaymentNote;
      TextView txtPaymentNote = ViewBindings.findChildViewById(rootView, id);
      if (txtPaymentNote == null) {
        break missingId;
      }

      return new PaymentMethodBinding((LinearLayout) rootView, imvPaymentImage, rdbtnPayment,
          txtPaymentMethod, txtPaymentNote);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
