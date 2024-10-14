package com.wilddev.rabbitmq.cron.schedulers;

import com.wilddev.rabbitmq.cron.services.HourQuarterTickService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HourQuarterTick extends AbstractTick {

    public HourQuarterTick(HourQuarterTickService tickService) {
        super(tickService);
    }

    @Scheduled(cron = "0 */15 * * * *")
    @Override
    public void run() {
        tickService.tick();
    }
}
