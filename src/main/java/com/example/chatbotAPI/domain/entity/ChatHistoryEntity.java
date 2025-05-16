package com.example.chatbotAPI.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "ChatHistory")
@Entity
public class ChatHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idHistory;
    String summary;
    @ManyToOne
    @JoinColumn(name = "username")
    DoctorEntity username;

}
