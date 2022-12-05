package com.k20411group03.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.k20411group03.adapters.VoucherAdapter;
import com.k20411group03.home.databinding.ActivityDieuKienVoucherBinding;

import java.util.Locale;

public class DieuKienVoucher extends AppCompatActivity {
    ActivityDieuKienVoucherBinding binding;
    VoucherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDieuKienVoucherBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_chi_tiet_voucher);

        //Custom action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.custom_action_bar);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadData();
        addEvent();
    }

    //Thêm action
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Sự kiện action bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Intent intentSearch = new Intent(DieuKienVoucher.this, ActivitySearch.class);
                startActivity(intentSearch);
                break;
            case R.id.action_cart:
                Intent intentCart = new Intent(DieuKienVoucher.this, MainActivity.class);
                startActivity(intentCart);
                break;
            case R.id.action_menu:
                Intent intentMenu = new Intent(DieuKienVoucher.this, MainMenu.class);
                startActivity(intentMenu);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadData() {
        //hinh voucher
        Intent intent = getIntent();

        String titleOfVoucher = intent.getStringExtra("TitleOfVoucher");
        String HSD = intent.getStringExtra("HSDVoucher");
        String maxValue = intent.getStringExtra("MaxOfValue");


        binding.txtTenvoucher.setText(titleOfVoucher);
        binding.txtHanSuDungVoucher.setText(HSD);
        binding.txtMaxValueGiam.setText(maxValue);

        //noi dung ben duoi voucher
        binding.txtNoidunguudai.setText( titleOfVoucher + ". Giảm tối đa ₫" +maxValue+ "K");
        binding.txtNoidunghieuluc.setText("06/12/2022"+ " - " + HSD);
        binding.txtNoidungphuongthucthanhtoan.setText("Mọi phương thức thanh toán");
        binding.txtDieukiensudungvoucher.setText("Sử dụng mã " + titleOfVoucher.toLowerCase(Locale.ROOT) + " chỉ áp dụng trên App cho tất cả sản phẩm The Weekdays trong suốt thời điểm diễn ra chương trình thõa mãn điều kiện yêu cầu giá trị đơn tối thiểu đặt ra.\n \n" + "Giảm " + maxValue + " trên giá trị tổng của đơn hàng.\n \n" + "Chỉ áp dụng cho khách hàng nhận được thông báo ưu đãi này.\n" +
                "\n" +
                "Số lượt sử dụng có hạn, chương trình và mã có thể kết thúc khi hết lượt ưu đãi hoặc khi hết hạn ưu đãi, tùy điều kiện nào đến trước");
    }

    private void addEvent() {
        binding.btnDungngayvoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DieuKienVoucher.this, MainActivity.class);

                intent.putExtra("TitleOfVoucher", binding.txtTenvoucher.getText());
                intent.putExtra("HSDVoucher", binding.txtHanSuDungVoucher.getText());
                intent.putExtra("MaxOfValue", binding.txtMaxValueGiam.getText());
                startActivity(intent);
            }
        });
    }
}