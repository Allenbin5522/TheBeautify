package com.example.dllo.thebeautiful.ui.activity.mine;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;
import com.example.dllo.thebeautiful.ui.adapter.mine.CollectionAdapter;
import com.example.dllo.thebeautiful.ui.fragment.CollectionFragment;
import com.example.dllo.thebeautiful.ui.fragment.PraiseFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/13.
 * 我 -> 收藏的画报 界面
 */
public class CollectionActivity extends AbsBaseActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView imageView_return; // 返回键

    @Override
    protected int setLayout() {
        return R.layout.activity_collection;
    }

    @Override
    protected void initViews() {
        tabLayout = byView(R.id.tablayout_collection);
        viewPager = byView(R.id.viewpager_collection);
        imageView_return = byView(R.id.iv_collection_return);
    }

    @Override
    protected void initDatas() {
        ArrayList<Fragment> arrayList = new ArrayList<>();
        arrayList.add(new CollectionFragment());
        arrayList.add(new PraiseFragment());
        CollectionAdapter adapter = new CollectionAdapter(getSupportFragmentManager(), arrayList);
        viewPager.setAdapter(adapter);
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE); // 文字的颜色
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);  // 滑动条的颜色
        tabLayout.setupWithViewPager(viewPager);
        imageView_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_collection_return:
                finish();
                break;
        }
    }
}
