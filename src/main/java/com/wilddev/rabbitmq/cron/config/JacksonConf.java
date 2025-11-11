package com.wilddev.rabbitmq.cron.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.text.DateFormat;

import org.springframework.context.annotation.*;

@Configuration
public class JacksonConf {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule()).setDateFormat(DateFormat.getDateTimeInstance());
    }
}
