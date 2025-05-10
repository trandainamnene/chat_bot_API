package com.example.chatbotAPI.controller;

import com.example.chatbotAPI.domain.dto.ChatHistoryDTO;
import com.example.chatbotAPI.domain.entity.ChatHistoryEntity;
import com.example.chatbotAPI.mapper.impl.ChatHistoryMapperImpl;
import com.example.chatbotAPI.service.ChatHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/chat-history")
public class ChatHistoryController {
    private ChatHistoryService chatHistoryService;
    private ChatHistoryMapperImpl chatHistoryMapper;
    public ChatHistoryController(ChatHistoryService chatHistoryService , ChatHistoryMapperImpl chatHistoryMapper) {
        this.chatHistoryService = chatHistoryService;
        this.chatHistoryMapper = chatHistoryMapper;
    }
    @GetMapping()
    public List<ChatHistoryDTO> getListChatHistory() {
        List<ChatHistoryEntity> allHisTory = chatHistoryService.getAll();
        System.out.println( "Chieu dai cua chat : " + allHisTory.size() + " " + allHisTory + " " + allHisTory.get(0));
        List<ChatHistoryDTO> rs = allHisTory.stream().map(chatHistoryMapper::mapTo).toList();
        return rs;
    }
}
