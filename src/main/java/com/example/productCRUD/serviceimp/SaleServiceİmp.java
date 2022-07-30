package com.example.productCRUD.serviceimp;


import com.example.productCRUD.model.dto.CustomerDTO;
import com.example.productCRUD.model.dto.ProductDTO;
import com.example.productCRUD.model.dto.SaleDTO;
import com.example.productCRUD.model.entity.Customer;
import com.example.productCRUD.model.entity.Product;
import com.example.productCRUD.model.entity.Sale;
import com.example.productCRUD.repository.CustomerRepository;
import com.example.productCRUD.repository.ProductRepository;
import com.example.productCRUD.repository.SaleRepository;
import com.example.productCRUD.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceİmp implements SaleService {

   @Autowired
   private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SaleRepository saleRepository;

    List <SaleDTO> saleDTOList = new ArrayList<>();

    @Override
    public void addSale(Long customerId, List<Long> productId,Long saleId) {
        Sale sale = new Sale();
        Customer customer = customerRepository.
                findById(customerId).orElse(null);
        sale.setCustomer(customer);
      List<Product> products = (List<Product>)productRepository
                .findAllById(productId);
        sale.setProduct(products);
        saleRepository.save(sale);
    }



    @Override
   public void updateSale(Long customerId,List<Long> productId,Long saleId) {
        Sale sale =
        saleRepository.findById(saleId).orElse(new Sale());
        Customer customer = customerRepository
                .findById(customerId).orElse(null);
        sale.setCustomer(customer);
        List<Product> products = (List<Product>)productRepository
                .findAllById(productId);
        saleRepository.save(sale);
        }


    @Override
    public void deleteSale(Long id) {
        SaleDTO s = this.saleDTOList.stream()
                .filter(saleDTO1 -> saleDTO1.getId()==id)
                .findFirst().orElse(null);
        if (s!=null){
        this.saleDTOList.remove(s);}
    }

    @Override
    public List<SaleDTO> getSaleList() {
        return this.saleDTOList;
    }
}
