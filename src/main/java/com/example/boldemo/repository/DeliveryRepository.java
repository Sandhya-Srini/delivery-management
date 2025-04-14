package com.example.boldemo.repository;

import com.example.boldemo.entity.DeliveryEntity;
import com.example.boldemo.enums.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long> {
    List<DeliveryEntity> findByStatus(DeliveryStatus status);
}
