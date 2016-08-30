package com.example.dllo.thebeautiful.ui.adapter.mine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.mine.CollectFocusBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/30.
 */
public class CollectionFocusAdapter extends BaseAdapter{
    private List<CollectFocusBean> collectFocusBeen;
    private Context context;

    public CollectionFocusAdapter(Context context) {
        this.context = context;
    }

    public void setCollectFocusBeen(List<CollectFocusBean> collectFocusBeen) {
        this.collectFocusBeen = collectFocusBeen;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return collectFocusBeen != null ? collectFocusBeen.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return collectFocusBeen != null ? collectFocusBeen.get(position) : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_collection_focus,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView_name.setText(collectFocusBeen.get(position).getName());
        holder.textView_label.setText(collectFocusBeen.get(position).getLabel());
        Picasso.with(context).load(collectFocusBeen.get(position).getImageView()).error(R.mipmap.ic_launchera).into(holder.imageView);
        Picasso.with(context).load(collectFocusBeen.get(position).getCircleImageView()).error(R.mipmap.ic_launchera).into(holder.circleImageView);





        return convertView;
    }
    class  ViewHolder{
        private ImageView imageView;
        private CircleImageView circleImageView;
        private TextView textView_name,textView_label;

        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.iv_designer_collection);
            circleImageView = (CircleImageView) view.findViewById(R.id.civ_designer_head_collection);
            textView_name = (TextView) view.findViewById(R.id.tv_name_designer_collection);
            textView_label = (TextView) view.findViewById(R.id.tv_label_designer_collection);
        }
    }


}
