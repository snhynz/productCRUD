package com.example.productCRUD.repository;

import com.example.productCRUD.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository
        extends CrudRepository<Customer,Long> {
}
