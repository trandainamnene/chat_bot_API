package com.example.chatbotAPI.mapper.impl;

import com.example.chatbotAPI.domain.dto.QuestionDTO;
import com.example.chatbotAPI.domain.entity.QuestionEntity;
import com.example.chatbotAPI.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper implements Mapper<QuestionEntity , QuestionDTO> {
    ModelMapper modelMapper;
    QuestionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public QuestionDTO mapTo(QuestionEntity questionEntity) {
        return modelMapper.map(questionEntity , QuestionDTO.class);
    }

    @Override
    public QuestionEntity mapFrom(QuestionDTO questionDTO) {
        return modelMapper.map(questionDTO , QuestionEntity.class);
    }
}
