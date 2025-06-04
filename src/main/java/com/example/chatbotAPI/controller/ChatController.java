package com.example.chatbotAPI.controller;

import com.example.chatbotAPI.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping(value = "/stream/{idChat}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamFastApi(@PathVariable Long idChat, @RequestBody ChatRequest request) {
        String base64Url = request.image() != null ? request.image().url() : null;
        String imageType = request.image() != null ? request.image().type() : null;
        return chatService.callFastApiStream(idChat, request.question(), base64Url, imageType);
    }

    public record ChatRequest(
            String question,
            ChatService.Image image
    ) {}
}