package com.example.productCRUD.serviceimp;

import com.example.productCRUD.model.dto.CustomerDTO;
import com.example.productCRUD.model.dto.ProductDTO;
import com.example.productCRUD.model.entity.Customer;
import com.example.productCRUD.model.entity.Product;
import com.example.productCRUD.repository.ProductRepository;
import com.example.productCRUD.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceİmp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

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
    @Transactional
    public List<ProductDTO> getProductList() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        Iterator<Product> productIterator= productRepository.findAll().iterator();
        while(productIterator.hasNext()){
            ProductDTO productDTO = new ProductDTO();
            Product product = productIterator.next();
            productDTO.setPrice(product.getPrice());
            productDTO.setName(product.getName());
            productDTOS.add(productDTO);
        }

        return productDTOS;
    }
}
