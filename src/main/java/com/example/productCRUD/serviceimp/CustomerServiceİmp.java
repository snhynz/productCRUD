package com.example.productCRUD.serviceimp;

import com.example.productCRUD.model.dto.CustomerDTO;
import com.example.productCRUD.model.entity.Customer;
import com.example.productCRUD.repository.CustomerRepository;
import com.example.productCRUD.service.CustomerService;
import com.example.productCRUD.utils.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class CustomerServiceİmp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapperUtils modelMapperUtils;
    @Override

    public void addCustomer(CustomerDTO customerDTO){
        Customer customer = modelMapperUtils.convertToModel(customerDTO,Customer.class);
        customer.setInsertDate(new Date());
        customerRepository.save(customer);
    }
    @Override

    public void deleteCustomer(Long id){
       customerRepository.deleteById(id);
    }

@Override

    public void updateCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setSurname(customer.getSurname());
        customer.setAge(customer.getAge());
        customer.setId(customer.getId());
        customerRepository.save(customer);
    }@Override

    public List <CustomerDTO> getCustomer(){
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        Iterator<Customer> customerIterator= customerRepository.findAll().iterator();
        while(customerIterator.hasNext()){
            CustomerDTO customerDTO = new CustomerDTO();
            Customer customer = customerIterator.next();
            customerDTO.setName(customer.getName());
            customerDTO.setSurname(customer.getSurname());
            customerDTO.setAge(customer.getAge());
            customerDTOS.add(customerDTO);
        }

        return customerDTOS;
    }

    @Override
    public ResponseEntity<CustomerDTO> getCustomerById(Long Id) {
       boolean isExist = this.customerRepository.existsById(Id);
       if (isExist){
          Customer customer =
                  this.customerRepository.findById(Id).get();
          CustomerDTO customerDTO = new CustomerDTO();
          customerDTO.setName(customer.getName());
          customerDTO.setSurname(customer.getSurname());
          customerDTO.setAge(customer.getAge());
           return new ResponseEntity<>(customerDTO, HttpStatus.OK);
       }else {
           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }

    }

    @Override
    public long getAllCountCustomer() {
        return this.customerRepository.count();
    }
    @Override
    public void addListCustomerDTO(List<CustomerDTO> customerDTOList){
        List<Customer>customerList=new ArrayList<>();
    for (CustomerDTO customerDTO: customerDTOList) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setAge(customerDTO.getAge());
        customer.setInsertDate(new Date());
        customerList.add(customer);
    }
    this.customerRepository.saveAll(customerList);
}

    @Override
    public List<CustomerDTO> getByNameIgnoreCaseOrSurnameIgnoreCase(String name , String surname) {
        return modelMapperUtils
                .mapAll(this.customerRepository
                        .findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(name,surname),CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getByAgeBetween(Integer age, Integer age2) {
        return modelMapperUtils
                .mapAll(this.customerRepository
                        .findByAgeBetween(age+1,age2-1),CustomerDTO.class);
    }


    @Override
    public List<CustomerDTO> getByNameContainingIgnoreCase(String name) {
        return modelMapperUtils
                .mapAll(this.customerRepository.
                        findByNameContainingIgnoreCaseOrderByNameDesc(name),CustomerDTO.class);
    }

    @Override
    public List<Object> groupByAge() {
        return this.customerRepository.groupByAge();
    }

    @Override
    public List<Object> groupByAgeWithHQL() {
        return customerRepository.groupByAgeWithHQL();
    }

    @Override
    public List<Object> groupByAgeWithoutHQL() {
        return customerRepository.groupByAgeWithoutHQL();
    }
}
