package com.example.dllo.thebeautiful.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/13.
 * 我 -> 收藏的画报 的适配器
 */
public class CollectionAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> arrayList;
    private ArrayList<String> titleList;

    public CollectionAdapter(FragmentManager fm,ArrayList<Fragment> arrayList) {
        super(fm);
        this.arrayList = arrayList;
        titleList = new ArrayList<>();
        titleList.add("收藏的");
        titleList.add("赞过的");

    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList != null ? arrayList.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
