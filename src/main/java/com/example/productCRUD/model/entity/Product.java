package com.example.productCRUD.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Column(name = "Product_Name")
    private String name;
    @Column(name = "Product_Price")
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
