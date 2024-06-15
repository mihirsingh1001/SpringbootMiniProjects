package com.project.chatbot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.chatbot.models.ChatbotRequest;
import com.project.chatbot.models.ChatbotResponse;
import com.project.chatbot.services.ChatbotServices;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {

    @Autowired
    private ChatbotServices chatbotServices;

    @PostMapping("/message")
    public ChatbotResponse sendMessage(@RequestBody ChatbotRequest chatbotRequest){
    
        String userMessage = chatbotRequest.getRequest();
        String botResponse =  chatbotServices.getChatServices(userMessage);
        ChatbotResponse chatbotResponse = new ChatbotResponse();
        chatbotResponse.setResponse(botResponse);
        return chatbotResponse;
    }
}
