package com.example.interviewmanager.entity;

import org.litepal.crud.LitePalSupport;

/**
 * 用户
 */
public class User extends LitePalSupport {

    private int id;

    private String name;

    private String iconPath;

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

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
}
