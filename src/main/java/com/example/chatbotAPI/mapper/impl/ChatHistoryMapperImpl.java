package com.example.chatbotAPI.mapper.impl;

import com.example.chatbotAPI.domain.dto.ChatHistoryDTO;
import com.example.chatbotAPI.domain.entity.ChatHistoryEntity;
import com.example.chatbotAPI.mapper.Mapper;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ChatHistoryMapperImpl implements Mapper <ChatHistoryEntity , ChatHistoryDTO> {
    private ModelMapper modelMapper;
    public ChatHistoryMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public ChatHistoryDTO mapTo(ChatHistoryEntity chatHistoryEntity) {
        return modelMapper.map(chatHistoryEntity , ChatHistoryDTO.class);
    }

    @Override
    public ChatHistoryEntity mapFrom(ChatHistoryDTO chatHistoryDTO) {
        return  modelMapper.map(chatHistoryDTO , ChatHistoryEntity.class);
    }
}
