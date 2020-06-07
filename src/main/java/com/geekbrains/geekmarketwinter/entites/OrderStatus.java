package com.geekbrains.geekmarketwinter.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders_statuses")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    private String title;
}
