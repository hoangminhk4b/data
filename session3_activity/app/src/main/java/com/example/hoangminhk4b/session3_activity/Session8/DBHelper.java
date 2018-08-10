package com.example.hoangminhk4b.session3_activity.Session8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="user.db";
    public static final int DB_VERSION=1;
    public static final String TABLE_NAME="TBL_USER";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String SQL="CREATE TABLE TBL_USER(id INTEGER  PRIMARY KEY,name text, age INTEGER)";
        SQLiteDatabase.openDatabase("/sdcard/data",null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String sql="CREATE TABLE "+TABLE_NAME+"("+
                TBL_USER.id+" INTEGER PRIMARY KEY, "+
                TBL_USER.name +" text, " +
                TBL_USER.age + " INTEGER )";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public String insertUSer(User user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TBL_USER.name,user.getName());
        cv.put(TBL_USER.age,user.getAge());

        Long isSuccess=db.insert(TABLE_NAME,null,cv);
        if(isSuccess>0){
            return "Success";
        }else{
            return "False";
        }
    }
    public List<User> getAllUser(){
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="SELECT * FROM " +TABLE_NAME;
        Cursor cursor=db.rawQuery(sql,null);

        List<User> listUser=new ArrayList<>();

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                User user =new User();
                user.setId(cursor.getString(cursor.getColumnIndex(TBL_USER.id)));
                user.setAge(cursor.getInt(cursor.getColumnIndex(TBL_USER.age)));
                user.setName(cursor.getString(cursor.getColumnIndex(TBL_USER.name)));
                listUser.add(user);
            }while (cursor.moveToNext());
        }
        return listUser;
    }
    public String updateUser(User user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TBL_USER.name,user.getName());
        int isSuccess=db.update(TABLE_NAME,cv,"id="+user.getId(),null);
//        db.update(TABLE_NAME,cv,"id=?",new String[]{user.getId()+""});
        if(isSuccess>0){
            return "Success";
        }else{
            return "False";
        }
    }
    public String deleteDB(User user){
        SQLiteDatabase db=this.getWritableDatabase();
        int isSuccess=db.delete(TABLE_NAME,"id="+user.getId(),null);
        if(isSuccess>0){
            return "Success";
        }else{
            return "False";
        }
    }
}
