package com.wilddev.rabbitmq.cron.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;

import org.springframework.context.annotation.*;

@Configuration
public class JacksonConf {

    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        objectMapper.configOverride(LocalDateTime.class)
                .setFormat(JsonFormat.Value.forPattern("yyyy-MM-dd HH:mm:ss"));

        return objectMapper;
    }
}
