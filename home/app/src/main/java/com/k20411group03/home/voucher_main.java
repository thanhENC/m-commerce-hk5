package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.k20411group03.adapters.VoucherAdapter;
import com.k20411group03.home.databinding.ActivityVoucherMainBinding;
import com.k20411group03.models.Voucher;

import java.util.ArrayList;

public class voucher_main extends AppCompatActivity {
    ActivityVoucherMainBinding binding;
    VoucherAdapter adapter;
    ArrayList<Voucher> vouchers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVoucherMainBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_kho_voucher);
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addEvent();
        loadData();
    }

    private void loadData() {
        vouchers = new ArrayList<>();
        vouchers.add(new Voucher("Tất cả hình thức thanh toán", "28/02/2022", "Tối đa 15k"));
        vouchers.add(new Voucher("GIẢM 15% ĐƠN TỪ 100K","28/02/2022", "Tối đa 15k"));
        vouchers.add(new Voucher("GIẢM 5% ĐƠN TỪ 50K", "30/11/2022", "Tối đa 15k"));
        vouchers.add(new Voucher("GIẢM 50K ĐƠN TỪ 99K", "20/12/2022", "Tối đa 15k"));
        vouchers.add(new Voucher("GIẢM 15% ĐƠN TỪ 100K", "28/02/2022", "Tối đa 15k"));
        vouchers.add(new Voucher("Tất cả hình thức thanh toán", "28/02/2022", "Tối đa 15k"));
        vouchers.add(new Voucher("GIẢM 5% ĐƠN TỪ 50K", "30/11/2022", "Tối đa 15k"));
        vouchers.add(new Voucher("Tất cả hình thức thanh toán", "28/02/2022", "Tối đa 15k"));
        vouchers.add(new Voucher("GIẢM 15% ĐƠN TỪ 100K","28/02/2022", "Tối đa 15k"));
        vouchers.add(new Voucher("GIẢM 5% ĐƠN TỪ 50K", "30/11/2022", "Tối đa 15k"));
        vouchers.add(new Voucher("GIẢM 50K ĐƠN TỪ 99K", "20/12/2022", "Tối đa 15k"));
        vouchers.add(new Voucher("GIẢM 15% ĐƠN TỪ 100K", "28/02/2022", "Tối đa 15k"));
        vouchers.add(new Voucher("Tất cả hình thức thanh toán", "28/02/2022", "Tối đa 15k"));
        vouchers.add(new Voucher("GIẢM 5% ĐƠN TỪ 50K", "30/11/2022", "Tối đa 15k"));
        adapter = new VoucherAdapter(voucher_main.this, R.layout.voucher_sample, vouchers);

        binding.lvMaGiamGia.setAdapter(adapter);

    }

    private void addEvent() {
        binding.lvMaGiamGia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(voucher_main.this, DieuKienVoucher.class);
                Voucher voucher = (Voucher) adapter.getItem(i);
                intent.putExtra("TitleOfVoucher", voucher.getTitleOfVoucher());
                intent.putExtra("HSDVoucher", voucher.getHsdVoucher());
                intent.putExtra("MaxOfValue", voucher.getMaxValue());
                startActivity(intent);
            }
        });
    }
}