package com.example.productCRUD.repository;

import com.example.productCRUD.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository
        extends CrudRepository<Product,Long> {

    List<Product> getProductByName(String name);

    List<Product> getProductByNameOrPrice(String name,Double price);

    List<Product> findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByPriceGreaterThanAndNameIgnoreCase(Double price, String name);

    List<Product> findAllByPriceOrderByName(Double price);
}
