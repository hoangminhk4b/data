package com.example.hoangminhk4b.exercises.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hoangminhk4b.exercises.R;
import com.example.hoangminhk4b.exercises.database.DBHelper;

public class UpdateAct extends AppCompatActivity implements View.OnClickListener {

    private DBHelper db;
    private int id;
    private EditText edName;
    private EditText edGender;
    private EditText edDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        db = new DBHelper(this);

        initView();

        Intent intent = getIntent();
        id = intent.getIntExtra(DBHelper.ID, 0);
        String name = intent.getStringExtra(DBHelper.NAME);
        String gender = intent.getStringExtra(DBHelper.GENDER);
        String des = intent.getStringExtra(DBHelper.DES);

        edName.setText(name);
        edGender.setText(gender);
        edDes.setText(des);
    }

    private void initView() {
        edName = findViewById(R.id.edName);
        edGender = findViewById(R.id.edGender);
        edDes = findViewById(R.id.edDes);

        Button update = findViewById(R.id.btnUpdate);
        update.setOnClickListener(this);

        Button delete = findViewById(R.id.btnUpdate);
        delete.setOnClickListener(this);
    }

    private void onUpdate() {
        String isUpade = db.updateUser(id, edName.getText().toString(), edGender.getText().toString(), edDes.getText().toString());
        Toast.makeText(this, isUpade, Toast.LENGTH_SHORT).show();
        finish();
    }

    private void onDelete(){
        Toast.makeText(this, db.deleteUSer(id),Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnUpdate:
                onUpdate();
                break;
            case R.id.btnDelete:
                onDelete();
                break;
            default:
                break;
        }
    }
}
