package com.example.hoangminhk4b.fragmentdemo.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hoangminhk4b.fragmentdemo.R;

public class FragmentTab  extends Fragment {
    FragmentCalendar fragView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_tab,container,false);
        ImageView ivCalendar=view.findViewById(R.id.ivCalendar);
        ImageView ivChecklist=view.findViewById(R.id.ivChecklist);
        ImageView ivNotifications=view.findViewById(R.id.ivNotification);
        ImageView ivSetting=view.findViewById(R.id.ivSettings);

        fragView = new FragmentCalendar();

        ivCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragmentCalendar();
            }
        });
        ivChecklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragmentChecklist();
            }
        });
        ivNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragmentNotification();
            }
        });
        ivSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragmentSettings();
            }
        });

        return view;
    }
    private void changeFragmentCalendar(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.flView, fragView);
        transaction.addToBackStack(null);

        transaction.commit();
    }
    private void changeFragmentChecklist(){
        FragmentChecklist fragView = new FragmentChecklist();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.flView, fragView);
        transaction.addToBackStack(null);

        transaction.commit();
    }
    private void changeFragmentNotification(){
        FragmentNotification fragView = new FragmentNotification();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.flView, fragView);
        transaction.addToBackStack(null);

        transaction.commit();
    }
    private void changeFragmentSettings(){
        FragmentSettings fragView= new FragmentSettings();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.flView, fragView);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
