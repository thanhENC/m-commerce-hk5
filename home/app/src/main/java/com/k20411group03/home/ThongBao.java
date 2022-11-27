package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.k20411group03.adapters.NotificationAdapter;
import com.k20411group03.home.R;
import com.k20411group03.home.databinding.ActivityThongBaoBinding;
import com.k20411group03.models.Notification;

import java.util.ArrayList;
import java.util.List;

public class ThongBao extends AppCompatActivity {

    ActivityThongBaoBinding binding;
    NotificationAdapter adapter;
    List<Notification> notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_thong_bao);

        binding = ActivityThongBaoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
}