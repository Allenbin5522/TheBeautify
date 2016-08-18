package com.example.dllo.thebeautiful.ui.adapter.things;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_secondBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/18.
 */
public class Things_secondLsAdapter extends BaseAdapter{

    private Context context;
    private Things_secondBean secondBean;

    public Things_secondLsAdapter(Context context) {
        this.context = context;
    }

    public void setSecondBean(Things_secondBean secondBean) {
        this.secondBean = secondBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return secondBean.getData().getImages() != null ? secondBean.getData().getImages().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return secondBean.getData().getImages() != null ? secondBean.getData().getImages() : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_things_second_imgs, parent, false);
            holder = new MyHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
        }
        Picasso.with(context).load(secondBean.getData().getImages().get(position)).into(holder.iv_ls);
        return convertView;
    }

    class MyHolder{
        private ImageView iv_ls;
        public MyHolder(View itemView) {
            iv_ls = (ImageView) itemView.findViewById(R.id.iv_item_things_second_ls);
        }
    }

}
