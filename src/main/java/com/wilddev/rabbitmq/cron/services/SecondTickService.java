package com.wilddev.rabbitmq.cron.services;

import com.wilddev.rabbitmq.cron.config.settings.ExchangeSettings;
import com.wilddev.rabbitmq.cron.config.settings.RoutingKeySettings;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SecondTickService extends TickService {

    public SecondTickService(ExchangeSettings exchangeSettings,
                             RoutingKeySettings routingKeySettings,
                             RabbitTemplate rabbitTemplate) {
        super(log, exchangeSettings, rabbitTemplate, routingKeySettings.secondTick());
    }
}
