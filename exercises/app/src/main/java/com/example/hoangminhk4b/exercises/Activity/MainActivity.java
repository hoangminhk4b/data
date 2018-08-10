package com.example.hoangminhk4b.exercises.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hoangminhk4b.exercises.R;
import com.example.hoangminhk4b.exercises.database.DBHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edName;
    private EditText edDes;
    private Button btnRegister;
    private Spinner spinner;
    private DBHelper db;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        db=new DBHelper(this);
        db.getReadableDatabase();
    }

    private void initView() {
        edName=findViewById(R.id.edUsername);
        edDes=findViewById(R.id.description);
        btnRegister=findViewById(R.id.btnRegister);
        checkBox=findViewById(R.id.ck);
        btnRegister.setOnClickListener(this);

        String[] genders={"Male","Female","Unknown"};
        spinner =findViewById(R.id.spiner);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,genders);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onClick(View view) {

        if(view==btnRegister){
            onRegister();
        }
    }

    private void onRegister() {
        if(edName.getText().toString().isEmpty()){
            Toast.makeText(this,"Please enter username",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!checkBox.isChecked()){
            Toast.makeText(this,"Please agree rules",Toast.LENGTH_SHORT).show();
            return;
        }
        String idAdd=db.addUser(edName.getText().toString(),spinner.getSelectedItem().toString(),edDes.getText().toString());
        Toast.makeText(this,idAdd,Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,ActivityListUser.class);
        startActivity(intent);
    }
}
