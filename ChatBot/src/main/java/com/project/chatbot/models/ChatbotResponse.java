package com.project.chatbot.models;

public class ChatbotResponse {
    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ChatbotResponse() {
    }

    @Override
    public String toString() {
        return "ChatbotResponse [response=" + response + "]";
    }

    
}
