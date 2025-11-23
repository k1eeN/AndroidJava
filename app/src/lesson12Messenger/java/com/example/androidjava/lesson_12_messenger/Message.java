package com.example.androidjava.lesson_12_messenger;

public class Message {


    private String text;
    private String sendId;
    private String receiverId;

    public Message(String text, String sendId, String receiverId) {
        this.text = text;
        this.sendId = sendId;
        this.receiverId = receiverId;
    }

    public Message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
}
