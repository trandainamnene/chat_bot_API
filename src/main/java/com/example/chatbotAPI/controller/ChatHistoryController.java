package com.example.chatbotAPI.controller;

import com.example.chatbotAPI.domain.dto.ChatHistoryDTO;
import com.example.chatbotAPI.domain.dto.DoctorDTO;
import com.example.chatbotAPI.domain.dto.QuestionDTO;
import com.example.chatbotAPI.domain.entity.ChatHistoryEntity;
import com.example.chatbotAPI.domain.entity.QuestionEntity;
import com.example.chatbotAPI.mapper.impl.ChatHistoryMapperImpl;
import com.example.chatbotAPI.service.ChatHistoryService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/chat-history")
public class ChatHistoryController {
    private ChatHistoryService chatHistoryService;
    private ChatHistoryMapperImpl chatHistoryMapper;
    public ChatHistoryController(ChatHistoryService chatHistoryService , ChatHistoryMapperImpl chatHistoryMapper) {
        this.chatHistoryService = chatHistoryService;
        this.chatHistoryMapper = chatHistoryMapper;
    }
    @PostMapping
    public ResponseEntity<ChatHistoryDTO> add(@RequestBody ChatHistoryDTO chatHistoryDTO) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setUsername(username);
        chatHistoryDTO.setUsername(doctorDTO);
        ChatHistoryEntity chatHistoryEntity = chatHistoryMapper.mapFrom(chatHistoryDTO);
        ChatHistoryEntity result =  chatHistoryService.create(chatHistoryEntity);
        ChatHistoryDTO respone = chatHistoryMapper.mapTo(result);
        return ResponseEntity.ok(respone);
    }

    @GetMapping
    public List<ChatHistoryDTO> getAll() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            List<ChatHistoryEntity> chatHistoryEntity = chatHistoryService.getByUserName(username);
            List<ChatHistoryDTO> chatHistoryDto = chatHistoryEntity.stream().map(chatHistoryMapper::mapTo).toList();
            return chatHistoryDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("history is not existed");
        }
    }

}
