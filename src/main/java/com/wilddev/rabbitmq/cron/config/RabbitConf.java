package com.wilddev.rabbitmq.cron.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wilddev.rabbitmq.cron.config.settings.ExchangeSettings;

import lombok.AllArgsConstructor;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import org.springframework.context.annotation.*;

@Configuration
@AllArgsConstructor
public class RabbitConf {

    private final ExchangeSettings exchangeSettings;

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchangeSettings.scheduler());
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
