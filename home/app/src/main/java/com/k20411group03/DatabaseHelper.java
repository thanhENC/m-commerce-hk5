package com.k20411group03;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.k20411group03.home.R;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Tên CSDL có thể đặt là .splite hoặc .db
    public static final String DB_NAME = "phuongthucthanhtoan.sqlite";

    public static final int DB_VERSION = 1;

    public static final String TBL_NAME = "PaymentMethod";
    public static final String COL_ID = "PaymentMethodID";
    public static final String COL_NAME = "PaymentName";
    public static final String COL_NOTE = "PaymentNote";
    public static final String COL_IMAGE = "PaymentImage";

    //Nhấn Alt + Enter vào dòng SQLiteOpenHelper để generate phương thức này:

    //Xóa bớt các biến không cần thiết, chỉ giữ lại @Nullable
    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //Tạo bảng:
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME +
                " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " VARCHAR(50), " +
                COL_NOTE + " VARCHAR(100), " +
                COL_IMAGE + " INTEGER)";

        //Dùng câu lệnh thực thi SQL:
        sqLiteDatabase.execSQL(sql);
    }

    //Upgrade CSDL lên:
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }

    //Câu lệnh Select:
    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    //Câu lệnh Insert, Update, Delete:
    public void execSql(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    //Kiểm tra xem table có dữ liệu chưa:
    public int numbOfRows(){
        Cursor cursor = getData("SELECT * FROM " + TBL_NAME);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    //Tạo Sample data:
    public void createSampleData(){
        if(numbOfRows() == 0){
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Thanh toán tiền mặt', 'Thanh toán khi nhận hàng', " + R.drawable.payment_cash + ")");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Ví Momo', 'Giao dịch chỉ với 1,52 giây', " + R.drawable.payment_momo + ")");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Ví ZaloPay', 'Giảm 10K cho khách hàng mới', " + R.drawable.payment_zalo + ")");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Ví Moca | Grab', 'Giảm 15K cho khách hàng mới', " + R.drawable.payment_moca + ")");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'VNPay', 'Thanh toán qua ứng dụng ngân hàng', " + R.drawable.payment_vnpay + ")");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'ViettelPay', 'Liên kết ngay', " + R.drawable.payment_viettelpay + ")");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Thẻ ATM/ Internet Banking', 'Hỗ trợ hơn 20 ngân hàng', " + R.drawable.payment_banking + ")");
        }

    }
}
