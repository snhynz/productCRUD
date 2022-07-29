package com.example.productCRUD.service;



import com.example.productCRUD.model.dto.ProductDTO;
import com.example.productCRUD.model.entity.Product;

import java.util.List;

public interface ProductService {
    void addProduct(ProductDTO productDTO);

    void updateProduct(ProductDTO productDTO);

    void deleteProduct(Long id);

    List<ProductDTO> getProductList();

    List<ProductDTO> getProductByName(String name);

   List<ProductDTO> getProductByNameOrPrice(String name, Double price);

    List<ProductDTO> findDistinctByName(String name);

    List<ProductDTO> findByPriceGreaterThan();

    List<ProductDTO> getByPriceGreaterThanAndNameIgnoreCase();

    List<ProductDTO> findAllByPriceOrderByName();

    Integer productPriceSum();

    List<Object> productPrice(Double price);

    Integer productPriceAvg();

    Long sumProductsFilterByName(String name);

}
