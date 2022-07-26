package com.example.productCRUD.controller;

import com.example.productCRUD.model.Customer;
import com.example.productCRUD.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void add(@RequestBody Customer customer){

    }

    @PutMapping
    public void update(){}

    @DeleteMapping
    public void delete(){}

    @GetMapping
    public void getCustomerList(){}
}
