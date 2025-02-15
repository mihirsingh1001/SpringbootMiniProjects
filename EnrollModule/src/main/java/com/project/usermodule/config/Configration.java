package com.project.usermodule.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configration {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
