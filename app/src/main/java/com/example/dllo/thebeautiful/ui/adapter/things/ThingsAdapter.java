package com.example.dllo.thebeautiful.ui.adapter.things;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/16.
 */
public class ThingsAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titleList;

    public ThingsAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;

        titleList = new ArrayList<>();
        titleList.add("有物");
        titleList.add("包袋");
        titleList.add("鞋履");
        titleList.add("首饰");
        titleList.add("装饰");
        titleList.add("其他");
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
