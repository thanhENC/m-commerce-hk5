package com.k20411group03.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.k20411group03.home.DieuKienVoucher;
import com.k20411group03.home.MainActivity;
import com.k20411group03.home.R;
import com.k20411group03.home.TrangChu;
import com.k20411group03.models.Voucher;

import java.util.List;

public class VoucherAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<Voucher> vouchers;

    public VoucherAdapter(Activity activity, int item_layout, List<Voucher> vouchers) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.vouchers = vouchers;
    }

    @Override
    public int getCount() {
        return vouchers.size();
    }

    @Override
    public Object getItem(int i) {
        return vouchers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.txtTitleOfVoucher = view.findViewById(R.id.txt_tenvoucher);
            holder.txtHSDVoucher = view.findViewById(R.id.txt_HanSuDungVoucher);
            holder.txtMaxValue = view.findViewById(R.id.txt_MaxValueGiam);
            holder.btnDungNgay = view.findViewById(R.id.txt_dungngayvoucher);
            holder.btnDieuKien = view.findViewById(R.id.txt_dieukienvoucher);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        Voucher v = vouchers.get(i);
        holder.txtTitleOfVoucher.setText(v.getTitleOfVoucher());
        holder.txtHSDVoucher.setText(v.getHsdVoucher());
        holder.txtMaxValue.setText(String.valueOf(v.getMaxValue()));

        holder.btnDieuKien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //activity là trang xài adapter này
                Intent intent = new Intent(activity, DieuKienVoucher.class);
                intent.putExtra("TitleOfVoucher", v.getTitleOfVoucher());
                intent.putExtra("HSDVoucher", v.getHsdVoucher());
                intent.putExtra("MaxOfValue", v.getMaxValue());
                activity.startActivity(intent);
            }
        });
        holder.btnDungNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, MainActivity.class);
                intent.putExtra("TitleOfVoucher", v.getTitleOfVoucher());
                intent.putExtra("HSDVoucher", v.getHsdVoucher());
                intent.putExtra("MaxOfValue", v.getMaxValue());
                activity.startActivity(intent);
            }
        });
        return view;
    }

    public static class ViewHolder {
        TextView txtTitleOfVoucher, txtHSDVoucher, txtMaxValue, txtChuTrongAnhVoucher, txtSoLuongCoHan;
        TextView btnDungNgay, btnDieuKien;
    }
}