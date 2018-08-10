package com.example.hoangminhk4b.fragmentdemo;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.hoangminhk4b.fragmentdemo.fragment.FragmentCalendar;
import com.example.hoangminhk4b.fragmentdemo.fragment.FragmentTab;

public class MainActivity extends AppCompatActivity {

    FrameLayout flView;
    FrameLayout flTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragmentTab();
        replaceFragmentView();
    }
    public void replaceFragmentTab(){
        FragmentTab fragTab = new FragmentTab();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.flTab, fragTab);

        transaction.commit();

    }
    public void replaceFragmentView(){
        FragmentCalendar fragView = new FragmentCalendar();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.flView, fragView);

        transaction.commit();
    }


}
