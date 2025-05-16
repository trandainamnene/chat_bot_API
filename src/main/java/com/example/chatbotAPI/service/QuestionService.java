package com.example.chatbotAPI.service;

import com.example.chatbotAPI.domain.dto.QuestionDTO;
import com.example.chatbotAPI.domain.entity.ChatHistoryEntity;
import com.example.chatbotAPI.domain.entity.QuestionEntity;
import com.example.chatbotAPI.repository.ChatHistoryRepo;
import com.example.chatbotAPI.repository.QuestionRepo;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
@Service
public class QuestionService {
    QuestionRepo questionRepo;
    ChatHistoryRepo chatHistoryRepo;
    public QuestionService(QuestionRepo questionRepo , ChatHistoryRepo chatHistoryRepo) {
        this.chatHistoryRepo = chatHistoryRepo;
        this.questionRepo = questionRepo;
    }
    public List<QuestionEntity> getByIdHistory(int idHistory) throws Exception {
        Optional<ChatHistoryEntity> chatHistoryEntity = chatHistoryRepo.findById(idHistory);
        if (chatHistoryEntity.isPresent()) {
            List<QuestionEntity> questionEntity = StreamSupport.stream(
                    questionRepo.findByIdHistory(chatHistoryEntity.get()).spliterator(),
                    false
            ).toList();
            return questionEntity;
        } else {
            throw new Exception("asd");
        }
    }
    public QuestionEntity create(QuestionEntity questionEntity) {
        Optional<ChatHistoryEntity> chatHistoryEntity = chatHistoryRepo.findById(questionEntity.getIdHistory().getIdHistory());
        questionEntity.setIdHistory(chatHistoryEntity.get());
        return questionRepo.save(questionEntity);
    }
}
