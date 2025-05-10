package com.example.chatbotAPI.controller;

import com.example.chatbotAPI.domain.dto.QuestionDTO;
import com.example.chatbotAPI.domain.entity.QuestionEntity;
import com.example.chatbotAPI.mapper.impl.QuestionMapper;
import com.example.chatbotAPI.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private QuestionMapper questionMapper;
    private QuestionService questionService;
    QuestionController(QuestionMapper questionMapper , QuestionService questionService) {
        this.questionMapper = questionMapper;
        this.questionService = questionService;
    }
    @GetMapping("/{idChat}")
    public List<QuestionDTO> get(@PathVariable int idChat) {
        try {
            List<QuestionEntity> questionEntity = questionService.getByIdHistory(idChat);
            List<QuestionDTO> questionDTO = questionEntity.stream().map(questionMapper::mapTo).toList();
            return questionDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("ID history is not existed");
        }
    }
}
