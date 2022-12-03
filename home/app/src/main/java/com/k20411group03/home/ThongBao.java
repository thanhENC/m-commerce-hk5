package com.k20411group03.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

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
    NotificationAdapter adapter;
    List<Notification> notifications;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_thong_bao);

        binding = ActivityThongBaoBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_thong_bao);

        addEvents();
        loadData();
    }


    private void loadData() {
        notifications = new ArrayList<>();

        notifications.add(new Notification(R.drawable.thongbao_1, "Title 1", "Content 1"));
        notifications.add(new Notification(R.drawable.thongbao_2, "Title 2", "Content 2"));
        notifications.add(new Notification(R.drawable.thongbao_1, "Title 3", "Content 3"));
        notifications.add(new Notification(R.drawable.thongbao_2, "Title 4", "Content 4"));

        adapter = new NotificationAdapter(ThongBao.this, R.layout.thongbao_item, notifications);
        binding.lvThongBao.setAdapter(adapter);

    }

    private void addEvents(){
        navigationView = findViewById(R.id.mn_noti);
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