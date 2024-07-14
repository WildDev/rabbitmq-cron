package com.wilddev.rabbitmq.cron.schedulers;

import com.wilddev.rabbitmq.cron.services.TickService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractTick implements Runnable {

    protected final TickService tickService;
}
