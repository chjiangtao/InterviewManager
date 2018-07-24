package com.example.interviewmanager.entity;

import java.util.List;

public class InterviewMessageWithLabel {
    private InterviewMessage message;
    private List<Label>  labels;

    public InterviewMessageWithLabel() {
    }

    public InterviewMessageWithLabel(InterviewMessage message, List<Label> labels) {
        this.message = message;
        this.labels = labels;
    }

    public InterviewMessage getMessage() {
        return message;
    }

    public void setMessage(InterviewMessage message) {
        this.message = message;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "InterviewMessageWithLabel{" +
                "message=" + message +
                ", labels=" + labels +
                '}';
    }
}
