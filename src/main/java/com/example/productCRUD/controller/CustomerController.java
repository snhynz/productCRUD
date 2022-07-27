package com.example.productCRUD.controller;

import com.example.productCRUD.model.Customer;
import com.example.productCRUD.service.CustomerService;
import com.example.productCRUD.serviceimp.CustomerServiceİmp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Customer customer){
        this.customerService.addCustomer(customer);
        return new ResponseEntity<>("Başarılı", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>("Başarılı",HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody Customer customer){
        this.customerService.updateCustomer(customer);

    }

    @GetMapping
    public List<Customer> getCustomerList(){
        return this.customerService.getCustomer();

    }
}
