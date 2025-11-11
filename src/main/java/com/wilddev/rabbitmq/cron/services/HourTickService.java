package com.wilddev.rabbitmq.cron.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.wilddev.rabbitmq.cron.config.settings.*;

@Slf4j
@Service
public class HourTickService extends TickService {

    public HourTickService(ExchangeSettings exchangeSettings,
                           RoutingKeySettings routingKeySettings,
                           RabbitTemplate rabbitTemplate) {
        super(log, exchangeSettings, rabbitTemplate, routingKeySettings.hourTick());
    }
}
