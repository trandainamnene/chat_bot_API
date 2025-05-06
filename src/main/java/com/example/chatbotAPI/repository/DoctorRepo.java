package com.example.chatbotAPI.repository;

import com.example.chatbotAPI.domain.entity.DoctorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends CrudRepository<DoctorEntity , String> {

}
