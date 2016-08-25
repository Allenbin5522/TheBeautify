package com.example.dllo.thebeautiful.ui.fragment.things;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.tv.TvContentRating;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_othersBean;
import com.example.dllo.thebeautiful.model.bean.things.Things_popBean;
import com.example.dllo.thebeautiful.model.db.LiteOrmTool;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.model.net.URLValues;
import com.example.dllo.thebeautiful.ui.activity.things.ThingsSecondActivity;
import com.example.dllo.thebeautiful.ui.adapter.things.Things_Others_popAdapter;
import com.example.dllo.thebeautiful.ui.adapter.things.Things_othersAdapter;
import com.example.dllo.thebeautiful.ui.fragment.AbsBaseFragment;
import com.example.dllo.thebeautiful.ui.interfaces.RecyclerClickListener;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/8/16.
 * 有物界面复用的一级界面 (tablayout里的"其他"界面)
 */
public class Things_othersFragments extends AbsBaseFragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private Things_othersBean othersBean;
    private Things_othersAdapter othersAdapter;
    private String product_id;
    private RelativeLayout line_pop;
    private ImageView iv_pop;
    private TextView tv_category;
    private PopupWindow popupWindow;
    private View popView;
    private Things_Others_popAdapter popAdapter;
    private Things_popBean popBean;
    private GridView gv_pop;


    @Override
    protected int setLayout() {
        return R.layout.fragment_things_others;
    }

    @Override
    protected void initViews() {
        recyclerView = ByView(R.id.rv_things_others);
    }

    @Override
    protected void initDatas() {
        iv_pop = ByView(R.id.iv_category_things);
        line_pop = ByView(R.id.line_category);
        line_pop.setOnClickListener(this);
        tv_category = ByView(R.id.tv_category_things);
        popAdapter = new Things_Others_popAdapter(context);

        //popwindow初始化
        popView = getLayoutInflater(getArguments()).inflate(R.layout.popup_view_things, null);
//        popView = LayoutInflater.from(context).inflate(R.layout.popup_view_things, null);
        gv_pop = (GridView) popView.findViewById(R.id.gv_pop);

        othersAdapter = new Things_othersAdapter(context);
        //解析
        analysis();

        recyclerClick();

        initPop();

        parsePop();
    }


    /**
     * 解析数据
     */
    private void analysis() {
        OKHttpInstance.getInstance().startRequest(URLValues.THINGS_OTHERS, new OnHttpCallBack<String>() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                othersBean = gson.fromJson(response, Things_othersBean.class);
                othersAdapter.setOthersBean(othersBean);

                GridLayoutManager gm = new GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(gm);

                recyclerView.setAdapter(othersAdapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }





    /**
     * recyclerView的点击事件,点击进入二级界面
     */
    private void recyclerClick() {
       othersAdapter.setListener(new RecyclerClickListener() {
           @Override
           public void recyclerClick(int position) {
               product_id = String.valueOf(othersBean.getData().getProducts().get(position).getId());
               String url = URLValues.THINGS_SECOND.replace("913",  product_id);
               Intent intent = new Intent(context, ThingsSecondActivity.class);
               intent.putExtra("url", url);
               startActivity(intent);
           }
       });
    }

    /**
     * 点击弹出popupwindow
     */
    @Override
    public void onClick(View v) {
        iv_pop.setImageResource(R.mipmap.icon_category_fold);
        popupWindow.showAsDropDown(line_pop);
        tv_category.setVisibility(View.GONE);

    }

    /**
     * popupwindow具体信息
     */
    public void initPop(){

        popupWindow = new PopupWindow(context){
            @Override
            public void dismiss() {
                super.dismiss();
                iv_pop.setImageResource(R.mipmap.icon_category_unfold);
                tv_category.setVisibility(View.VISIBLE);
            }
        };

        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(popView);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
//        popupWindow.setInputMethodMode(popupWindow.INPUT_METHOD_NEEDED);

        popupWindow.setOutsideTouchable(true);  //可以收回显示内容
        popupWindow.setFocusable(true);
    }

    /**
     * popupwindow栏的解析
     */
    private void parsePop() {
        OKHttpInstance.getInstance().startRequest(URLValues.THINGS_POP, new OnHttpCallBack<String>() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                popBean = gson.fromJson(response, Things_popBean.class);
                popAdapter = new Things_Others_popAdapter(context);
                popAdapter.setPopBean(popBean);
                gv_pop.setAdapter(popAdapter);
                gv_pop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(context, "hahah", Toast.LENGTH_SHORT).show();
                        Log.d("Things_othersFragments", "haha");
                        String things_id = String.valueOf(popBean.getData().getCategories().get(5).getSub_categories().get(position).getId());
                        parsePopContent(things_id);
                        popupWindow.dismiss();
                        tv_category.setVisibility(View.VISIBLE);
                        tv_category.setText(popBean.getData().getCategories().get(0).getSub_categories().get(position).getName());
                    }
                });
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }

    /**
     * popopupWindow点击后再度解析
     */
    public void parsePopContent(String id){
        String url = URLValues.THINGS_OTHERS.replace("54", id);
        OKHttpInstance.getInstance().startRequest(url, new OnHttpCallBack<String>() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                othersBean = gson.fromJson(response, Things_othersBean.class);
                othersAdapter.setOthersBean(othersBean);

                GridLayoutManager gm = new GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(gm);

                recyclerView.setAdapter(othersAdapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    };



}
