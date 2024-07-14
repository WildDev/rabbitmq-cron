package com.wilddev.rabbitmq.cron.schedulers;

import com.wilddev.rabbitmq.cron.services.SecondTickService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SecondTick extends AbstractTick {

    public SecondTick(SecondTickService tickService) {
        super(tickService);
    }

    @Scheduled(cron = "* * * * * *")
    @Override
    public void run() {
        tickService.tick();
    }
}
