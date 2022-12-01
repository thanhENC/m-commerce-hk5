package com.k20411group03.home;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.k20411group03.adapters.CategoryAdapter;
import com.k20411group03.adapters.ItemAdapter;
import com.k20411group03.adapters.ItemRecyclerAdapter;
import com.k20411group03.home.databinding.ActivityDanhMucBinding;
import com.k20411group03.models.Item;
import com.k20411group03.models.category;

import java.util.ArrayList;
import java.util.List;

public class DanhMuc extends AppCompatActivity {
    ActivityDanhMucBinding binding;
    GridView gvCategory;
    CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDanhMucBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //setContentView(R.layout.activity_danh_muc);
        Bundle extras = getIntent().getExtras();
        int cate = extras.getInt("Cate");

        //Gridview category
        categoryAdapter = new CategoryAdapter(DanhMuc.this,R.layout.category_layout,getCategory());
        binding.gvCategory.setAdapter(categoryAdapter);

        //Item list tạm thời
        ItemAdapter itemAdapter = new ItemAdapter(DanhMuc.this,R.layout.item_layout2,getListItem());
        binding.gvItem.setAdapter(itemAdapter);
    }

    private List<Item> getListItem(){
        List<Item> list = new ArrayList<>();
        int i = R.drawable.somi;
        //Truyền dữ liệu sản phẩm từ database, tạm thời để sản phẩm mẫu
        list.add(new Item(1,1,"Áo sơ mi ca rô xanh rêu nhạt",150,R.drawable.somi,"Áo sơ mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        list.add(new Item(1,1,"Áo sơ mi ca rô xanh rêu nhạt",150,R.drawable.somi,"Áo sơ mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        list.add(new Item(1,1,"Áo sơ mi ca rô xanh rêu nhạt",150,R.drawable.somi,"Áo sơ mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        list.add(new Item(1,1,"Áo sơ mi ca rô xanh rêu nhạt",150,R.drawable.somi,"Áo sơ mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        return list;
    }

    private List<category> getCategory (){
        List<category> cateList =new ArrayList<>();
        cateList.add(new category(1,R.drawable.cate_tshirt,"Áo thun"));
        cateList.add(new category(2,R.drawable.cate_polo,"Áo polo"));
        cateList.add(new category(3,R.drawable.cate_shirt,"Áo sơ mi"));
        cateList.add(new category(4,R.drawable.cate_jacket,"Áo khoác"));
        cateList.add(new category(5,R.drawable.cate_jean,"Quần jean"));
        cateList.add(new category(6,R.drawable.cateeasypant,"Quần âu"));
        cateList.add(new category(7,R.drawable.cate_kaki,"Quần kaki"));
        cateList.add(new category(8,R.drawable.shortpant,"Quần short"));
        return cateList;
    }


}