package com.wilddev.rabbitmq.cron.config.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.rabbitmq.exchange")
public record ExchangeSettings(String scheduler) {

}
