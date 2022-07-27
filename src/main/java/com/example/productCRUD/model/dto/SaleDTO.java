package com.example.productCRUD.model.dto;

public class SaleDTO {
    private Long id;
    private ProductDTO productDTO;
    private CustomerDTO customerDTO;

    public SaleDTO(Long id, ProductDTO productDTO, CustomerDTO customerDTO) {
        this.id = id;
        this.productDTO = productDTO;
        this.customerDTO = customerDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return productDTO;
    }

    public void setProduct(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public CustomerDTO getCustomer() {
        return customerDTO;
    }

    public void setCustomer(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", product=" + productDTO +
                ", customer=" + customerDTO +
                '}';
    }
}
