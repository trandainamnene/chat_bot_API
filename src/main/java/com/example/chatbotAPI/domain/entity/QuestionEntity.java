package com.example.chatbotAPI.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "Question")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idquestion;
    String questiontext;
    String responsetext;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idHistory")
    ChatHistoryEntity idHistory;
}
