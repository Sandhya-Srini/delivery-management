package com.example.boldemo.domain;

import com.example.boldemo.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    private String name;
    private Truck truck;
    private Long id;
    private List<Item> items;
    private DeliveryStatus status;

}
