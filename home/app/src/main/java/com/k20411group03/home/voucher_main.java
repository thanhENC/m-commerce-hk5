package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.k20411group03.adapters.VoucherAdapter;
import com.k20411group03.home.databinding.ActivityVoucherMainBinding;
import com.k20411group03.models.Voucher;

import java.util.ArrayList;

public class voucher_main extends AppCompatActivity {
    ActivityVoucherMainBinding binding;
    VoucherAdapter adapterv;
    ArrayList<Voucher> voucherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_voucher_main);

        binding= ActivityVoucherMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData() {
        voucherList= new ArrayList<>();
        voucherList.add(new Voucher("Giảm ₫50k"," Đơn tối thiểu từ ₫150K","30.11.2022"));
        voucherList.add(new Voucher("Giảm ₫50k"," Đơn tối thiểu từ ₫150K","30.11.2022"));
        voucherList.add(new Voucher("Giảm ₫50k"," Đơn tối thiểu từ ₫150K","30.11.2022"));
        voucherList.add(new Voucher("Giảm ₫50k"," Đơn tối thiểu từ ₫150K","30.11.2022"));
        voucherList.add(new Voucher("Giảm ₫50k"," Đơn tối thiểu từ ₫150K","30.11.2022"));

        //Init Adapter
        // điền dô constructer của mình
        adapterv = new VoucherAdapter(voucher_main.this,R.layout.voucher_sample,voucherList);
        // truyen adapter cua minh
        binding.lvMaGiamGia.setAdapter(adapterv);

    }
}