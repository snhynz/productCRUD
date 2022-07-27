package com.example.productCRUD.service;



import com.example.productCRUD.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long id);

    List<Product> getProductList();
}
