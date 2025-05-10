package com.example.chatbotAPI.repository;

import com.example.chatbotAPI.domain.entity.ChatHistoryEntity;
import com.example.chatbotAPI.domain.entity.QuestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends CrudRepository<QuestionEntity , Integer> {
    Iterable<QuestionEntity> findByIdHistory(ChatHistoryEntity idHistory);
}
