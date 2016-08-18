package com.example.dllo.thebeautiful.ui.adapter.things;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_othersBean;
import com.example.dllo.thebeautiful.ui.interfaces.RecyclerClickListener;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/8/17.
 *
 */
public class Things_centerFourAdapter extends RecyclerView.Adapter<Things_centerFourAdapter.MyHolder>{

    private Context context;
    private Things_othersBean othersBean;
    private RecyclerClickListener listener;

    public void setListener(RecyclerClickListener listener) {
        this.listener = listener;
    }

    public Things_centerFourAdapter(Context context) {
        this.context = context;
    }

    public void setOthersBean(Things_othersBean othersBean) {
        this.othersBean = othersBean;
        notifyDataSetChanged();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_things_othersfragment , parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        if (othersBean.getData().getProducts().get(position).getCover_images().size() > 0) {
            Picasso.with(context).load(othersBean.getData().getProducts().get(position).getCover_images().get(0)).config(Bitmap.Config.RGB_565).resize(480, 320).into(holder.iv_cover_image);
        } else {
            holder.iv_cover_image.setImageResource(R.mipmap.ic_launchera);
        }
        /**用接口实现recyclerView点击事件*/
        if (listener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    listener.recyclerClick(position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return othersBean != null ? othersBean.getData().getProducts().size() : 0;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        private ImageView iv_cover_image;
        public MyHolder(View itemView) {
            super(itemView);
            iv_cover_image = (ImageView) itemView.findViewById(R.id.iv_item_things_others);
        }
    }

}
