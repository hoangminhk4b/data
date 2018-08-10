package com.example.hoangminhk4b.session3_activity.Session4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hoangminhk4b.session3_activity.ContactModel;
import com.example.hoangminhk4b.session3_activity.R;

import java.util.ArrayList;
import java.util.List;

public class ActivitySession4 extends AppCompatActivity {
    ListView listView;
    List<ContactModel> listData=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session4);

        listView=findViewById(R.id.listview);

        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listData.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));

        final ContactAdapter adapter=new ContactAdapter(listData,this);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listData.remove(i);
                adapter.notifyDataSetChanged();
                Log.d("Test","abc"+i);
            }
        });
    }
}
