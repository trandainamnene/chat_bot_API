package com.example.chatbotAPI.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ChatHistoryDTO {
    int idHistory;
    String summary;
    @JsonIgnore
    DoctorDTO username;
}
