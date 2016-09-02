package com.example.dllo.thebeautiful.model.bean.mine;

import android.os.Parcel;
import android.os.Parcelable;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by dllo on 16/8/30.
 */
public class CollectFocusBean implements Parcelable{
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    public int _id;
    public String imageView;
    public String circleImageView;
    public String name;
    public String label;

    public CollectFocusBean() {
    }

    public CollectFocusBean(String imageView, String circleImageView, String name, String label) {
        this.imageView = imageView;
        this.circleImageView = circleImageView;
        this.name = name;
        this.label = label;
    }

    protected CollectFocusBean(Parcel in) {
        imageView = in.readString();
        circleImageView = in.readString();
        name = in.readString();
        label = in.readString();
    }

    public static final Creator<CollectFocusBean> CREATOR = new Creator<CollectFocusBean>() {
        @Override
        public CollectFocusBean createFromParcel(Parcel in) {
            return new CollectFocusBean(in);
        }

        @Override
        public CollectFocusBean[] newArray(int size) {
            return new CollectFocusBean[size];
        }
    };

    @Override
    public String toString() {
        return "CollectFocusBean{" +
                "imageView='" + imageView + '\'' +
                ", circleImageView='" + circleImageView + '\'' +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                '}';
    }

    public String getImageView() {
        return imageView;
    }

    public String getCircleImageView() {
        return circleImageView;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public CollectFocusBean setImageView(String imageView) {
        this.imageView = imageView;
        return this;
    }

    public CollectFocusBean setCircleImageView(String circleImageView) {
        this.circleImageView = circleImageView;
        return this;
    }

    public CollectFocusBean setName(String name) {
        this.name = name;
        return this;
    }

    public CollectFocusBean setLabel(String label) {
        this.label = label;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageView);
        dest.writeString(circleImageView);
        dest.writeString(name);
        dest.writeString(label);
    }
}
