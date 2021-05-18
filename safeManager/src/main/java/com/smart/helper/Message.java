package com.smart.helper;

public class Message {

    private String content;
    private String type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Message(String content, String type) {

        this.content = content;
        this.type = type;
    }
}
