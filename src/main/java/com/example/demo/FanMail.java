package com.example.demo;

import java.util.Date;

public class FanMail {

    private int mailId;
    private String senderName;
    private String title;
    private String message;
    private String date;

    public FanMail(int mailId, String senderName, String title, String message, String date) {
        this.mailId = mailId;
        this.senderName = senderName;
        this.title = title;
        this.message = message;
        this.date = date;
    }

    public FanMail() {
    }

    public int getMailId() {
        return mailId;
    }

    public void setMailId(int mailId) {
        this.mailId = mailId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
