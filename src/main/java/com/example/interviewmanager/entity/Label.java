package com.example.interviewmanager.entity;

import java.util.List;

/**
 * 公司标签
 * 只显示4个
 */
public class Label {
    private int id;
    private String companyName;
    private String label;
    private int weight;//每个标签的权重
    public Label() {
    }

    public Label(int id, String companyName, String label) {
        this.id = id;
        this.companyName = companyName;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
