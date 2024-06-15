package com.project.chatbot.services;

import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Service;


@Service
public class ChatbotServices {

    private final Map<String, String> responseset;

    public ChatbotServices() {
        responseset = new HashMap<String, String>();
        responseset.put("hello", "Hii there! How can I assist you");
        responseset.put("how are you", "I'm a bot, but I'm doing great! How about you?");
        responseset.put("bye", "Goodbye! Have a nice day!");
    }

    public String getChatServices(String message) {
        String lowerCaseMessage = message.toLowerCase();
        for (String key : responseset.keySet()) {
            if (lowerCaseMessage.contains(key)) {
                return responseset.get(key);
            }
        }
        return "I'm not sure how to respond to that.";

    }
}
