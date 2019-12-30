package com.example.ashik.studentbudgetmanagement;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.key;
import static android.provider.Contacts.SettingsColumns.KEY;
import static com.example.ashik.studentbudgetmanagement.R.drawable.transport;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="showExpenses";
    private static final String TABLE_NAME="expenses_table";
    private static final String KEY_FOODING="fooding";
    private static final String KEY_RECHARGE="recharge";
    private static final String KEY_SHOPPING="shopping";
    private static final String KEY_TRANSPORT="transport";
    private static final String KEY_EXCHANGE="exchange";
    private static final String KEY_OTHER="other";
    private static final String KEY_SERIAL ="serial";


    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table " + TABLE_NAME +" (serial INTEGER PRIMARY KEY AUTOINCREMENT,fooding TEXT,recharge TEXT,shopping TEXT,transport TEXT,exchange TEXT,other TEXT ) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean updateData(String fooding,String recharge,String shopping,String transport,String exchange,String other){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(KEY_FOODING,fooding);
        value.put(KEY_RECHARGE,recharge);
        value.put(KEY_SHOPPING,shopping);
        value.put(KEY_TRANSPORT,transport);
        value.put(KEY_EXCHANGE,exchange);
        value.put(KEY_OTHER,other);

        int result = db.update(TABLE_NAME,value,"KEY_FOODING =?",new String[]{fooding});
        if(result>0){
            return false;
        }else {
            return false;
        }

    }

   public boolean insertData(String fooding,String recharge,String shopping,String transport,String exchange,String other) {
       SQLiteDatabase db = this.getWritableDatabase();

       ContentValues value = new ContentValues();
       value.put(KEY_FOODING, fooding);
       value.put(KEY_RECHARGE, recharge);
       value.put(KEY_SHOPPING, shopping);
       value.put(KEY_TRANSPORT, transport);
       value.put(KEY_EXCHANGE, exchange);
       value.put(KEY_OTHER, other);
       long result = db.insert(TABLE_NAME, null, value);
       if (result == -1)
           return false;
       else
           return true;
   }


   public Cursor viewData(){
       SQLiteDatabase db = this.getWritableDatabase();
       Cursor res = db.rawQuery("select * from "+ TABLE_NAME,null);
       return res;

   }

}
