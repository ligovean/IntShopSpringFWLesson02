package com.geekbrains.geekmarketwinter.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "item_price")
    private double itemPrice;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
