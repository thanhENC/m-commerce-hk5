package com.k20411group03.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.k20411group03.home.R;
import com.k20411group03.models.Payment;
import com.k20411group03.models.Product;

import java.util.List;

public class PaymentAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Payment> payments;

    public PaymentAdapter(Activity activity, int item_layout, List<Payment> payments) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.payments = payments;
    }

    @Override
    public int getCount() {
        return payments.size();
    }

    @Override
    public Object getItem(int i) {
        return payments.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder {
        public
        ImageView imvPaymentImage;
        TextView txtPaymentName, txtPaymentNote;
        RadioButton rdbtnPayment;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PaymentAdapter.ViewHolder viewHolder;

        if (view == null) {
            //link views
            viewHolder = new PaymentAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            viewHolder.txtPaymentName = view.findViewById(R.id.txt_PaymentMethod);
            viewHolder.txtPaymentNote = view.findViewById(R.id.txt_PaymentNote);
            viewHolder.imvPaymentImage = view.findViewById(R.id.imv_PaymentImage);
            viewHolder.rdbtnPayment = view.findViewById(R.id.rdbtn_Payment);

            view.setTag(viewHolder);
        } else {
            viewHolder = (PaymentAdapter.ViewHolder) view.getTag();
        }

        //binding data
        Payment payment = payments.get(i);
        viewHolder.rdbtnPayment.setChecked(payment.getpaymentRadio());
        viewHolder.imvPaymentImage.setImageResource(payment.getPaymentImage());
        viewHolder.txtPaymentName.setText(payment.getPaymentName());
        viewHolder.txtPaymentNote.setText(payment.getPaymentNote());

        return view;
    }


}