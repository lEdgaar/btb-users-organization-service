package com.btb.usersorganizationservice.service.schedule;

import com.btb.usersorganizationservice.service.AdministrationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ScheduledJobs {

    @Autowired
    private AdministrationService administrationService;

    @Scheduled(cron = "0 0 1 * * *")
    public void desbanUsers() {
        log.info("Scheduled job: desban users");
        administrationService.desbanUsers();
    }

}
