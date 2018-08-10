package com.example.hoangminhk4b.appnhac.app.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainViewPapperAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayFrament=new ArrayList<>();
    private ArrayList<String> arrayTitle=new ArrayList<>();
    public MainViewPapperAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayFrament.get(position);
    }

    @Override
    public int getCount() {
        return arrayFrament.size();
    }
    public void addFragment(Fragment fragment,String title){
        arrayFrament.add(fragment);
        arrayTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayTitle.get(position);
    }
}
