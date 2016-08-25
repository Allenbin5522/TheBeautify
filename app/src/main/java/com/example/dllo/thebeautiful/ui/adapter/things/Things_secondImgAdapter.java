package com.example.dllo.thebeautiful.ui.adapter.things;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.thebeautiful.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/8/18.
 */
public class Things_secondImgAdapter extends PagerAdapter{
    private Context context;
    private List<String> imgUrls;

    public Things_secondImgAdapter(Context context, List<String> imgUrls) {
        this.context = context;
        this.imgUrls = imgUrls;
    }

    @Override
    public int getCount() {
        return imgUrls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_things_second_vp_imgs, container, false);
        ImageView iv_vp = (ImageView) view.findViewById(R.id.iv_item_things_second_vp);
        Picasso.with(context).load(imgUrls.get(position)).into(iv_vp);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }


}
