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

         //Custom action bar
         ActionBar actionBar = getSupportActionBar();
         actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
         actionBar.setDisplayShowCustomEnabled(true);
         actionBar.setCustomView(R.layout.custom_action_bar);
         actionBar.setDisplayUseLogoEnabled(true);
         actionBar.setDisplayShowHomeEnabled(true);

        cateID = getIntent().getStringExtra("Cate");

        //Gridview category
        categoryAdapter = new CategoryAdapter(DanhMuc.this, R.layout.category_layout, getCategory());
        binding.gvCategory.setAdapter(categoryAdapter);
        //Item list
        //ItemAdapter productAdapter = new ItemAdapter(DanhMuc.this,R.layout.item_layout,getProduct());
        loadData();
        addEvents();
    }
    //Th??m action
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //S??? ki???n action bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Intent intentSearch = new Intent(DanhMuc.this, ActivitySearch.class);
                startActivity(intentSearch);
                break;
            case R.id.action_cart:
                Intent intentCart = new Intent(DanhMuc.this, MainActivity.class);
                startActivity(intentCart);
                break;
            case R.id.action_BoSuuTap:
                Intent intentBoSuuTap = new Intent(DanhMuc.this, ProductCollection.class);
                intentBoSuuTap.putExtra("screenTitle", "B??? s??u t???p m???i");
                startActivity(intentBoSuuTap);
                break;
            case R.id.action_HangMoiVe:
                Intent intentSanPhamMoi = new Intent(DanhMuc.this, ProductCollection.class);
                intentSanPhamMoi.putExtra("screenTitle", "H??ng m???i v???");
                startActivity(intentSanPhamMoi);
                break;
            case R.id.action_Flashsale:
                Intent intentFlashsale = new Intent(DanhMuc.this, FlashSaleScreen.class);
                startActivity(intentFlashsale);
                break;
            case R.id.action_SanPham:
                Intent intentSanPham = new Intent(DanhMuc.this, ProductCollection.class);
                intentSanPham.putExtra("screenTitle", "S???n ph???m");
                startActivity(intentSanPham);
                break;
        }



        return super.onOptionsItemSelected(item);
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
        //????ng database ????? gi???i ph??ng b??? nh???:
        c.close();

        ItemAdapter productAdapter = new ItemAdapter(DanhMuc.this,R.layout.item_layout2,products);
        binding.gvItem.setAdapter(productAdapter);

        //Set t??n danh m???c
        switch (cateID) {
            case "AT":
                binding.txtCategoryname.setText("??o thun");
                break;
            case "PL":
                binding.txtCategoryname.setText("Polo");
                break;
            case "SM":
                binding.txtCategoryname.setText("S?? mi");
                break;
            case "TA":
                binding.txtCategoryname.setText("Qu???n t??y");
                break;
            case "AK":
                binding.txtCategoryname.setText("??o kho??c");
                break;
            case "KK":
                binding.txtCategoryname.setText("Qu???n kaki");
                break;
            case "JE":
                binding.txtCategoryname.setText("Qu???n jean");
                break;
            case "SH":
                binding.txtCategoryname.setText("Qu???n short");
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

        //back button
        binding.imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Click v??o s???n ph???m
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
        //Truy???n d??? li???u s???n ph???m t??? database, t???m th???i ????? s???n ph???m m???u
        list.add(new Item(1,1,"??o s?? mi ca r?? xanh r??u nh???t",150,R.drawable.somi,"??o s?? mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        list.add(new Item(1,1,"??o s?? mi ca r?? xanh r??u nh???t",150,R.drawable.somi,"??o s?? mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        list.add(new Item(1,1,"??o s?? mi ca r?? xanh r??u nh???t",150,R.drawable.somi,"??o s?? mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        list.add(new Item(1,1,"??o s?? mi ca r?? xanh r??u nh???t",150,R.drawable.somi,"??o s?? mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        return list;
    }

    private List<category> getCategory (){
        List<category> cateList =new ArrayList<>();
        cateList.add(new category("AT",R.drawable.cate_tshirt,"??o thun"));
        cateList.add(new category("PL",R.drawable.cate_polo,"??o polo"));
        cateList.add(new category("SM",R.drawable.cate_shirt,"??o s?? mi"));
        cateList.add(new category("AK",R.drawable.cate_jacket,"??o kho??c"));
        cateList.add(new category("JE",R.drawable.cate_jean,"Qu???n jean"));
        cateList.add(new category("TA",R.drawable.cateeasypant,"Qu???n ??u"));
        cateList.add(new category("KK",R.drawable.cate_kaki,"Qu???n kaki"));
        cateList.add(new category("SH",R.drawable.shortpant,"Qu???n short"));
        return cateList;
    }


}
