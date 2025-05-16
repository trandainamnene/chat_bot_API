package com.example.chatbotAPI.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Question")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idquestion;
    String questiontext;
    String responsetext;
    @ManyToOne
    @JoinColumn(name = "idHistory")
    ChatHistoryEntity idHistory;
}
