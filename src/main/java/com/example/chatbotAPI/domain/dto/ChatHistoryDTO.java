package com.example.chatbotAPI.domain.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ChatHistoryDTO {
    int idHistory;
    String summary;
    String username;

}
