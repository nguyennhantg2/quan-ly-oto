package com.example.qlyoto.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.qlyoto.database.MyHelper;
import com.example.qlyoto.model.Oto;

import java.security.acl.NotOwnerException;
import java.util.ArrayList;
import java.util.List;

public class OtoDao {
    private SQLiteDatabase sqLiteDatabase;
    private MyHelper myHelper;

    public OtoDao (Context context){
        myHelper = new MyHelper(context);
    }

    public List<Oto> getListAllOto() {
        List<Oto> list = new ArrayList<>();
        String sql = "Select * from Oto";
        sqLiteDatabase = myHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Oto oto = new Oto();
                oto.setId(cursor.getInt(0));
                oto.setHang(cursor.getString(1));
                oto.setGia(cursor.getInt(2));
                oto.setModel(cursor.getString(3));
                list.add(oto);
                cursor.moveToNext();
            }
        }
        cursor.close();
        sqLiteDatabase.close();
        return list;
    }

    public boolean addOto(Oto oto) {
        sqLiteDatabase = myHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hang", oto.getHang());
        contentValues.put("gia", oto.getGia());
        contentValues.put("model", oto.getModel());
        long insert = sqLiteDatabase.insert("Oto", null, contentValues);
        if (insert <= 0) {
            return false;
        }
        return true;
    }

    public boolean deleteOto(int id){
        sqLiteDatabase = myHelper.getWritableDatabase();
        return sqLiteDatabase.delete("Oto" , "id=?" , new String[]{String.valueOf(id)}) > 0;
    }

    public boolean editOto(Oto oto){
        sqLiteDatabase = myHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hang", oto.getHang());
        contentValues.put("gia", oto.getGia());
        contentValues.put("model", oto.getModel());
        long insert = sqLiteDatabase.update("Oto",  contentValues ,"id=?" ,new String[]{String.valueOf(oto.getId())}  );
        if (insert <= 0) {
            return false;
        }
        return true;
    }


}
