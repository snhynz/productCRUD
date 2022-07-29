package com.example.productCRUD.serviceimp;

import com.example.productCRUD.model.dto.ProductDTO;
import com.example.productCRUD.model.entity.Product;
import com.example.productCRUD.repository.ProductRepository;
import com.example.productCRUD.service.ProductService;
import com.example.productCRUD.utils.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceİmp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapperUtils modelMapperUtils;
    @Override
    @Transactional
    public void addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setInsertDate(new Date());
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setId(product.getId());
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getProductList() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        Iterator<Product> productIterator=
                productRepository.findAll().iterator();
        while(productIterator.hasNext()){
            ProductDTO productDTO = new ProductDTO();
            Product product = productIterator.next();
            productDTO.setPrice(product.getPrice());
            productDTO.setName(product.getName());
            productDTOS.add(productDTO);
        }

        return productDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getProductByName(String name) {
        return modelMapperUtils.mapAll(this.productRepository.getProductByName(name),ProductDTO.class);

    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getProductByNameOrPrice(String name, Double price) {
        return modelMapperUtils.mapAll(this.productRepository.getProductByNameOrPrice(name,price),ProductDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> findDistinctByName(String name) {
        return modelMapperUtils.mapAll(this.productRepository.findDistinctByName(name),ProductDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> findByPriceGreaterThan() {
        return this.modelMapperUtils.mapAll(this.productRepository.findByPriceGreaterThan(10000.0),ProductDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getByPriceGreaterThanAndNameIgnoreCase() {
        return this.modelMapperUtils.mapAll(this.productRepository
                .findByPriceGreaterThanAndNameIgnoreCase(10000.0,"laptop"),ProductDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> findAllByPriceOrderByName() {
        return this.modelMapperUtils.mapAll(this.productRepository.findAllByPriceOrderByName(2000.0),ProductDTO.class);
    }

    @Override
    public Integer productPriceSum(){
        return this.productRepository.productPriceSum();
    }

    @Override
    public List<Object> productPrice(Double price) {
        return this.productRepository.productPrice(price);
    }

    @Override
    public Integer productPriceAvg() {
        return this.productRepository.productPriceAvg();
    }

    @Override
    public Long sumProductsFilterByName(String name) {
        return this.productRepository.sumProductsFilterByName(name);
    }


}
