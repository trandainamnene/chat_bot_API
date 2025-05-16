package com.example.chatbotAPI.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

@lombok.Data
@lombok.NoArgsConstructor
public class DoctorDTO {
    String username;
    @JsonIgnore
    String password;
}
