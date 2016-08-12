package com.example.dllo.thebeautiful.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.ui.fragment.DesignerFragment;
import com.example.dllo.thebeautiful.ui.fragment.MineFragment;
import com.example.dllo.thebeautiful.ui.fragment.PictorialFragment;
import com.example.dllo.thebeautiful.ui.fragment.ThingsFragment;

public class MainActivity extends AbsBaseActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;
    private PictorialFragment pictorialFragment;
    private ThingsFragment thingsFragment;
    private DesignerFragment designerFragment;
    private MineFragment mineFragment;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        radioGroup = byView(R.id.radiogroup_mainAty);
    }

    @Override
    protected void initDatas() {
        pictorialFragment = new PictorialFragment();
        thingsFragment = new ThingsFragment();
        designerFragment = new DesignerFragment();
        mineFragment = new MineFragment();

        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(R.id.rb_pictorial);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //通过FragmentActivity的getSupportFragmentManager的方法获取fragment
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (checkedId){
            case R.id.rb_pictorial:
                transaction.replace(R.id.framelayout_mainAty, pictorialFragment);
                break;
            case R.id.rb_things:
                transaction.replace(R.id.framelayout_mainAty, thingsFragment);
                break;
            case R.id.rb_designer:
                transaction.replace(R.id.framelayout_mainAty, designerFragment);
                break;
            case R.id.rb_mine:
                transaction.replace(R.id.framelayout_mainAty, mineFragment);
        }
        transaction.commit();
    }


}
