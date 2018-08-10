package com.example.hoangminhk4b.project.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hoangminhk4b.project.Model.ViewPagerHomeModel;
import com.example.hoangminhk4b.project.R;

import java.util.List;

public class ViewPagerHomeAdapter extends PagerAdapter {
    Activity activity;
    List<ViewPagerHomeModel> listPager;

    public ViewPagerHomeAdapter(Activity context, List<ViewPagerHomeModel> listPager) {
        this.activity = context;
        this.listPager = listPager;
    }

    View view;
    @Override
    public int getCount() {
        return listPager.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater= activity.getLayoutInflater();
        view =inflater.inflate(R.layout.item_pager_home,container,false);
        ImageView img=view.findViewById(R.id.ivPager);

        Glide.with(activity).load(listPager.get(position).getImg()).into(img);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(view);
    }
}
