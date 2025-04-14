package com.example.boldemo.service;

import com.example.boldemo.domain.Delivery;
import com.example.boldemo.entity.DeliveryEntity;
import com.example.boldemo.enums.DeliveryStatus;
import com.example.boldemo.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService{

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }


    public void startDeliveries() {
        List<Delivery> scheduledDeliveries =  deliveryRepository.findByStatus(DeliveryStatus.SCHEDULED)
                .stream()
                .map(DeliveryEntity::toDelivery)
                .toList();
        scheduledDeliveries.forEach(scheduledDelivery -> {
            scheduledDelivery.setStatus(DeliveryStatus.IN_TRANSIT);
            deliveryRepository.save(DeliveryEntity.fromDelivery(scheduledDelivery));
            simulateDeliveryProcess(scheduledDelivery.getId());
        });
    }

    private void simulateDeliveryProcess(Long deliveryId) {
        //Do something to send deliver message
    }

    public void updateStatus(Delivery delivery) {
        deliveryRepository.findById(delivery.getId()).ifPresentOrElse(deliveryEntity -> {
           Delivery deliveryToUpdate = deliveryEntity.toDelivery();
            deliveryToUpdate.setStatus(delivery.getStatus());
            deliveryRepository.save(DeliveryEntity.fromDelivery(deliveryToUpdate));
        }, null);
    }
}
