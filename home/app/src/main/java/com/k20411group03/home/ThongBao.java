package com.k20411group03.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.k20411group03.adapters.NotificationAdapter;
import com.k20411group03.home.R;
import com.k20411group03.home.databinding.ActivityThongBaoBinding;
import com.k20411group03.models.Notification;
import com.k20411group03.models.category;

import java.util.ArrayList;
import java.util.List;

public class ThongBao extends AppCompatActivity {
    ActivityThongBaoBinding binding;
    NotificationAdapter adapterNoti;
    List<Notification> notifications;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThongBaoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

         //Custom action bar
         ActionBar actionBar = getSupportActionBar();
         actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
         actionBar.setDisplayShowCustomEnabled(true);
         actionBar.setCustomView(R.layout.custom_action_bar);
         actionBar.setDisplayUseLogoEnabled(true);
         actionBar.setDisplayShowHomeEnabled(true);

        addEvents();
        loadData();
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
                Intent intentSearch = new Intent(this, ActivitySearch.class);
                startActivity(intentSearch);
                break;
            case R.id.action_cart:
                Intent intentCart = new Intent(this, MainActivity.class);
                startActivity(intentCart);
                break;
            case R.id.action_BoSuuTap:
                Intent intentBoSuuTap = new Intent(this, ProductCollection.class);
                intentBoSuuTap.putExtra("screenTitle", "Bộ sưu tập mới");
                startActivity(intentBoSuuTap);
                break;
            case R.id.action_HangMoiVe:
                Intent intentSanPhamMoi = new Intent(this, ProductCollection.class);
                intentSanPhamMoi.putExtra("screenTitle", "Hàng mới về");
                startActivity(intentSanPhamMoi);
                break;
            case R.id.action_Flashsale:
                Intent intentFlashsale = new Intent(this, FlashSaleScreen.class);
                startActivity(intentFlashsale);
                break;
            case R.id.action_SanPham:
                Intent intentSanPham = new Intent(this, ProductCollection.class);
                intentSanPham.putExtra("screenTitle", "Sản phẩm");
                startActivity(intentSanPham);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private void loadData() {
        notifications = new ArrayList<>();

        notifications.add(new Notification(R.drawable.bannersale, "Giảm giá Noel", "Giảm lên đến 50% các sản phẩm sweater"));
        notifications.add(new Notification(R.drawable.jean001, "Cốc cốc cốc, bạn bỏ quên gì nè!", "Một sản phẩm quần jean đã được thêm vào giỏ hàng của bạn nhưng chưa được mua, đến ngay giỏ hàng để rinh ngay thôi nào!"));
        notifications.add(new Notification(R.drawable.nha_giao_vietnam, "Mừng ngày Nhà giáo Việt Nam 20 - 11", "Mừng nhà giáo Việt Nam, The Weekdays giảm giá 20% cho tất cả các sản phẩm quần jean cho quý thầy!"));
        notifications.add(new Notification(R.drawable.tiktok_channel, "Ra mắt kênh truyền thông TikTok của The Weekdays", "Tháng 11 vừa qua, thương hiệu thời trang nam The Weekdays đã thành lập kênh TikTok @theweekdaysvn để truyền tải thông điệp thời trang nam đến với tất cả các bạn trẻ. Hãy theo dõi kênh TikTok của The Weekdays để cập nhật những thông tin mới nhất về thương hiệu và những sản phẩm mới nhất của The Weekdays nhé!"));

        adapterNoti = new NotificationAdapter(ThongBao.this, R.layout.thongbao_item, notifications);
        binding.lvThongBao.setAdapter(adapterNoti);

    }

    private void addEvents(){
        navigationView = binding.mnNoti;
        navigationView.setSelectedItemId(R.id.item_noti);
        navigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_noti:
                        return true;
                    case  R.id.item_member1:
                        Intent intent1 = new Intent(getApplicationContext(),member1.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent1);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.item_home:
                        Intent intent2 =new Intent(getApplicationContext(),TrangChu.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.item_scan:
                        Intent intent3 =new Intent(getApplicationContext(),scan1.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent3);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.item_wishlist:
                        Intent intent4 =new Intent(getApplicationContext(),Wishlist.class);
                        intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent4);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

}
}
