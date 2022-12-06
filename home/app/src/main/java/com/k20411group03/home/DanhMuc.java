package com.k20411group03.home;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.k20411group03.Utils;
import com.k20411group03.adapters.CategoryAdapter;
import com.k20411group03.adapters.FlashsaleAdapter;
import com.k20411group03.adapters.ItemAdapter;
import com.k20411group03.adapters.ItemRecyclerAdapter;
import com.k20411group03.home.databinding.ActivityDanhMucBinding;
import com.k20411group03.home.databinding.ActivityFlashSaleScreenBinding;
import com.k20411group03.models.Item;
import com.k20411group03.models.Product;
import com.k20411group03.models.ProductModel;
import com.k20411group03.models.category;

import java.util.ArrayList;
import java.util.List;

public class DanhMuc extends AppCompatActivity {
    ActivityDanhMucBinding binding;
    CategoryAdapter categoryAdapter;
    public static SQLiteDatabase db;
    String cateID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDanhMucBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//         //Custom action bar
//         ActionBar actionBar = getSupportActionBar();
//         actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//         actionBar.setDisplayShowCustomEnabled(true);
//         actionBar.setCustomView(R.layout.custom_action_bar);
//         actionBar.setDisplayUseLogoEnabled(true);
//         actionBar.setDisplayShowHomeEnabled(true);

        cateID = getIntent().getStringExtra("Cate");

        //Gridview category
        categoryAdapter = new CategoryAdapter(DanhMuc.this, R.layout.category_layout, getCategory());
        binding.gvCategory.setAdapter(categoryAdapter);
        //Item list
        //ItemAdapter productAdapter = new ItemAdapter(DanhMuc.this,R.layout.item_layout,getProduct());
        loadData();
        addEvents();
    }
    private void loadData(){
        ArrayList<ProductModel> products = new ArrayList<>();
        db = openOrCreateDatabase(Utils.DB_NAME, MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE(" + Utils.COL_CATEGORY + " = '" + cateID + "')",null);
        c.moveToFirst();
        int ProductID;
        String ProductName;
        String Category;
        byte[] Thumbnail;
        Double ProductPrice;
        Double SalePrice;
        String ProductDescription;
        int Inventory;
        while (c.moveToNext()) {
            ProductID = c.getInt(0);
            ProductName = c.getString(1);
            Category = c.getString(2);
            Thumbnail = c.getBlob(3);
            ProductPrice = c.getDouble(4);
            SalePrice = c.getDouble(5);
            ProductDescription = c.getString(6);
            Inventory = c.getInt(7);

            products.add(new ProductModel(ProductID, ProductName, Category, Thumbnail, ProductPrice, SalePrice,ProductDescription, Inventory));
        }
        //Đóng database để giải phóng bộ nhớ:
        c.close();

        ItemAdapter productAdapter = new ItemAdapter(DanhMuc.this,R.layout.item_layout2,products);
        binding.gvItem.setAdapter(productAdapter);

        //Set tên danh mục
        switch (cateID) {
            case "AT":
                binding.txtCategoryname.setText("Áo thun");
                break;
            case "PL":
                binding.txtCategoryname.setText("Polo");
                break;
            case "SM":
                binding.txtCategoryname.setText("Sơ mi");
                break;
            case "TA":
                binding.txtCategoryname.setText("Quần tây");
                break;
            case "AK":
                binding.txtCategoryname.setText("Áo khoác");
                break;
            case "KK":
                binding.txtCategoryname.setText("Quần kaki");
                break;
            case "JE":
                binding.txtCategoryname.setText("Quần jean");
                break;
            case "SH":
                binding.txtCategoryname.setText("Quần short");
                break;

        }

    }

    private void addEvents() {
        binding.gvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                category c = (category) binding.gvCategory.getItemAtPosition(i);
                String cateID = c.getCateID();
                Intent intent = new Intent(DanhMuc.this,DanhMuc.class);
                intent.putExtra("Cate", cateID);
                startActivity(intent);
            }
        });

        //Click vào sản phẩm
        binding.gvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ProductModel p = (ProductModel) binding.gvItem.getItemAtPosition(i);
                Intent intent = new Intent(DanhMuc.this, ProductDetails.class);
                intent.putExtra("ProductID", p.getProductID());
                startActivity(intent);
            }
        });
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
        cateList.add(new category("AT",R.drawable.cate_tshirt,"Áo thun"));
        cateList.add(new category("PL",R.drawable.cate_polo,"Áo polo"));
        cateList.add(new category("SM",R.drawable.cate_shirt,"Áo sơ mi"));
        cateList.add(new category("AK",R.drawable.cate_jacket,"Áo khoác"));
        cateList.add(new category("JE",R.drawable.cate_jean,"Quần jean"));
        cateList.add(new category("TA",R.drawable.cateeasypant,"Quần âu"));
        cateList.add(new category("KK",R.drawable.cate_kaki,"Quần kaki"));
        cateList.add(new category("SH",R.drawable.shortpant,"Quần short"));
        return cateList;
    }


}
