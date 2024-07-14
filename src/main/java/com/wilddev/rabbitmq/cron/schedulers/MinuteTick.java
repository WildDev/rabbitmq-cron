package com.wilddev.rabbitmq.cron.schedulers;

import com.wilddev.rabbitmq.cron.services.MinuteTickService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MinuteTick extends AbstractTick {

    public MinuteTick(MinuteTickService tickService) {
        super(tickService);
    }

    @Scheduled(cron = "0 * * * * *")
    @Override
    public void run() {
        tickService.tick();
    }
}
