package com.example.chatbotAPI.service;

import com.example.chatbotAPI.domain.dto.ChatHistoryDTO;
import com.example.chatbotAPI.domain.entity.ChatHistoryEntity;
import com.example.chatbotAPI.repository.ChatHistoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
@Service
public class ChatHistoryService {
    private ChatHistoryRepo chatHistoryRepo;

    public ChatHistoryService(ChatHistoryRepo chatHistoryRepo) {
        this.chatHistoryRepo = chatHistoryRepo;
    }
    public List<ChatHistoryEntity> getAll() {
        List<ChatHistoryEntity> allListChat = StreamSupport.stream(
                chatHistoryRepo.findAll().spliterator(),
                false
        ).toList();
        return allListChat;
    }

    public Boolean isExist(int id) {
        return chatHistoryRepo.existsById(id);
    }

    public Optional<ChatHistoryEntity> getById(int id) {
        return chatHistoryRepo.findById(id);
    }
}
