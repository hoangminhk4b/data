package com.example.hoangminhk4b.session3_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView edupdate;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle","OnCreate");
        Intent intent=getIntent();
        String login=intent.getStringExtra("KEY_LOGIN");
        TextView tv=findViewById(R.id.tvUserName);
        tv.setText(login);

        Button btnResult=findViewById(R.id.btnResult);
        edupdate=findViewById(R.id.edUpdate);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("KEY_LOGIN_UPDATE",edupdate.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        listView=findViewById(R.id.listview);
        final String[] datas={"SamSung","LG","HTC","Nokia","Apple","SamSung","LG","HTC","Nokia","Apple","SamSung","LG","HTC","Nokia","Apple"};

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,datas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String model=datas[i];
                edupdate.setText(model);
                Toast.makeText(MainActivity.this,model,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","onDestroy");
    }
}
