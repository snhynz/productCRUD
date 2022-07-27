package com.example.productCRUD.service;

import com.example.productCRUD.model.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Long id);

    List<Customer> getCustomer();
}
