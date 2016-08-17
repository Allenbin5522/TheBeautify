package com.example.dllo.thebeautiful.ui.adapter.things;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_thingsBean;
import com.example.dllo.thebeautiful.view.CenterTextView;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/16.
 */
public class Things_thingsAdapter extends BaseAdapter{

    private Context context;
    private Things_thingsBean bean;

    public Things_thingsAdapter(Context context) {
        this.context = context;
    }

    public void setBean(Things_thingsBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean != null ? bean.getData().getActivities().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return bean;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_things_thingsfragment, null);
            holder = new MyHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
        }
        Picasso.with(context).load(bean.getData().getActivities().get(position).getImages().get(0)).config(Bitmap.Config.RGB_565).resize(480, 320).into(holder.iv_things);
        Picasso.with(context).load(bean.getData().getActivities().get(position).getDesigner().getAvatar_url()).config(Bitmap.Config.RGB_565).resize(480, 320).into(holder.civ_things);
        holder.tv_name.setText(bean.getData().getActivities().get(position).getDesigner().getName());
        holder.tv_label.setText(bean.getData().getActivities().get(position).getDesigner().getLabel());
        holder.tv_digest.setText(bean.getData().getActivities().get(position).getDigest());
        return convertView;
    }

    class MyHolder {
        private ImageView iv_things;
        private CircleImageView civ_things;
        private TextView tv_name, tv_label;
        private CenterTextView tv_digest;
        public MyHolder(View itemView){
            iv_things = (ImageView) itemView.findViewById(R.id.iv_things_things);
            civ_things = (CircleImageView) itemView.findViewById(R.id.civ_things_things);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name_things_things);
            tv_label = (TextView) itemView.findViewById(R.id.tv_label_things_things);
            tv_digest = (CenterTextView) itemView.findViewById(R.id.tv_digest_things_things);
        }
    }


}
