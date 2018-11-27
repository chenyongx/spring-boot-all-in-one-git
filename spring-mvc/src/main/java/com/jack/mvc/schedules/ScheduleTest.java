package com.jack.mvc.schedules;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author yangyueming
 */
@Component
public class ScheduleTest {
    @Scheduled(cron = "0/10 * * * * *")
    public void work1() {
        // task execution logic
    }

    @Scheduled(fixedDelay = 1000*10)
    public void work2() {
        // task execution logic
    }

    @Scheduled(fixedRate = 1000*10)
    public void work3() {
        // task execution logic
    }
}
