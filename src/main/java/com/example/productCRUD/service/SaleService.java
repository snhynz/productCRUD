package com.example.productCRUD.service;

import com.example.productCRUD.model.Sale;

import java.util.List;

public interface SaleService {
    void addSale(Long customerId, Long productId,Long saleId);

    void updateSale(Long customerId, Long productId,Long saleId);

    void deleteSale(Long id);

    List <Sale> getSaleList();
}
