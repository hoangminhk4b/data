package com.example.hoangminhk4b.fragmentdemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoangminhk4b.fragmentdemo.R;

public class FragmentNotification extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_notifications,container,false);

        return view;
    }
}
