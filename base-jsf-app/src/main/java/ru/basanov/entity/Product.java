package ru.basanov.entity;

import javax.persistence.*;

@Table(name = "app_product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10000, nullable = false)
    private int price;

    @Column(length = 4096, nullable = false)
    private String name;

    public Product() {
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
