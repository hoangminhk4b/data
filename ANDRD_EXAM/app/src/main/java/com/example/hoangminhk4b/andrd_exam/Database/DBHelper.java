package com.example.hoangminhk4b.andrd_exam.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class DBHelper extends SQLiteOpenHelper {
    public static final String TBL_NAME="ANDRD";
    public static final int VERSION=1;
    public static final String ID="_id";
    public static final String USERNAME="username";
    public static final String EMAIL="email";
    public static final String DEP="dep";
    public static final String DES="des";
    public DBHelper(Context context) {
        super(context, TBL_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE "+TBL_NAME+" ("+
                ID+" INTEGER PRIMARY KEY, "+
                USERNAME+" TEXT, "+
                EMAIL+" TEXT, "+
                DEP+" TEXT, "+
                DES+" TEXT )";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public int inserData(String username,String email,String dep,String des){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(USERNAME,username);
        cv.put(EMAIL,email);
        cv.put(DEP,dep);
        cv.put(DES,des);
        db.insert(TBL_NAME,null,cv);
        int count=countData();
        return count;

    }
    public int countData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="SELECT * FROM "+TBL_NAME;
        Cursor c=db.rawQuery(sql,null);
        int count=c.getCount();
        return count;
    }
}
