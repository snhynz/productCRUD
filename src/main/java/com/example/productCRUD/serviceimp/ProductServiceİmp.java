package com.example.productCRUD.serviceimp;

import com.example.productCRUD.model.Product;
import com.example.productCRUD.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceİmp implements ProductService {

    private List <Product> productList=new ArrayList<>();
    @Override
    public void addProduct(Product product) {
        this.productList.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product p = this.productList.stream()
                .filter(product1 -> product1.getId()== product.getId())
                .findFirst().orElse(null);
        p.setName(product.getName());
        p.setId(product.getId());
        p.setPrice(product.getPrice());
    }

    @Override
    public void deleteProduct(Long id) {
        Product p = this.productList.stream()
                .filter(pr -> pr.getId()==id)
                .findFirst().orElse(null);
        if (p!=null) {
            this.productList.remove(p);
        }
    }

    @Override
    public List<Product> getProductList() {
        return this.productList;
    }
}
