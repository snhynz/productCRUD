package com.example.productCRUD.serviceimp;


import com.example.productCRUD.model.dto.CustomerDTO;
import com.example.productCRUD.model.dto.ProductDTO;
import com.example.productCRUD.model.dto.SaleDTO;
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

    List <SaleDTO> saleDTOList = new ArrayList<>();

    @Override
    public void addSale(Long customerId, Long productId,Long saleId) {
        CustomerDTO c = this.customerService.getCustomer().stream()
                .filter(customer -> customer.getId()==customerId)
                .findFirst().orElse(null);
        ProductDTO p = this.productService.getProductList().stream()
                .filter(product -> product.getId()==productId)
                .findFirst().orElse(null);
        SaleDTO s = new SaleDTO(saleId,p,c);
        this.saleDTOList.add(s);
    }

    @Override
   public void updateSale(Long customerId, Long productId,Long saleId) {
        CustomerDTO c = this.customerService.getCustomer().stream()
                .filter(customer -> customer.getId()==customerId)
                .findFirst().orElse(null);
        ProductDTO p = this.productService.getProductList().stream()
                .filter(product -> product.getId()==productId)
                .findFirst().orElse(null);

        SaleDTO s = this.saleDTOList.stream()
                .filter(saleDTO -> saleDTO.getId()==saleId)
                .findFirst().orElse(null);
        if (s != null){
            s.setCustomer(c);
            s.setProduct(p);
        }
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
