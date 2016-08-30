package com.example.dllo.thebeautiful.model.bean.mine;

/**
 * Created by dllo on 16/8/30.
 */
public class CollectFocusBean {
    private String imageView;
    private String circleImageView;
    private String name;
    private String label;

    public CollectFocusBean() {
    }

    public CollectFocusBean(String imageView, String circleImageView, String name, String label) {
        this.imageView = imageView;
        this.circleImageView = circleImageView;
        this.name = name;
        this.label = label;
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
}
