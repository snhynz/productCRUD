package com.example.productCRUD.service;



import com.example.productCRUD.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void addProduct(ProductDTO productDTO);

    void updateProduct(ProductDTO productDTO);

    void deleteProduct(Long id);

    List<ProductDTO> getProductList();
}
