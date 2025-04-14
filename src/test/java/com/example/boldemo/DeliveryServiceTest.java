package com.example.boldemo;

import com.example.boldemo.domain.Delivery;
import com.example.boldemo.domain.Item;
import com.example.boldemo.domain.Truck;
import com.example.boldemo.entity.DeliveryEntity;
import com.example.boldemo.enums.DeliveryStatus;
import com.example.boldemo.repository.DeliveryRepository;
import com.example.boldemo.service.DeliveryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class DeliveryServiceTest {
    @Mock
    DeliveryRepository deliveryRepository;
    @InjectMocks
    DeliveryService deliveryService;

    @Test
    void testStartDeliveries(){
        Truck truck1 =  new Truck(10, 876L, true);
        Truck truck2 =  new Truck(10, 879L, true);

        Delivery delivery1 = new Delivery("deliveryName", truck1, 1L,  List.of(new Item("name",654L)),DeliveryStatus.SCHEDULED);
        Delivery delivery2 = new Delivery("deliveryName", truck2, 2L,  List.of(new Item("name",655L)),DeliveryStatus.SCHEDULED);
        when(deliveryRepository.findByStatus(any())).thenReturn(List.of(DeliveryEntity.fromDelivery(delivery1)));

        deliveryService.startDeliveries();

        verify(deliveryRepository, atLeastOnce()).save(any());

    }

}
