package com.example.dllo.thebeautiful.ui.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.appeaser.deckview.views.DeckChildView;
import com.appeaser.deckview.views.DeckView;
import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.PictorialBean;
import com.example.dllo.thebeautiful.model.bean.PictorialDatas;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.ui.activity.child_activity.PictorialChildActivity;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.lang.ref.WeakReference;
import java.util.ArrayList;


/**
 * Created by dllo on 16/8/12.
 * 画报界面
 */
public class PictorialFragment extends AbsBaseFragment {
    private FrameLayout mFramLayot;
    private static int KEY = 0;
    DeckView<PictorialDatas> mDeckView;

    Drawable mDefaultHeaderIcon;
    ArrayList<PictorialDatas> mEntries;
    Bitmap mDefaultThumbnail;
    int scrollToChildIndex = -1;

    String url = "http://design.zuimeia.com/api/v1/articles/daily/?page=1&page_size=30&user_id=0&device_id=863360020709857&platform=android&lang=zh&appVersion=1.0.4&appVersionCode=10004&systemVersion=23&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";

    @Override
    protected int setLayout() {
        return R.layout.fragment_pictorial;
    }

    @Override
    protected void initViews() {
        mFramLayot = (FrameLayout)getActivity().findViewById(R.id.pictorial_content);
    }

    @Override
    protected void initDatas() {
        if (mEntries == null) {
            mEntries = new ArrayList<>();
            OKHttpInstance.getInstance().startRequest(url, new OnHttpCallBack<String>() {
                @Override
                public void onSuccess(String response) {
                    Gson gson = new Gson();
                    PictorialBean pictorialBean = gson.fromJson(response, PictorialBean.class);
                    for (int i = 0; i < pictorialBean.getData().getArticles().size(); i++) {
                        PictorialDatas pictorialDatas = new PictorialDatas();
                        pictorialDatas.setLink(pictorialBean.getData().getArticles().get(i).getImage_url());
                        pictorialDatas.setId(generateUniqueKey());
                        String title = pictorialBean.getData().getArticles().get(i).getTitle();
                        String subTitle = pictorialBean.getData().getArticles().get(i).getSub_title();
                        pictorialDatas.setHeaderTitle(title);
                        pictorialDatas.setContent(pictorialBean.getData().getArticles().get(i).getContent());
                        pictorialDatas.setSub_title(subTitle);
                        pictorialDatas.setImage_url(pictorialBean.getData().getArticles().get(i).getImage_url());
                        mEntries.add(0, pictorialDatas);
                    }
                    mDeckView = new DeckView<>(context);
                    mFramLayot.addView(mDeckView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    DeckView.Callback<PictorialDatas> callback = new DeckView.Callback<PictorialDatas>() {
                        @Override
                        public ArrayList<PictorialDatas> getData() {
                            return mEntries;
                        }

                        @Override
                        public void loadViewData(WeakReference<DeckChildView<PictorialDatas>> dcv, PictorialDatas item) {
                            loadViewDataInternal(item, dcv);
                        }

                        @Override
                        public void unloadViewData(PictorialDatas item) {
                            Picasso.with(context).cancelRequest(item.getTarget());
                        }

                        @Override
                        public void onViewDismissed(PictorialDatas item) {
                            mEntries.remove(item);
                            mDeckView.notifyDataSetChanged();
                        }

                        @Override
                        public void onItemClick(PictorialDatas item) {
                            Intent intent = new Intent(context, PictorialChildActivity.class);
                            intent.putExtra("pictorial_datas",item);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                        }

                        @Override
                        public void onNoViewsToDeck() {
                            Toast.makeText(context, "没有图了", Toast.LENGTH_SHORT).show();
                        }
                    };
                    mDeckView.initialize(callback);
                    if (scrollToChildIndex != -1) {
                        mDeckView.post(new Runnable() {
                            @Override
                            public void run() {
                                mDeckView.scrollToChild(scrollToChildIndex);
                            }
                        });
                    }

                }

                @Override
                public void onError(Throwable ex) {
                    Toast.makeText(context, "请求失败", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    public void loadViewDataInternal(final PictorialDatas datum,
                                     final WeakReference<DeckChildView<PictorialDatas>> weakView) {
        Picasso.with(context).cancelRequest(datum.getTarget());
        datum.target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                // Pass loaded Bitmap to view
                if (weakView.get() != null) {
                    weakView.get().onDataLoaded(datum, bitmap,
                            mDefaultHeaderIcon, datum.getHeaderTitle(), Color.WHITE);
                }
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                // Loading failed. Pass default thumbnail instead
                if (weakView.get() != null) {
                    weakView.get().onDataLoaded(datum, mDefaultThumbnail,
                            mDefaultHeaderIcon, datum.getHeaderTitle() + " Failed", Color.WHITE);
                }
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                // Pass the default thumbnail for now. It will
                // be replaced once the target Bitmap has been loaded
                if (weakView.get() != null) {
                    weakView.get().onDataLoaded(datum, mDefaultThumbnail,
                            mDefaultHeaderIcon, "IsLoad...", Color.DKGRAY);
                }
            }
        };

        // Begin loading
        Picasso.with(context).load(datum.getLink()).into(datum.getTarget());
    }


    private static int generateUniqueKey() {
        return ++KEY;
    }
}
