package com.example.boldemo.scheduler;

import com.example.boldemo.service.DeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DeliveryScheduler {
    private final DeliveryService deliveryService;

    public DeliveryScheduler(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }
    @Scheduled(fixedRate = 300000)
    public void processScheduledDeliveries(){
        try{
            log.info("Starting to process scheduled deliveries");
            deliveryService.startDeliveries();
        }
        catch(Exception e){
            log.info("Exception occurred while scheduling deliveries", e);
        }
    }
}
