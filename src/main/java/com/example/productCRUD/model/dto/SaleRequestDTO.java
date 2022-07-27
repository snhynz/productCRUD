package com.example.productCRUD.model.dto;

public class SaleRequestDTO {
    private Long customerId;
    private Long productId;
    private Long saleId;

    public SaleRequestDTO(Long customerId, Long productId,Long saleId) {
        this.customerId = customerId;
        this.productId = productId;
        this.saleId=saleId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductID() {
        return productId;
    }

    public void setProductID(Long productID) {
        this.productId = productID;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
}
