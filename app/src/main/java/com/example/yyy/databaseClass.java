package com.example.yyy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class databaseClass  extends SQLiteOpenHelper {
    Context context;
    public  static  final  int DTABASE_VERSION=1;
    public  static  final  String DATABSE_NAME="food";
    public  static  final  String  TABLE_NAME ="fooddb";
    public static  final  String Column_ID="id";
    public static  final  String  Column_name="name";
    public static  final String Column_phone="phone";
    public static  final String Column_price="price";
    public static  final String Column_image = "image";
    public static  final String Column_fdname =  "foodname";
    private static final String Column_quantity="quantity";
    public static  final String CREATE_TABLE="CREATE TABLE "
            + TABLE_NAME +
            "(" + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            Column_name +  " TEXT ," +
            Column_phone +  " TEXT ," +
            Column_price +  " INT ," +
            Column_image +  " INT ," +
            Column_quantity +  " INT ," +
            Column_fdname + " TEXT "+ ")" ;
    public databaseClass(Context context) {
        super(context, DATABSE_NAME, null, DTABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public  void addfood(String name,String phone, int price,int image, String fooodname,int quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Column_name,name);
        values.put(Column_phone,phone);
        values.put(Column_price,price);
        values.put(Column_image,image);
        values.put(Column_fdname,fooodname);
        values.put(Column_quantity,quantity);
        long result= db.insert(TABLE_NAME,null,values);

        if(result==-1){
            Toast.makeText(context,"Not ADD",Toast.LENGTH_SHORT).show();


        }else {
            Toast.makeText(context, "Data Add", Toast.LENGTH_SHORT).show();
        }

    }
    public ArrayList<ordermodal> orders(){
        ArrayList<ordermodal> orders = new ArrayList<>();
        String query="SELECT "+Column_ID +","+ Column_fdname+","+Column_image+","+Column_price+ " FROM "+TABLE_NAME;
        SQLiteDatabase database= this.getReadableDatabase();
        Cursor cursor= database.rawQuery(query,null);
//        if(database!=null){
//            cursor= database.rawQuery(query,null);
//
//        }
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){

                ordermodal ordermodal= new ordermodal();

                ordermodal.setOrdeernumber(cursor.getInt(0)+"");
                ordermodal.setSoliditems(cursor.getString(1));
                ordermodal.setOrderimage(cursor.getInt(2));
                ordermodal.setPriceorder(cursor.getInt(3)+"");
                orders.add(ordermodal);



            }

        }
        cursor.close();
        database.close();

return orders;


    }

    public  void  deleteitem(int Id){
        SQLiteDatabase database= this.getWritableDatabase();
        String query= " WHERE "+ Column_ID + " = " + Id;
        database.delete(TABLE_NAME,Column_ID+ " = " + Id,null);
        database.close();


    }
    public  void  Update(int Id){
        SQLiteDatabase database= this.getWritableDatabase();
        String query= " WHERE "+ Column_ID + " = " + Id;
        database.update(TABLE_NAME,Column_ID+ " = " + Id,null);
        database.close();


    }

}
