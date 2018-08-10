package com.example.hoangminhk4b.project.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hoangminhk4b.project.Adapter.RecycleViewHomeAdapter;
import com.example.hoangminhk4b.project.Adapter.RecycleViewProductHomeAdapter;
import com.example.hoangminhk4b.project.Adapter.ViewPagerHomeAdapter;
import com.example.hoangminhk4b.project.Model.RecycleViewIconHomeModel;
import com.example.hoangminhk4b.project.Model.RecycleViewProductHomeModel;
import com.example.hoangminhk4b.project.Model.ViewPagerHomeModel;
import com.example.hoangminhk4b.project.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity  extends AppCompatActivity {
    ViewPager viewPager;
    List<ViewPagerHomeModel> viewPagerHome=new ArrayList<>();
    List<RecycleViewIconHomeModel> recycleViewHome=new ArrayList<>();
    List<RecycleViewProductHomeModel> recycleViewProductHomeModels=new ArrayList<>();
    CircleIndicator circleIndicator;
    int CurrentItem;
    Runnable runnable;
    Handler handler=new Handler();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager=findViewById(R.id.VPHome);
        circleIndicator=findViewById(R.id.circleIndicator);
        RecyclerView recyclerView=findViewById(R.id.rvHome);
        RecyclerView recycleViewProduct=findViewById(R.id.rvProduct);

        //set up View Pager Banner
        viewPagerHome.add(new ViewPagerHomeModel(R.drawable.banner_home));
        viewPagerHome.add(new ViewPagerHomeModel(R.drawable.hatoxu));


        ViewPagerHomeAdapter adapter=new ViewPagerHomeAdapter(HomeActivity.this,viewPagerHome);
        viewPager.setAdapter(adapter);
        setBannerTimeRun(3000,viewPager);

        circleIndicator.setViewPager(viewPager);

        //Set up RecycleView Icon Hozicontal
        recycleViewHome.add(new RecycleViewIconHomeModel("Túi sách",R.drawable.ic_tui));
        recycleViewHome.add(new RecycleViewIconHomeModel("Giầy",R.drawable.ic_shoes));
        recycleViewHome.add(new RecycleViewIconHomeModel("Quần",R.drawable.pant));
        recycleViewHome.add(new RecycleViewIconHomeModel("Ví",R.drawable.ic_wallet));
        recycleViewHome.add(new RecycleViewIconHomeModel("Váy",R.drawable.ic_dress));

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecycleViewHomeAdapter recycleViewHomeAdapter=new RecycleViewHomeAdapter(HomeActivity.this,recycleViewHome);
        recyclerView.setAdapter(recycleViewHomeAdapter);

        //Set up RecycleView Product

        recycleViewProductHomeModels.add(new RecycleViewProductHomeModel("http://www.virgo.vn/wp-content/uploads/2017/08/VG290.jpg","Túi hàng hiệu",20000));
        recycleViewProductHomeModels.add(new RecycleViewProductHomeModel("https://www.lazio.vn/wp-content/uploads/2013/06/tui-du-lich-da-bo-that2.jpg","Túi sách nam",20000));
        recycleViewProductHomeModels.add(new RecycleViewProductHomeModel("http://kprocamera.com/image/cache/data/tui_may_anh/tui_crumpler_jack_pack4000_4-800x800.jpg","Túi đeo máy ảnh",20000));
        recycleViewProductHomeModels.add(new RecycleViewProductHomeModel("https://banbuonsieure.com/wp-content/uploads/2018/03/Tui-xach-du-lich-pink-cao-cap-4.jpg","Túi du lịch",20000));

        recycleViewProductHomeModels.add(new RecycleViewProductHomeModel("http://www.virgo.vn/wp-content/uploads/2017/08/VG290.jpg","Túi hàng hiệu",20000));
        recycleViewProductHomeModels.add(new RecycleViewProductHomeModel("https://www.lazio.vn/wp-content/uploads/2013/06/tui-du-lich-da-bo-that2.jpg","Túi sách nam",20000));
        recycleViewProductHomeModels.add(new RecycleViewProductHomeModel("http://kprocamera.com/image/cache/data/tui_may_anh/tui_crumpler_jack_pack4000_4-800x800.jpg","Túi đeo máy ảnh",20000));
        recycleViewProductHomeModels.add(new RecycleViewProductHomeModel("https://banbuonsieure.com/wp-content/uploads/2018/03/Tui-xach-du-lich-pink-cao-cap-4.jpg","Túi du lịch",20000));

        recycleViewProductHomeModels.add(new RecycleViewProductHomeModel("http://www.virgo.vn/wp-content/uploads/2017/08/VG290.jpg","Túi hàng hiệu",20000));
        recycleViewProductHomeModels.add(new RecycleViewProductHomeModel("https://www.lazio.vn/wp-content/uploads/2013/06/tui-du-lich-da-bo-that2.jpg","Túi sách nam",20000));
        recycleViewProductHomeModels.add(new RecycleViewProductHomeModel("http://kprocamera.com/image/cache/data/tui_may_anh/tui_crumpler_jack_pack4000_4-800x800.jpg","Túi đeo máy ảnh",20000));
        recycleViewProductHomeModels.add(new RecycleViewProductHomeModel("https://banbuonsieure.com/wp-content/uploads/2018/03/Tui-xach-du-lich-pink-cao-cap-4.jpg","Túi du lịch",20000));

//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
//        recycleViewProduct.setLayoutManager(gridLayoutManager);
//        recycleViewProduct.setNestedScrollingEnabled(false);

        LinearLayoutManager linearLayoutManagerProduct=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recycleViewProduct.setLayoutManager(linearLayoutManagerProduct);


        RecycleViewProductHomeAdapter recycleViewProductHomeAdapter=new RecycleViewProductHomeAdapter(this,recycleViewProductHomeModels);
        recycleViewProduct.setAdapter(recycleViewProductHomeAdapter);


    }
    public void setBannerTimeRun(final int timeMillisecons, final ViewPager view){
        runnable=new Runnable() {
            @Override
            public void run() {
                CurrentItem =view.getCurrentItem();
                CurrentItem++;
                if(CurrentItem>=view.getAdapter().getCount()){
                    CurrentItem=0;
                }
                view.setCurrentItem(CurrentItem);
                handler.postDelayed(runnable,timeMillisecons);
            }
        };
        handler.postDelayed(runnable,timeMillisecons);
    }
}
