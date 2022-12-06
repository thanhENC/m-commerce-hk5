package com.k20411group03.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.k20411group03.home.R;
import com.k20411group03.home.ThongBao;
import com.k20411group03.models.Notification;

import java.util.List;

public class NotificationAdapter extends BaseAdapter {

    ThongBao activity;
    int item_layout;
    List<Notification> listThongBao;

    public NotificationAdapter(ThongBao activity, int item_layout, List<Notification> listThongBao) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.listThongBao = listThongBao;
    }

    @Override
    public int getCount() {
        return listThongBao.size();
    }

    @Override
    public Object getItem(int i) {
        return listThongBao.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            viewHolder.imvThongBao = view.findViewById(R.id.imv_ThongBao);
            viewHolder.txtThongBaoTitle = view.findViewById(R.id.txt_ThongBaoTitle);
            viewHolder.txtThongBaoContent = view.findViewById(R.id.txt_ThongBaoContent);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        Notification thongBao = listThongBao.get(i);
        viewHolder.imvThongBao.setImageResource(thongBao.getThongBao_Image());
        viewHolder.txtThongBaoTitle.setText(thongBao.getThongBao_Title());
        viewHolder.txtThongBaoContent.setText(thongBao.getThongBao_Content());

        return view;
    }

    public static class ViewHolder{
        ImageView imvThongBao;
        TextView txtThongBaoTitle, txtThongBaoContent;
    }
}
