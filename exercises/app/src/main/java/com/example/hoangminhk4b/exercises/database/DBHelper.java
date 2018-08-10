package com.example.hoangminhk4b.exercises.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="USERS";
    public static final int DB_SERSION=1;

    public static final String TABLE_NAME="TBL_USER";
    public static final String ID="_id";
    public static final String NAME="name";
    public static final String GENDER="gender";
    public static final String DES="des";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_SERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE "+TABLE_NAME+" ( "+
                ID+" INTEGER PRIMARY KEY, "+
                NAME +" TEXT,"+
                GENDER+" TEXT,"+
                DES+" TEXT) ";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql="DROP TABLE IF EXISTS "+TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);

    }
    public String addUser(String user,String gender,String des){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME,user);
        cv.put(GENDER,gender);
        cv.put(DES,des);
        long isAdd=db.insert(TABLE_NAME,null,cv);
        if(isAdd==-1){
            return "Add Fail";
        }else{
            return "Add Success";
        }
    }
    public String updateUser(int id,String user,String gender,String des){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME,user);
        cv.put(GENDER,gender);
        cv.put(DES,des);
        long isUpdate=db.update(TABLE_NAME,cv,ID+"=?",new String[] {id+""});
        if(isUpdate>0){
            return "Update Success";
        }else {
            return "Update Fail";
        }
    }
    public String deleteUSer(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        int isDelete=db.delete(TABLE_NAME,"ID="+id,null);
        if(isDelete>0){
            return "Delete Success";
        }else{
            return "Delete Fail";
        }
    }
    public Cursor getAllUser(){
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="SELECT * FROM "+TABLE_NAME;
        Cursor c=db.rawQuery(sql,null);
        return c;
    }
}
