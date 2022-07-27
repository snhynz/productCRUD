package com.example.productCRUD.repository;

import com.example.productCRUD.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository
        extends CrudRepository<Product,Long> {
}
