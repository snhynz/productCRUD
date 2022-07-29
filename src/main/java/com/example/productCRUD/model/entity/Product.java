package com.example.productCRUD.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale Sale;

    @Column(name = "Product_Name")
    private String name;
    @Column(name = "Product_Price")
    private Double price;

    public com.example.productCRUD.model.entity.Sale getSale() {
        return Sale;
    }

    public void setSale(com.example.productCRUD.model.entity.Sale Sale) {
        this.Sale = Sale;
    }

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
