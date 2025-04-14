package com.example.boldemo.entity;

import com.example.boldemo.domain.Truck;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TruckEntity {
    private int capacity;
    @Id
    private Long id;
    private boolean isAvailable;

    public Truck toTruck(){
        return new Truck( this.capacity,this.id, this.isAvailable);
    }

    public static TruckEntity fromTruck(Truck truck){
        return new TruckEntity(truck.getCapacity(),truck.getId(), truck.isAvailable());
    }
}
