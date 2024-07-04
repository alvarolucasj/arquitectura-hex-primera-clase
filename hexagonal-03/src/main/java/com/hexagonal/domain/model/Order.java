package com.hexagonal.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private Long id;
    private String status;


    @OneToMany
    private List<OrderItem> items = new ArrayList<OrderItem>();


}
