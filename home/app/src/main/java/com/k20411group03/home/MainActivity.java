package com.k20411group03.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.k20411group03.DisplayHelper;
import com.k20411group03.Utils;
import com.k20411group03.adapters.ProductInCartAdapter;
import com.k20411group03.home.databinding.ActivityMainBinding;
import com.k20411group03.models.Product;
import com.k20411group03.models.ProductInCartModel;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ProductInCartAdapter adapter;
    ArrayList<ProductInCartModel> products;
    FirebaseAuth myAuth;
    ActivityMainBinding activityMainBinding;
    FirebaseDatabase firebaseDatabase;
    final ExecutorService executorService = Executors.newSingleThreadExecutor();
    chatPageAdapter chatPageAdapter;
    ArrayList<UserModel> userData = new ArrayList<>();
    Toolbar myToolbar;
    String userId;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        firebaseDatabase = FirebaseDatabase.getInstance();
        myAuth = FirebaseAuth.getInstance();

        userId = myAuth.getCurrentUser().getUid();

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        myToolbar = activityMainBinding.myToolbar;
        myToolbar.inflateMenu(R.menu.main_menu);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activityMainBinding.tutorial.setVisibility(View.GONE);

        if(!isOnline()){
            Toast.makeText(MainActivity.this, "Check Internet Connection", Toast.LENGTH_LONG).show();
        }

        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                                                 @Override
                                                 public boolean onMenuItemClick(MenuItem item) {

                                                     Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                                                     startActivity(intent);

                                                     return true;
                                                 }
                                             });
        activityMainBinding.moveToContactlistFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ContactListsActivity.class);
                startActivity(intent);

            }
        });


        chatPageAdapter = new chatPageAdapter(userData, MainActivity.this);
        executorService.execute(new Runnable() {
            @Override
            public void run() {



                firebaseDatabase.getReference("Users").addValueEventListener(new ValueEventListener() {



                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {



                        userData.clear();
                        ArrayList<String> contactIds = new ArrayList<>();
                        ArrayList<Long> recentMsgTimes = new ArrayList<>();
                        ArrayList<String> recentMsg = new ArrayList<>();


                        if(snapshot.child(userId).hasChild("Contacts"))
                            for (DataSnapshot e : snapshot.child(myAuth.getUid()).child("Contacts").getChildren()){
                                contactIds.add(e.getKey());


                                if(e.hasChild("interactionTime")) {
                                    recentMsgTimes.add((long)e.child("interactionTime").getValue());
                                }

                                if(e.hasChild("recentMessage")){
                                    recentMsg.add(e.child("recentMessage").getValue().toString());
                                }

                            }

                        if(contactIds.isEmpty()){
                            activityMainBinding.tutorial.setVisibility(View.VISIBLE);
                        }else{
                            activityMainBinding.tutorial.setVisibility(View.GONE);

                        }


                        for(int i=0;i<contactIds.size();i++) {

                            String e = contactIds.get(i);
                            long time = 0;
                            String recentmsg = "";

                            try{
                                if(!recentMsgTimes.isEmpty()){time = recentMsgTimes.get(i);}
                                if(!recentMsg.isEmpty()){recentmsg = recentMsg.get(i);}
                            }catch (IndexOutOfBoundsException err){

                            }




                            String uName = snapshot.child(e).child("userName").getValue().toString();
                            String uMail = snapshot.child(e).child("userMail").getValue().toString();
                            String uPic = snapshot.child(e).child("profilePic").getValue().toString();
                            String token = snapshot.child(e).child("token").getValue().toString();

                            UserModel model = new UserModel(uName, uMail, uPic);
                            model.setUserId(e);
                            model.setRecentMsgTime(time);
                            model.setToken(token);
                            model.setRecentMessage(recentmsg);
                            userData.add(model);
                            chatPageAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

//        Drawable drawable =  ContextCompat.getDrawable(MainActivity.this,R.drawable.divider);
        DividerItemDecoration decoration = new DividerItemDecoration(activityMainBinding.chatsRecyclerview.getContext(), DividerItemDecoration.VERTICAL);
        activityMainBinding.chatsRecyclerview.addItemDecoration(decoration);
        activityMainBinding.chatsRecyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        activityMainBinding.chatsRecyclerview.setAdapter(chatPageAdapter);


        chatPageAdapter.setOnItemClickListener(new chatPageAdapter.OnClickListener() {
            @Override
            public void onItemClick(UserModel userdata) {


                Intent intent = new Intent(MainActivity.this, MessagingActivity.class);
                intent.putExtra("USERNAME", userdata.getUserName());
                intent.putExtra("PROFILEIMAGE", userdata.getProfilePic());
                intent.putExtra("USERID", userdata.getUserId());
                intent.putExtra("TOKEN", userdata.getToken());
                startActivity(intent);


            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }

        loadData();
        addEvents();
    }

    private void loadData() {
        products = new ArrayList<>();

        db = openOrCreateDatabase(Utils.DB_NAME, MODE_PRIVATE, null);

        //Giả sử ProductID [100, 101, 202] là sản phẩm trong giỏ hàng
        //Tạm thời query trong bảng Product để lấy thông tin sản phẩm nhưng thực chất phải query trong bảng Cart join với bảng Product
        //Chỉ lấy dữ liệu ở cột 0: ProductID, 1: ProductName, 2: ProductSalePrice, 3: ProductImage, 4: ProductQuantity
        Cursor c = db.rawQuery("SELECT " + Utils.COL_ID + ", " + Utils.COL_NAME + ", " + Utils.COL_SALEPRICE + ", " + Utils.COL_IMAGE + ", " + Utils.COL_INVENTORY + " FROM " + Utils.TBL_NAME + " WHERE " + Utils.COL_ID + " IN (100, 101, 202)", null);

        while (c.moveToNext()) {
            //Lấy dữ liệu từ database
            //Toàn bảng thực tế sẽ join 0: ProductID, 1: ProductName, 2: CategoryID, 3: Thumbnail, 4: Price, 5: SalePrice, 6: Description, 7: Quantity, 8: ProductSize, 9: ProductColor, 10: IsChecked

            int id = c.getInt(0);
            String name = c.getString(1);
            Double price = c.getDouble(2);
            byte[] image = c.getBlob(3);
            int quantity = c.getInt(4);

            //Tạo đối tượng ProductInCartModel
            //Giả sử size="S", color="Black"
            ProductInCartModel product = new ProductInCartModel(id, name, null, image, null, price, null, quantity, "S", "Black", false);
            products.add(product);
        }

        adapter = new ProductInCartAdapter(MainActivity.this, R.layout.cartitem, products);
        binding.lvGioHang.setAdapter(adapter);

        binding.txtTongTien.setText(String.valueOf(DisplayHelper.formatPrice(adapter.sumOfAllProductsInCart())));
    }

    private void addEvents() {

    }
}