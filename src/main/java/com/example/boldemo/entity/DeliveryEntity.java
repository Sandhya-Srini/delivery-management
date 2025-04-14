package com.example.boldemo.entity;

import com.example.boldemo.domain.Delivery;
import com.example.boldemo.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryEntity {
    @Id
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
   private DeliveryStatus status;
    @ManyToOne
    private TruckEntity truck;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemEntity> items;
    public Delivery toDelivery()
    {
        Delivery delivery = new Delivery();
        delivery.setId(this.id);
        delivery.setName(this.name);
        delivery.setTruck(this.truck.toTruck());
        delivery.setStatus(this.status);
        delivery.setItems(this.items.stream().map(ItemEntity::toItem).toList());
        return delivery;
    }

    public static DeliveryEntity fromDelivery(Delivery delivery)
    {
        return new DeliveryEntity(delivery.getId(),
                delivery.getName(),
                delivery.getStatus(),
                TruckEntity.fromTruck(delivery.getTruck()),
                delivery.getItems().stream().map(ItemEntity::toItemEntity).toList());
    }



}
