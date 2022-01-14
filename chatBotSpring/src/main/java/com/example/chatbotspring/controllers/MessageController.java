package com.example.chatbotspring.controllers;

import com.example.chatbotspring.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        return ResponseEntity.ok(messageService.solveMessage(message));
    }

}
