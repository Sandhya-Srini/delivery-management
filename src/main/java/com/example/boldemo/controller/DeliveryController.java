package com.example.boldemo.controller;

import com.example.boldemo.domain.Delivery;
import com.example.boldemo.service.DeliveryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/update-status")
    public void updateDeliveryStatus(@RequestBody Delivery delivery){
        deliveryService.updateStatus(delivery);
    }

}
