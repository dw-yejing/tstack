package edu.bjtu.quartz.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class ApplicationInitConfig implements ApplicationRunner {
    private final Scheduler scheduler;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("=============== 系统初始化开始 ===============");
        scheduler.start();
        log.info("=============== 系统初始化结束 ===============");
    }
}
