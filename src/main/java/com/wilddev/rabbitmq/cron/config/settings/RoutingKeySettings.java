package com.wilddev.rabbitmq.cron.config.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.rabbitmq.routing.key")
public record RoutingKeySettings(String secondTick, String minuteTick) {

}
