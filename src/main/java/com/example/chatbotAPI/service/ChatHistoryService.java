package com.example.chatbotAPI.service;

import com.example.chatbotAPI.domain.dto.ChatHistoryDTO;
import com.example.chatbotAPI.domain.dto.QuestionDTO;
import com.example.chatbotAPI.domain.entity.ChatHistoryEntity;
import com.example.chatbotAPI.domain.entity.QuestionEntity;
import com.example.chatbotAPI.repository.ChatHistoryRepo;
import com.example.chatbotAPI.repository.QuestionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ChatHistoryService {
    private ChatHistoryRepo chatHistoryRepo;
    private QuestionRepo questionRepo;

    public ChatHistoryService(ChatHistoryRepo chatHistoryRepo , QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
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

    public ChatHistoryEntity create(ChatHistoryEntity chatHistoryEntity) {
        return chatHistoryRepo.save(chatHistoryEntity);
    }

    public List<ChatHistoryEntity> getByUserName(String username) {
        return StreamSupport.stream(
                chatHistoryRepo.findByUsernameUsername(username).spliterator(),
                false
        ).toList();
    }

    public void delete(int idChat) {
        List<QuestionEntity> allQuestion = StreamSupport.stream(
                questionRepo.findAll().spliterator(),
                false
        ).toList();
        allQuestion.forEach(e -> {
            if (e.getIdHistory().getIdHistory() == idChat) {
                questionRepo.delete(e);
            }
        } );
        Iterable<QuestionEntity> lstQuestion = questionRepo.findAll();
        chatHistoryRepo.deleteById(idChat);
    }
}
