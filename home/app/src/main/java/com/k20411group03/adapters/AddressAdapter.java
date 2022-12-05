package com.k20411group03.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.k20411group03.home.R;
import com.k20411group03.models.Address_province;

import java.util.List;

public class AddressAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Address_province> provinces;

    public AddressAdapter(Activity activity, int item_layout, List<Address_province> provinces) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.provinces = provinces;
    }

    @Override
    public int getCount() {
        return provinces.size();
    }

    @Override
    public Object getItem(int i) {
        return provinces.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder {
        public
        TextView txtProvince, txtDistrict, txtWard;
        EditText edtsurname, edtfirstname, edtstreet, edtphone, edtnoteadress;
        Button btnconfirmaddress;
        Spinner spinner1, spinner2, spinner3;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        AddressAdapter.ViewHolder viewHolder;

        if (view == null) {
            //link views
            viewHolder = new AddressAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            viewHolder.txtProvince = view.findViewById(R.id.txt_province);
            viewHolder.txtDistrict = view.findViewById(R.id.txt_district);
            viewHolder.txtWard = view.findViewById(R.id.txt_ward);
            viewHolder.spinner1 = view.findViewById(R.id.spinner_province);
            viewHolder.btnconfirmaddress = view.findViewById(R.id.btn_confirmaddress);

            view.setTag(viewHolder);
        } else {
            viewHolder = (AddressAdapter.ViewHolder) view.getTag();
        }

        //binding data
        Address_province province = provinces.get(i);
        viewHolder.txtProvince.setText(province.getProvince_name());

        return view;
    }


}
