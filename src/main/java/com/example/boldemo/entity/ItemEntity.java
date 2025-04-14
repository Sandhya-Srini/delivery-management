package com.example.boldemo.entity;

import com.example.boldemo.domain.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    @Id
    private Long id;
    private String name;


    public Item toItem(){
        return new Item(this.name, this.id );
    }

    public static ItemEntity toItemEntity(Item item){
        return new ItemEntity(item.getId(), item.getName());
    }

}
