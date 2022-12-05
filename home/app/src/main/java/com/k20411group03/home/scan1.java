package com.k20411group03.home;

import static com.google.android.gms.vision.barcode.Barcode.CODABAR;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Camera;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.k20411group03.DatabaseHelper;
import com.k20411group03.Utils;


import java.io.IOException;

public class scan1 extends AppCompatActivity {
    SurfaceView surfaceView;
    CameraSource cameraSource;
    TextView textView;
    BarcodeDetector barcodeDetector;
    EditText editText;
    Button button;
    Boolean check = false;
    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan1);

//         //Custom action bar
//         ActionBar actionBar = getSupportActionBar();
//         actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//         actionBar.setDisplayShowCustomEnabled(true);
//         actionBar.setCustomView(R.layout.custom_action_bar);
//         actionBar.setDisplayUseLogoEnabled(true);
//         actionBar.setDisplayShowHomeEnabled(true);

        check = false;
        editText = (EditText) findViewById(R.id.edt_nhapmascan);
        textView = (TextView) findViewById(R.id.tv_Result);
        button = (Button) findViewById(R.id.btn_Scan);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int txt = Integer.parseInt(editText.getText().toString());
                    db = openOrCreateDatabase(Utils.DB_NAME, MODE_PRIVATE, null);

                    Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE " + Utils.COL_ID + " = " + txt, null);
                    if (c.getCount() == 0) {
                        Toast.makeText(scan1.this, "Mã sản phẩm không tồn tại", Toast.LENGTH_SHORT).show();
                        textView.setText("");
                    } else {
                        c.close();
                        int id = Integer.parseInt(editText.getText().toString());
                        Intent intent = new Intent(scan1.this, ProductDetails.class);
                        intent.putExtra("ProductID", txt);
                        startActivity(intent);
                    }
                }
                catch (Exception e){
                    Toast.makeText(scan1.this, "Vui lòng nhập mã sản phẩm", Toast.LENGTH_SHORT).show();
                }
            }
        });

        surfaceView = (SurfaceView) findViewById(R.id.sfv_cameraSurfaceView);
        textView = (TextView) findViewById(R.id.txt_notification);
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();
        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640, 480)
                .build();
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                try {
                    cameraSource.start(holder);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
            }
            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
                cameraSource.stop();

            }});
        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
            }
            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrCodes = detections.getDetectedItems();
                if (qrCodes.size() == 1 && check == false) {
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(qrCodes.valueAt(0).displayValue);
                            try{
                                Intent intent = new Intent(scan1.this, ProductDetails.class);
                                int id = Integer.parseInt(qrCodes.valueAt(0).displayValue);
                                check = true;
                                intent.putExtra("ProductID", id);
                                startActivity(intent);
                            }
                            catch (Exception e){
                                Toast.makeText(scan1.this, "Mã sản phẩm không hợp lệ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
//     //Thêm action
//     @Override
//     public boolean onCreateOptionsMenu(Menu menu) {

//         getMenuInflater().inflate(R.menu.main, menu);
//         return super.onCreateOptionsMenu(menu);
//     }
//     //Sự kiện action bar
//     @Override
//     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//         switch (item.getItemId()) {
//             case R.id.action_search:
//                 Intent intentSearch = new Intent(scan1.this, ActivitySearch.class);
//                 startActivity(intentSearch);
//                 break;
//             case R.id.action_cart:
//                 Intent intentCart = new Intent(scan1.this, MainActivity.class);
//                 startActivity(intentCart);
//                 break;
//             case R.id.action_menu:
//                 Intent intentMenu = new Intent(scan1.this, MainMenu.class);
//                 startActivity(intentMenu);
//                 break;
//         }
//         return super.onOptionsItemSelected(item);
//     }
}
