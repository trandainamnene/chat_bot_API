package com.example.chatbotAPI.service;

import com.example.chatbotAPI.domain.entity.DoctorEntity;
import com.example.chatbotAPI.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailService implements UserDetailsService {
    @Autowired
    private DoctorRepo doctorRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<DoctorEntity> doctor = doctorRepo.findById(username);
        if (doctor.isEmpty()) {
            throw new UsernameNotFoundException("Doctor not found with username : " + username);
        }
        return new User(doctor.get().getUsername() , doctor.get().getPassword() , new ArrayList<>());
    }
}
