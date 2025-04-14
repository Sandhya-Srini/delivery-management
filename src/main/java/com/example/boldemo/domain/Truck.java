package com.example.boldemo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Truck {
    private int capacity;
    private Long id;
    private boolean isAvailable;
}
