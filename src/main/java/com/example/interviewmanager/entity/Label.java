package com.example.interviewmanager.entity;

import java.util.List;

/**
 * 公司标签
 * 只显示4个
 */
public class Label {
    private int id;
    private String companyName;
    private List<String> labels;
    private List<Integer> weight;//每个标签的权重
    public Label() {
    }

    public Label(int id, String companyName, List<String> labels) {
        this.id = id;
        this.companyName = companyName;
        this.labels = labels;
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

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", labels=" + labels +
                '}';
    }
}
