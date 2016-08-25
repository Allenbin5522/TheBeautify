package com.example.dllo.thebeautiful.ui.adapter.things;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_popBean;
import com.example.dllo.thebeautiful.model.bean.things.Things_popNewBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/24.
 */
public class Things_Others_popAdapter extends BaseAdapter {
    private Things_popBean popBean;
    private Context context;
    private ArrayList<Things_popNewBean> datas;

    public Things_Others_popAdapter(Context context) {
        this.context = context;
    }

//    public void setPopBean(Things_popBean popBean) {
//        this.popBean = popBean;
//        notifyDataSetChanged();
//    }


    public void setDatas(ArrayList<Things_popNewBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
//        return popBean.getData().getCategories().get(5).getSub_categories().size();
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
//        return popBean.getData().getCategories().get(5).getSub_categories().get(position);
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gv_pop, null);
            holder = new MyHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
        }
//        holder.tv_gv_pop.setText(popBean.getData().getCategories().get(5).getSub_categories().get(position).getName());
        holder.tv_gv_pop.setText(datas.get(position).getName());
        return convertView;
    }

    class MyHolder{
        private TextView tv_gv_pop;
        public MyHolder(View itemView) {
            tv_gv_pop = (TextView) itemView.findViewById(R.id.tv_item_pop);
        }
    }


}
