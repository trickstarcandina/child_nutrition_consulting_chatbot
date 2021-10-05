package com.example.chatbotspring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
class MessageController {

    private SimpMessagingTemplate template;

//    @MessageMapping("/chat-register")
//    @SendTo("/topic/public")
//    MessageEntity register(@Payload MessageEntity chatMessage, SimpMessageHeaderAccessor headerAccessor) {
//        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender())
//        return chatMessage
//    }

    @MessageMapping("/message/send")
    public void sendMessage() {

    }

}
