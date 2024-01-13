package com.Students.Subject.Scheduler;

import com.Students.Subject.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeScheduler {
    Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Async
    @Scheduled(cron = "*/2 * * * * *")
    public void timeScheduler() throws InterruptedException{
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = localDateTime.format(dateTimeFormatter);
        logger.info(formattedDateTime);
        Thread.sleep(3000);
    }
//    @Scheduled(fixedRate = 2000)
//    public void standByWarning() throws InterruptedException{
//        logger.info("Application is online");
//    }

    public void timeOut() {

    }


}
