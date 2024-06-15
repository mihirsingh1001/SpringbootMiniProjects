package com.project.chatbot.models;

public class ChatbotRequest {
    private String request;

    public String getRequest() {
        return request;
    }
    
    public void setRequest(String request) {
        this.request = request;
    }

    public ChatbotRequest() {
    }

    @Override
    public String toString() {
        return "ChatbotRequest [request=" + request + "]";
    }

}
