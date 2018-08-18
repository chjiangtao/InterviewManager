package com.example.interviewmanager.single;

import com.example.interviewmanager.entity.InterviewMessage;

import java.util.ArrayList;
import java.util.List;

public class InterviewSingle {
    private List<InterviewMessage> messages=new ArrayList<>();
    private static InterviewSingle  interviewSingle=new InterviewSingle();
    private InterviewSingle() {

    }
    public static InterviewSingle getIntance(){
         return interviewSingle;
    }

    public void setMessages(List<InterviewMessage> messages){
         this.messages=messages;
    }

    public List<InterviewMessage> getMessages() {
        return messages;
    }
}
