package com.example.productCRUD.service;

import com.example.productCRUD.model.dto.SaleDTO;

import java.util.List;

public interface SaleService {
    void addSale(Long customerId, List<Long> productId,Long saleId);

    void updateSale(Long customerId, List<Long> productId,Long saleId);

    void deleteSale(Long id);

    List <SaleDTO> getSaleList();
}
