package com.wilddev.rabbitmq.cron.schedulers;

import com.wilddev.rabbitmq.cron.services.HourTickService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HourTick extends AbstractTick {

    public HourTick(HourTickService tickService) {
        super(tickService);
    }

    @Scheduled(cron = "0 0 * * * *")
    @Override
    public void run() {
        tickService.tick();
    }
}
