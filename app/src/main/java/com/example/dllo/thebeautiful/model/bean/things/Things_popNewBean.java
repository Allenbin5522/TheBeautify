package com.example.dllo.thebeautiful.model.bean.things;

/**
 * Created by dllo on 16/8/25.
 * 自定义的实体类,而非解析的,是在Things—popBean解析出来后,将"全部"加到popupwindow上
 */
public class Things_popNewBean {
    private int id;
    private String name;

    public Things_popNewBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
