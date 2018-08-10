package com.example.hoangminhk4b.session3_activity.Session5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.hoangminhk4b.session3_activity.ContactModel;
import com.example.hoangminhk4b.session3_activity.R;
import com.example.hoangminhk4b.session3_activity.Session5.ContactAdapter5;

import java.util.ArrayList;
import java.util.List;

public class Session5Activity extends AppCompatActivity {

    RecyclerView rvContact;
    private List<ContactModel> listContact=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session5);
        rvContact=findViewById(R.id.recView);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvContact.setLayoutManager(layoutManager);

//        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,2);
//        rvContact.setLayoutManager(layoutManager);

        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));
        listContact.add(new ContactModel("Nguyen Van A","0909090909",R.drawable.ic_launcher_background));

        ContactAdapter5 adapter=new ContactAdapter5(listContact,this);

        rvContact.setAdapter(adapter);
        adapter.registerLister(new ContactAdapter5.IOnItemClickListener() {
            @Override
            public void OnClickItem(int position) {
                ContactModel model=listContact.get(position);
                TextView btn=findViewById(R.id.tvChange);
                btn.setText(model.getName());
            }

            @Override
            public void OnClickButton(int position) {

            }
        });

    }
}
