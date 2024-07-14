package com.wilddev.rabbitmq.cron.config.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.rabbitmq.queue")
public record QueueSettings(String secondTick, String minuteTick) {

}
