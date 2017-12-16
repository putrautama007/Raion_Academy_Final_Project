package com.example.putrautama.rachat.models;

/**
 * Created by ASUS ROG on 15/12/2017.
 */

public class Users {
    public  String emailId;
    public  String lastMessage;
    public  int notifCount;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public int getNotifCount() {
        return notifCount;
    }

    public void setNotifCount(int notifCount) {
        this.notifCount = notifCount;
    }
}
