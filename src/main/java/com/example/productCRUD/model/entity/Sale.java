package com.example.productCRUD.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sale extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany()
    @JoinColumn(name = "sale_id")
    private List<Product> product;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
