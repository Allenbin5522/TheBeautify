package com.example.dllo.thebeautiful.ui.adapter.designer;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.designer.DesignerBean;
import com.example.dllo.thebeautiful.model.bean.mine.CollectFocusBean;
import com.example.dllo.thebeautiful.model.db.LiteOrmTool;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.model.net.URLValues;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by dllo on 16/8/17.
 */
public class DesignerAdapter extends BaseAdapter implements View.OnClickListener {
    private List<DesignerBean.DataBean.DesignersBean> designersBeen;
    private Context context;
    private Boolean isCollect = true;
    private CollectFocusBean bean;


    public DesignerAdapter(Context context) {
        this.context = context;
    }

    public void setDesignersBeen(List<DesignerBean.DataBean.DesignersBean> designersBeen) {
        this.designersBeen = designersBeen;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return designersBeen != null ? designersBeen.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return designersBeen != null ? designersBeen.get(position) : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_designer, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView_name.setText(designersBeen.get(position).getName());
        holder.textView_label.setText(designersBeen.get(position).getLabel());
        final ViewHolder finalHolder = holder;

        if (bean != null){
            finalHolder.button.setText("已关注");
        }
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isCollect){
                    final String imageView = designersBeen.get(position).getRecommend_images().get(0);
                    final String circleImageView = designersBeen.get(position).getAvatar_url();
                    final String name = designersBeen.get(position).getName();
                    String label = designersBeen.get(position).getLabel();
                     bean = new CollectFocusBean(imageView, circleImageView, name, label);
                    finalHolder.button.setText("已关注");
                    LiteOrmTool.insert(bean);
                    isCollect = false;

                }else {

                    finalHolder.button.setText("关注");
                    isCollect = true;
                }
            }
        });

        if (designersBeen.get(position).getAvatar_url().isEmpty()) {
            holder.circleImageView.setImageResource(R.mipmap.ic_launchera);
        } else {
            Picasso.with(context).load(designersBeen.get(position).getAvatar_url()).into(holder.circleImageView);
        }
        if (designersBeen.get(position).getRecommend_images().isEmpty()) {
            holder.imageView.setImageResource(R.mipmap.black_button_bg);
        } else {
            Picasso.with(context).load(designersBeen.get(position).getRecommend_images().get(0)).into(holder.imageView);
        }
        return convertView;
    }

    @Override
    public void onClick(View v) {

    }

     class ViewHolder {
        private ImageView imageView;
        private CircleImageView circleImageView;
        private TextView textView_name, textView_label;
        private Button button;

        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.iv_designer);
            circleImageView = (CircleImageView) view.findViewById(R.id.civ_designer_head);
            textView_name = (TextView) view.findViewById(R.id.tv_name_designer);
            textView_label = (TextView) view.findViewById(R.id.tv_label_designer);
            button = (Button) view.findViewById(R.id.button_design);

        }
    }


}
