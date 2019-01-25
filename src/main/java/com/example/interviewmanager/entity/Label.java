package com.example.interviewmanager.entity;

import org.litepal.crud.LitePalSupport;

import java.util.List;

/**
 * 公司标签
 * 只显示4个
 */
public class Label extends LitePalSupport {

    private int id;
    private String companyName;
    private String label;
    private int weight;//每个标签的权重
    private InterviewMessage interviewMessage;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public InterviewMessage getInterviewMessage() {
        return interviewMessage;
    }

    public void setInterviewMessage(InterviewMessage interviewMessage) {
        this.interviewMessage = interviewMessage;
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

}
