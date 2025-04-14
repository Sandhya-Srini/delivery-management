package com.example.boldemo.kafka;

import com.example.boldemo.domain.Delivery;
import com.example.boldemo.service.DeliveryService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryStatusConsumer {

    private final DeliveryService deliveryService;

    public DeliveryStatusConsumer(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.delivery-status}", groupId = "delivery-group")
    public void consumeDeliveryStatusUpdates(Delivery delivery){
        deliveryService.updateStatus(delivery);
    }
}
