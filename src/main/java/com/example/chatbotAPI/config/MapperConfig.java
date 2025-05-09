package com.example.chatbotAPI.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.convention.MatchingStrategies;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper () {
        ModelMapper myModelMapper = new ModelMapper();
        myModelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return myModelMapper;
    }
}
