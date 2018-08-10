package com.example.hoangminhk4b.appnhac.app.Activity;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.hoangminhk4b.appnhac.R;
import com.example.hoangminhk4b.appnhac.app.Adapter.MainViewPapperAdapter;
import com.example.hoangminhk4b.appnhac.app.Frament.Fragment_Home;
import com.example.hoangminhk4b.appnhac.app.Frament.Fragment_Search;
import com.example.hoangminhk4b.appnhac.app.Utils.ListMusicJsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();
        init();
        JsoupConnect();
    }

    private void init() {
        MainViewPapperAdapter mainViewPapperAdapter=new MainViewPapperAdapter(getSupportFragmentManager());
        mainViewPapperAdapter.addFragment(new Fragment_Home(),"Home");
        mainViewPapperAdapter.addFragment(new Fragment_Search(),"Search");
        viewPager.setAdapter(mainViewPapperAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
    }

    private void anhxa() {
        tabLayout=findViewById(R.id.tlTab);
        viewPager=findViewById(R.id.vpView);
    }

    private void JsoupConnect(){
        new Thread(new Runnable() {
            Document doc=null;
            @Override
            public void run() {
                ListMusicJsoup listMusicJsoup=new ListMusicJsoup("http://chiasenhac.vn");

                try {
                    doc=listMusicJsoup.getDocumentHTML();
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Element links = doc.body();
//                            Log.d("abc", links.toString());;
//                        }
//                    });
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Element links = doc.body();
                            Log.d("abc",links.toString());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
