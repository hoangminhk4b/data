package com.example.hoangminhk4b.session3_activity.Session8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.hoangminhk4b.session3_activity.R;

import java.util.List;

public class Session8Activity extends AppCompatActivity {
    DBHelper db;
    List<User> listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session8);

        db=new DBHelper(this);
        db.getWritableDatabase();

        insertData();
//
        getAllUser();

//        updateDb();
//        deleteDB();
    }
    private void insertData(){
        User user = new User("Nguyen Van A",20);
        String msg=db.insertUSer(user);
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public void getAllUser() {
        listUser=db.getAllUser();
        for(User user:listUser){
            Log.d("DATABASE",user.getId()+","+user.getName()+","+user.getAge());
        }
    }
    public void updateDb(){
        User user=new User("1","Update",20);
        String msg=db.updateUser(user);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void deleteDB(){
        User user=new User("3","Update",20);
        String msg=db.deleteDB(user);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
