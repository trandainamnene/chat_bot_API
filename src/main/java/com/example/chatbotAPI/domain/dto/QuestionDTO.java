package com.example.chatbotAPI.domain.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDTO {
    int idquestion;
    String questiontext;
    String responsetext;
    ChatHistoryDTO idHistory;
}
