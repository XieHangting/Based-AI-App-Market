package com.xieht.appmarket.config;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author：xht
 */

@Configuration
@Data
public class VipSchedulerConfig {
    @Bean
    public Scheduler vipScheduler(){
        ThreadFactory threadFactory = new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(1);

            @Override
            public Thread newThread(@NotNull Runnable r) {
                Thread thread = new Thread(r, "VIPThreadPoll-" + threadNumber.getAndIncrement());
                thread.setDaemon(false); // 设置为守护线程
                return thread;
            }
        };

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10,threadFactory);
        return Schedulers.from(scheduledExecutorService);
    }
}
