package com.example.hoangminhk4b.session3_activity.Session7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hoangminhk4b.session3_activity.R;
import com.example.hoangminhk4b.session3_activity.Utils.readHtmlDemo;

import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Session7Activity extends AppCompatActivity implements View.OnClickListener {
    readHtmlDemo readHtml=new readHtmlDemo();
    public final static String FILE_NAME="html.txt";
    public final static String FILE_PATH="/sdcard/Demo";
    EditText edText;
    Button btnSave;
    Button btnRead;
    RadioGroup radGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session7);

        edText=findViewById(R.id.edText);
        btnRead=findViewById(R.id.btnRead);
        btnSave=findViewById(R.id.btnSave);
        radGroup=findViewById(R.id.radGroup);

        new readHtmlDemo().execute("http://chiasenhac.vn");


        btnSave.setOnClickListener(this);
        btnRead.setOnClickListener(this);

    }

    public void onSaveInternal(){
        try {
            FileOutputStream fos=openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(edText.getText().toString().getBytes());
            fos.flush();
            fos.close();
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void onReadInternal(){
        try {
            FileInputStream fis=openFileInput(FILE_NAME);
            BufferedReader reader=new BufferedReader(new InputStreamReader(fis));
            StringBuffer sb=new StringBuffer();
            String line=reader.readLine();
            while (line !=null){
                sb.append(line);
                line=reader.readLine();
            }
            Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void onReadExternal(){
        File file =new File(FILE_PATH+FILE_NAME);
        try {
            FileInputStream fis=new FileInputStream(file);
            BufferedReader reader=new BufferedReader(new InputStreamReader(fis));
            StringBuffer sb=new StringBuffer();
            String line=reader.readLine();
            while (line!=null){
                sb.append(line);
                line=reader.readLine();
            }
            Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onSaveExternal(){
        File directory=new File(FILE_PATH);
        File file = new File(FILE_PATH+FILE_NAME);
        if(!directory.exists()){
            directory.mkdir();
        }
        try {
            file.createNewFile();
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(edText.getText().toString().getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        int idChecked=radGroup.getCheckedRadioButtonId();
        switch (view.getId()){
            case R.id.btnSave:
                if(idChecked==R.id.radInternal){
                    onSaveInternal();
                }else{
                    onSaveExternal();
                }
            case R.id.btnRead:
                if (idChecked==R.id.radInternal){
                    onReadInternal();
                }else {
                    onReadExternal();
                }
        }
    }
}
