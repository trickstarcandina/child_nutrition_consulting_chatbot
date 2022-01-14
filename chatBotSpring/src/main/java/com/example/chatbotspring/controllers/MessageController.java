package com.example.chatbotspring.controllers;

import com.example.chatbotspring.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        return ResponseEntity.ok(messageService.solveMessage(message));
    }

}
