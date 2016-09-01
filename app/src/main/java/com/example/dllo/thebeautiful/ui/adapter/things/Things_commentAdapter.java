package com.example.dllo.thebeautiful.ui.adapter.things;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_secondBean;
import com.example.dllo.thebeautiful.utils.TimeUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/30.
 */
public class Things_commentAdapter extends BaseAdapter{

    private Things_secondBean secondBean;
    private Context context;
    private List<Things_secondBean.DataBean.CommentsBean> commentsBeen;

    public Things_commentAdapter(Context context) {
        this.context = context;
    }

    public void setCommentsBeen(List<Things_secondBean.DataBean.CommentsBean> commentsBeen) {
        this.commentsBeen = commentsBeen;
    }

    @Override
    public int getCount() {
        return commentsBeen != null ? commentsBeen.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return commentsBeen != null ? commentsBeen.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_things_comment, null);
            holder = new MyHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
        }
        Picasso.with(context).load(commentsBeen.get(position).getAuthor().getAvatar_url()).into(holder.civ_image);
        holder.tv_name.setText(commentsBeen.get(position).getAuthor().getUsername());
        holder.tv_content.setText(commentsBeen.get(position).getContent());
        Long date = commentsBeen.get(position).getCreated_at();
        String time = TimeUtil.getDescriptionTimeFromTimestamp(date);
        holder.tv_time.setText(time);
        return convertView;
    }


    class MyHolder{
        private CircleImageView civ_image;
        private TextView tv_name, tv_content, tv_time;
        public MyHolder(View itemView) {
            civ_image = (CircleImageView) itemView.findViewById(R.id.head_portrait);
            tv_name = (TextView) itemView.findViewById(R.id.name_picthird);
            tv_content = (TextView) itemView.findViewById(R.id.content_talk);
            tv_time = (TextView) itemView.findViewById(R.id.time_picthird);
        }
    }

}
