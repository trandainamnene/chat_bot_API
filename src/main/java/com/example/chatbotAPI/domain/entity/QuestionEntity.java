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
    @Column(name = "idquestion")
    private int idquestion;

    @Column(name = "questiontext", columnDefinition = "NVARCHAR(MAX)")
    private String questiontext;

    @Column(name = "responsetext", columnDefinition = "NVARCHAR(MAX)")
    private String responsetext;

    @Column(name = "base64URLImage", columnDefinition = "VARCHAR(MAX)")
    private String base64URLImage;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idHistory")
    ChatHistoryEntity idHistory;
}
