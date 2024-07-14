package com.wilddev.rabbitmq.cron.services;

import com.wilddev.rabbitmq.cron.config.settings.ExchangeSettings;
import com.wilddev.rabbitmq.cron.values.Tick;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

@AllArgsConstructor
public abstract class TickService {

    protected final Logger log;

    protected final ExchangeSettings exchangeSettings;

    protected final RabbitTemplate rabbitTemplate;

    protected final String routingKey;

    public void tick() {

        rabbitTemplate.convertAndSend(exchangeSettings.scheduler(), routingKey, new Tick(LocalDateTime.now()));
        log.debug("Event sent for '{}'", routingKey);
    }
}
