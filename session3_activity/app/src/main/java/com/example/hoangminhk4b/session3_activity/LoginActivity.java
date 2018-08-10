package com.example.hoangminhk4b.session3_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hoangminhk4b.session3_activity.Session4.ActivitySession4;
import com.example.hoangminhk4b.session3_activity.Session5.Session5Activity;
import com.example.hoangminhk4b.session3_activity.Session6.Session6Activity;
import com.example.hoangminhk4b.session3_activity.Session7.Session7Activity;
import com.example.hoangminhk4b.session3_activity.Session8.Session8Activity;

public class LoginActivity extends AppCompatActivity {
    EditText edLogin;
    public static int KEY_MAIN_TO_LOGIN =9999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin=findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                String login=edLogin.getText().toString();
                intent.putExtra("KEY_LOGIN",login);
                startActivityForResult(intent,KEY_MAIN_TO_LOGIN);
            }
        });

        Button btnSession4=findViewById(R.id.btnSession4);
        btnSession4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,ActivitySession4.class);
                startActivity(intent);
            }
        });
        Button btnSession5=findViewById(R.id.btnSession5);
        btnSession5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,Session5Activity.class);
                startActivity(intent);
            }
        });
        Button btnSession6=findViewById(R.id.btnSession6);
        btnSession6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, Session6Activity.class);
                startActivity(intent);
            }
        });
        Button btnSession7=findViewById(R.id.btnSession7);
        btnSession7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, Session7Activity.class);
                startActivity(intent);
            }
        });
        Button btnSession8=findViewById(R.id.btnSession8);
        btnSession8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, Session8Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==KEY_MAIN_TO_LOGIN && resultCode == RESULT_OK){
            String result=data.getStringExtra("KEY_LOGIN_UPDATE");
            edLogin.setText(result);
        }
    }
}
