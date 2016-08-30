package com.example.dllo.thebeautiful.ui.adapter.things;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_thingsBean;
import com.example.dllo.thebeautiful.utils.GetPercentage;
import com.example.dllo.thebeautiful.utils.LikeAnimationDrawable;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MyHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_things_thingsfragment, parent, false);
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
        holder.cb_dislike.setChecked(bean.getData().getActivities().get(position).getDesigner().isChecked());
        holder.cb_like.setChecked(bean.getData().getActivities().get(position).getDesigner().isChecked());
        holder.layout_dislike.setBackgroundResource(bean.getData().getActivities().get(position).getDesigner().getDisLikeBackGround());
        holder.layout_like.setBackgroundResource(bean.getData().getActivities().get(position).getDesigner().getLikeBackGround());
        holder.cb_dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = (CheckBox) v;
                bean.getData().getActivities().get(position).getDesigner().setChecked(checkBox.isChecked());
                bean.getData().getActivities().get(position).getDesigner().setDisLikeBackGround(R.drawable.shape_things_like_layout);
                showDislike(position, holder);
                Toast.makeText(context, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
        holder.cb_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = (CheckBox) v;
                bean.getData().getActivities().get(position).getDesigner().setChecked(checkBox.isChecked());
                bean.getData().getActivities().get(position).getDesigner().setDisLikeBackGround(R.drawable.shape_things_like_layout);
                showLike(position, holder);
                Toast.makeText(context, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    private void showDislike(int position, final MyHolder holder){
        final int dislikeNum = bean.getData().getActivities().get(position).getProduct().getUnlike_user_num();
        final int likeNum = bean.getData().getActivities().get(position).getProduct().getLike_user_num();
        holder.tv_dislike_num.setVisibility(View.VISIBLE);
        //不喜欢人数的百分比
        int dislikePercentage = (int) GetPercentage.getUnLikePercentage(likeNum, dislikeNum);
        holder.tv_dislike_num.setText(dislikePercentage + 1 + "%不喜欢");
        /**
         * 设置背景高度
         */
        ViewGroup.LayoutParams params = holder.layout_dislike.getLayoutParams();
        params.height = (int) GetPercentage.getUnLikeHeight(likeNum, dislikeNum);
        holder.layout_dislike.setLayoutParams(params);
        holder.layout_dislike.setBackgroundResource(R.drawable.shape_things_like_layout);
        //加入帧动画
        LikeAnimationDrawable animation = new LikeAnimationDrawable((AnimationDrawable) context.getResources().getDrawable(R.drawable.dislike_animation_drawable)) {
            @Override
            public void onAnimationEnd() {
                ObjectAnimator left = ObjectAnimator.ofFloat(holder.cb_dislike, "translationX", 0f, -10f);
                ObjectAnimator center = ObjectAnimator.ofFloat(holder.cb_dislike, "translationX", -10f, 10f);
                ObjectAnimator right = ObjectAnimator.ofFloat(holder.cb_dislike, "translationX", 10f, 0f);
                AnimatorSet set = new AnimatorSet();
                set.play(left).with(center);
                set.play(right).after(center);
                set.setDuration(500);
                set.start();
                //监听动画结束
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        //动画结束后把照片的高度设置成布局的高度
                        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.dislike_9);
                        ViewGroup.LayoutParams layoutParams = holder.layout_dislike.getLayoutParams();
                        layoutParams.height = bitmap.getHeight() - 30;
                        holder.layout_dislike.setLayoutParams(layoutParams);
                        holder.tv_dislike_num.setVisibility(View.GONE);
                    }
                });
            }
        };
        //让动画在照片上显示
        holder.cb_dislike.setBackground(animation);
        //开始动画
        animation.start();
    }


    private void showLike(int position, final MyHolder holder){
        final int dislikeNum = bean.getData().getActivities().get(position).getProduct().getUnlike_user_num();
        final int likeNum = bean.getData().getActivities().get(position).getProduct().getLike_user_num();
        //显示文字
        holder.tv_like_num.setVisibility(View.VISIBLE);
        //显示百分比
        int likePercentage = (int) GetPercentage.getLikePercentage(likeNum, dislikeNum);
        holder.tv_like_num.setText(likePercentage + "%喜欢");
        //设置背景高度和颜色
        ViewGroup.LayoutParams layoutParams = holder.layout_like.getLayoutParams();
        layoutParams.height = (int) GetPercentage.getLikeHeight(likeNum, dislikeNum);
        holder.layout_like.setLayoutParams(layoutParams);
        holder.layout_like.setBackgroundResource(R.drawable.shape_things_like_layout);
        //启动帧动画
        LikeAnimationDrawable animation = new LikeAnimationDrawable((AnimationDrawable) context.getResources().getDrawable(R.drawable.like_animation_drawable)) {
            //帧动画结束接口
            @Override
            public void onAnimationEnd() {
                //动画结束后把照片的高度设置成布局的高度
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.like_1);
                        ViewGroup.LayoutParams params = holder.layout_like.getLayoutParams();
                        params.height = bitmap.getHeight() - 30;
                        holder.layout_like.setLayoutParams(params);
                        holder.tv_like_num.setVisibility(View.GONE);
                    }
                }, 1000);
            }
        };
        holder.cb_like.setBackground(animation);
        animation.start();
    }


    class MyHolder {
        private ImageView iv_things;
        private CircleImageView civ_things;
        private TextView tv_name, tv_label, tv_dislike_num, tv_like_num;
        private CenterTextView tv_digest;
        private RelativeLayout layout_dislike, layout_like;
        private CheckBox cb_dislike, cb_like;

        public MyHolder(View itemView){
            iv_things = (ImageView) itemView.findViewById(R.id.iv_things_things);
            civ_things = (CircleImageView) itemView.findViewById(R.id.civ_things_things);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name_things_things);
            tv_label = (TextView) itemView.findViewById(R.id.tv_label_things_things);
            tv_digest = (CenterTextView) itemView.findViewById(R.id.tv_digest_things_things);

            layout_dislike = (RelativeLayout) itemView.findViewById(R.id.layout_things_dislike);
            layout_like = (RelativeLayout) itemView.findViewById(R.id.layout_things_like);
            tv_dislike_num = (TextView) itemView.findViewById(R.id.tv_thing_dislike_num);
            tv_like_num = (TextView) itemView.findViewById(R.id.tv_thing_like_num);
            cb_dislike = (CheckBox) itemView.findViewById(R.id.cb_dislike);
            cb_like = (CheckBox) itemView.findViewById(R.id.cb_like);
        }
    }


}
