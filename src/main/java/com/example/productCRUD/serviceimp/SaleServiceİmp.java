package com.example.productCRUD.serviceimp;


import com.example.productCRUD.model.Customer;
import com.example.productCRUD.model.Product;
import com.example.productCRUD.model.Sale;
import com.example.productCRUD.service.CustomerService;
import com.example.productCRUD.service.ProductService;
import com.example.productCRUD.service.SaleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceİmp implements SaleService {
    private CustomerServiceİmp customerService;
    private ProductServiceİmp productService;

    public SaleServiceİmp(CustomerServiceİmp customerService, ProductServiceİmp productService) {
        this.customerService = customerService;
        this.productService = productService;
    }

    List <Sale> saleList = new ArrayList<>();

    @Override
    public void addSale(Long customerId, Long productId,Long saleId) {
        Customer c = this.customerService.getCustomer().stream()
                .filter(customer -> customer.getId()==customerId)
                .findFirst().orElse(null);
        Product p = this.productService.getProductList().stream()
                .filter(product -> product.getId()==productId)
                .findFirst().orElse(null);
        Sale s = new Sale(saleId,p,c);
        this.saleList.add(s);
    }

    @Override
   public void updateSale(Long customerId, Long productId,Long saleId) {
        Customer c = this.customerService.getCustomer().stream()
                .filter(customer -> customer.getId()==customerId)
                .findFirst().orElse(null);
        Product p = this.productService.getProductList().stream()
                .filter(product -> product.getId()==productId)
                .findFirst().orElse(null);

        Sale s = this.saleList.stream()
                .filter(sale -> sale.getId()==saleId)
                .findFirst().orElse(null);
        if (s != null){
            s.setCustomer(c);
            s.setProduct(p);
        }
    }

    @Override
    public void deleteSale(Long id) {
        Sale s = this.saleList.stream()
                .filter(sale1 -> sale1.getId()==id)
                .findFirst().orElse(null);
        if (s!=null){
        this.saleList.remove(s);}
    }

    @Override
    public List<Sale> getSaleList() {
        return this.saleList;
    }
}
