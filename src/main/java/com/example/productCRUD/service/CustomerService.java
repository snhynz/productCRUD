package com.example.productCRUD.service;

import com.example.productCRUD.model.dto.CustomerDTO;
import com.example.productCRUD.model.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long id);

    List<CustomerDTO> getCustomer();

    ResponseEntity<CustomerDTO> getCustomerById(Long Id);

    long getAllCountCustomer();

    void addListCustomerDTO(List<CustomerDTO> customerDTOList);

    List<CustomerDTO> getByNameIgnoreCaseOrSurnameIgnoreCase(String name,String surname);

    List<CustomerDTO> getByAgeBetween(Integer age,Integer age2);

    List<CustomerDTO> getByNameContainingIgnoreCase(String name);

    List<Object> groupByAge();

    List<Object> groupByAgeWithHQL();

    List<Object> groupByAgeWithoutHQL();
}
