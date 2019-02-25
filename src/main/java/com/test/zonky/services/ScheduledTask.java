package com.test.zonky.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    ZonkyService zonkyService;

    public ScheduledTask(ZonkyService zonkyService) {
        this.zonkyService = zonkyService;
    }

    @Scheduled(fixedRate = 300000)
    public void getFromMarketplace(){
     zonkyService.getMarketplace();
    }
}
