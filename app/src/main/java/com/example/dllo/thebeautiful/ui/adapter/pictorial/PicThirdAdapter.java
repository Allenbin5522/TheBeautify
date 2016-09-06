package com.example.dllo.thebeautiful.ui.adapter.pictorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.picbeans.PicThirdBean;
import com.example.dllo.thebeautiful.utils.TimeUtil;

import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/26.
 */
public class PicThirdAdapter extends BaseAdapter {
    private Context context;
    private PicThirdBean picThirdBean;
    private List<PicThirdBean.DataBean.CommentsBean> datas;
    public PicThirdAdapter(Context context) {
        this.context = context;
    }

    public PicThirdAdapter setDatas(List<PicThirdBean.DataBean.CommentsBean> datas) {
        this.datas = datas;
        return this;
    }

    public void change(int from,int to){
        PicThirdBean.DataBean.CommentsBean bean = datas.remove(from);
        datas.add(to,bean);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null ? datas.get(position) : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_pic_third,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Long data = datas.get(position).getCreated_at();
        String time = TimeUtil.getDescriptionTimeFromTimestamp(data);
        viewHolder.time.setText(time);
        viewHolder.content.setText(datas.get(position).getContent());
        viewHolder.name.setText(datas.get(position).getAuthor().getUsername());
        Glide.with(context).load(datas.get(position).getAuthor().getAvatar_url()).into(viewHolder.head_portrait);
        return convertView;
    }
    private class ViewHolder{
        private TextView content,name,time;
        private CircleImageView head_portrait;
        public ViewHolder(View view) {
            content = (TextView) view.findViewById(R.id.content_talk);
            head_portrait = (CircleImageView) view.findViewById(R.id.head_portrait);
            name = (TextView) view.findViewById(R.id.name_picthird);
            time = (TextView) view.findViewById(R.id.time_picthird);
        }
    }
}
