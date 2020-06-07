package com.geekbrains.geekmarketwinter.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn (name = "delivery_address_id")
    private DeliveryAddress deliveryAddress;

    @ManyToOne
    @JoinColumn (name = "status_id")
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @Column (name = "price")
    private double price;

    @Column (name = "phone_number")
    private String phoneNumber;

    @Column (name = "delivery_date")
    private LocalDateTime DeliveryDate;

    @Column (name ="delivery_price")
    private double deliveryPrice;

    @Column (name = "create_at")
    @CreationTimestamp
    private LocalDateTime createAt;

    @Column (name = "update_at")
    @CreationTimestamp
    private LocalDateTime updateAt;

    @JsonIgnore
    @Transient
    private boolean confirmed;


}
