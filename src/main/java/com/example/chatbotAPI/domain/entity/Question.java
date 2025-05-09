package com.example.chatbotAPI.domain.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "Question")
public class Question {
    @Id
    int idquestion;
    String questiontext;
    String responsetext;
    @ManyToOne
    @JoinColumn(name = "idHistory")
    private int idHistory;
}
