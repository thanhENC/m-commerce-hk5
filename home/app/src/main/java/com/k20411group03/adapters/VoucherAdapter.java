package com.k20411group03.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.k20411group03.home.R;
import com.k20411group03.models.Voucher;

import java.util.List;

public class VoucherAdapter extends BaseAdapter {

    Context c;
    Activity activity;
    int item_layout;
    List<Voucher> vouchers;


    public VoucherAdapter(Activity activity, int item_layout, List<Voucher> vouchers){
        this.activity = activity;
        this.item_layout = item_layout;
        this.vouchers = vouchers;
    }


    @Override
    public int getCount() {
        return vouchers.size();
    }

    @Override
    public Object getItem(int position) {
        return vouchers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(item_layout, null);

        }

        TextView txt_GiaTriCoupon = convertView.findViewById(R.id.txt_GiaTriCoupon);
        TextView txt_GiaTriToiThieu = convertView.findViewById(R.id.txt_GiaTriToiThieu);
        TextView txt_HanSuDungVoucher = convertView.findViewById(R.id.txt_HanSuDungVoucher);
        Voucher v = vouchers.get(position);
        txt_HanSuDungVoucher.setText(v.getHSDvoucher());
        txt_GiaTriToiThieu.setText(v.getVouchersubtitle());
        txt_GiaTriCoupon.setText(v.getVouchertitle());

        return convertView;
    }
}
