package com.example.hoangminhk4b.fragmentdemo.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.VideoView;

import com.example.hoangminhk4b.fragmentdemo.DownloadAdapter;
import com.example.hoangminhk4b.fragmentdemo.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FragmentCalendar extends Fragment {
    public static final String URL="https://mp3.zing.vn/xhr/media/download-source?type=audio&code=LmxmTkmNJLgGRuQyZyvnkHyZpdBXdJVFJ&sig=e4ca22248e3466de0ff9db3772876f40";
    ListView listView;
    List<String> data=new ArrayList<>();
    View view;
    private DownloadAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
        view=inflater.inflate(R.layout.fragment_calendar,container,false);
        listView=view.findViewById(R.id.lvItem);

        data.add(URL);

        adapter=new DownloadAdapter(getActivity(),data);
        listView.setAdapter(adapter);
        }
        adapter.notifyDataSetChanged();
        return view;
    }

    private void downloadFile() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient httpClient=new OkHttpClient();
                Request request=new Request.Builder().url(URL).build();

                Response response=null;

                try {
                    response=httpClient.newCall(request).execute();
                    Log.d("abc",response.body().contentLength()+"");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

}
