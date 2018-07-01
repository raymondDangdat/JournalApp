package com.example.raymond.journalapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import  android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Note.db", null, 1);
    }


    @Override
    public  void onCreate(SQLiteDatabase db){
    db.execSQL("create table user(title text primary key, note text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists user");

    }
    // inserting jn database
    public boolean insert(String title, String note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("note", note);
        long ins = db.insert("user", null, contentValues);
        if(ins == -1)return false;
        else return true;
    }
    // checking if title exist
    public Boolean checktitle(String title){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where title = ?", new String[]{title});
        if (cursor.getCount()>0) return false;
        else return true;
    }
}
