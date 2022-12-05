package com.k20411group03.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.k20411group03.adapters.chatPageAdapter;
import com.k20411group03.home.databinding.ActivityMainchinhchatBinding;
import com.k20411group03.models.UserModel;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class manhinhchinhchat extends AppCompatActivity {

    FirebaseAuth myAuth;
    ActivityMainchinhchatBinding manhinhchinhchatBinding;
    FirebaseDatabase firebaseDatabase;
    final ExecutorService executorService = Executors.newSingleThreadExecutor();
    com.k20411group03.adapters.chatPageAdapter chatPageAdapter;
    ArrayList<UserModel> userData = new ArrayList<>();
    Toolbar myToolbar;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        manhinhchinhchatBinding = ActivityMainchinhchatBinding.inflate(getLayoutInflater());
        firebaseDatabase = FirebaseDatabase.getInstance();
        myAuth = FirebaseAuth.getInstance();

        userId = myAuth.getCurrentUser().getUid();

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        myToolbar = manhinhchinhchatBinding.myToolbar;
        myToolbar.inflateMenu(R.menu.main_menu);



        setContentView(manhinhchinhchatBinding.getRoot());

        manhinhchinhchatBinding.tutorial.setVisibility(View.GONE);

        if(!isOnline()){
            Toast.makeText(manhinhchinhchat.this, "Check Internet Connection", Toast.LENGTH_LONG).show();
        }

        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Intent intent  = new Intent(manhinhchinhchat.this, SettingActivity.class);
                startActivity(intent);

                return true;
            }
        });


        manhinhchinhchatBinding.moveToContactlistFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(manhinhchinhchat.this, ContactListsActivity.class);
                startActivity(intent);

            }
        });


        chatPageAdapter = new chatPageAdapter(userData, manhinhchinhchat.this);
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
                            manhinhchinhchatBinding.tutorial.setVisibility(View.VISIBLE);
                        }else{
                            manhinhchinhchatBinding.tutorial.setVisibility(View.GONE);

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
        DividerItemDecoration decoration = new DividerItemDecoration(manhinhchinhchatBinding.chatsRecyclerview.getContext(), DividerItemDecoration.VERTICAL);
        manhinhchinhchatBinding.chatsRecyclerview.addItemDecoration(decoration);
        manhinhchinhchatBinding.chatsRecyclerview.setLayoutManager(new LinearLayoutManager(manhinhchinhchat.this));


        manhinhchinhchatBinding.chatsRecyclerview.setAdapter(chatPageAdapter);


        chatPageAdapter.setOnItemClickListener(new chatPageAdapter.OnClickListener() {
            @Override
            public void onItemClick(UserModel userdata) {


                Intent intent = new Intent(manhinhchinhchat.this, MessagingActivity.class);
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

}