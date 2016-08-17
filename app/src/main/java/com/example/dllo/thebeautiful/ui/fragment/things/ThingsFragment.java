package com.example.dllo.thebeautiful.ui.fragment.things;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.net.URLValues;
import com.example.dllo.thebeautiful.ui.adapter.things.ThingsAdapter;
import com.example.dllo.thebeautiful.ui.fragment.AbsBaseFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/12.
 * 有物界面
 */
public class ThingsFragment extends AbsBaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;

    @Override
    protected int setLayout() {
        return R.layout.fragment_things;
    }

    @Override
    protected void initViews() {
        tabLayout = ByView(R.id.tablayout_things);
        viewPager = ByView(R.id.viewpager_things);
    }

    @Override
    protected void initDatas() {
        fragments = new ArrayList<>();
        fragments.add(new Things_thingsFragment());
        fragments.add(Things_othersFragments.getFragments(URLValues.THINGS_BAG));
        fragments.add(Things_othersFragments.getFragments(URLValues.THINGS_SHOES));
        fragments.add(Things_othersFragments.getFragments(URLValues.THINGS_JEWELRY));
        fragments.add(Things_othersFragments.getFragments(URLValues.THINGS_ACCESSORY));
        fragments.add(Things_othersFragments.getFragments(URLValues.THINGS_OTHERS));

        ThingsAdapter adapter = new ThingsAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
//        viewPager.setOffscreenPageLimit(5);
        tabLayout.setupWithViewPager(viewPager);

    }


}
