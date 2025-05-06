package com.example.chatbotAPI.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
@lombok.Data
@lombok.NoArgsConstructor
@Entity
@Table(name = "Doctor")
public class DoctorEntity {
    @Id
    String username;
    @JsonIgnore
    String password;
}
