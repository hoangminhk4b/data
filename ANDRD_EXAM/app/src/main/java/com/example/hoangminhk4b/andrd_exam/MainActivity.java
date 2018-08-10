package com.example.hoangminhk4b.andrd_exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hoangminhk4b.andrd_exam.Database.DBHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DBHelper db;
    private EditText edUsername;
    private EditText edEmail;
    private Spinner spinner;
    private EditText edDes;
    private CheckBox ck;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        db=new DBHelper(this);
        db.getReadableDatabase();

        send.setOnClickListener(this);

    }
    private void initView(){
        edUsername=findViewById(R.id.edUsername);
        edEmail=findViewById(R.id.edEmail);
        edDes=findViewById(R.id.edDes);
        spinner=findViewById(R.id.spiner);
        ck=findViewById(R.id.ck);
        send=findViewById(R.id.btnSend);

        String[] dep={"Gripe","YAMAHA","HONDA"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,dep);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void onRegister() {
        if(edUsername.getText().toString().isEmpty()){
            Toast.makeText(this,"Please enter username",Toast.LENGTH_SHORT).show();
            return;
        }
        if(edEmail.getText().toString().isEmpty()){
            Toast.makeText(this,"Please enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(edDes.getText().toString().isEmpty()){
            Toast.makeText(this,"Please enter description",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!ck.isChecked()){
            Toast.makeText(this,"Please check email response",Toast.LENGTH_SHORT).show();
            return;
        }
        int idAdd=db.inserData(edUsername.getText().toString(),edEmail.getText().toString(),spinner.getSelectedItem().toString(),edDes.getText().toString());

        Toast.makeText(this,"You have "+idAdd+" records stored in the database",Toast.LENGTH_SHORT).show();

        edUsername.setText("");
        edEmail.setText("");
        spinner.setSelection(0);
        edDes.setText("");
        ck.setChecked(false);
    }

    @Override
    public void onClick(View view) {
        if(view == send){
            onRegister();
        }
    }
}
