package com.example.productCRUD.serviceimp;

import com.example.productCRUD.model.Customer;
import com.example.productCRUD.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceİmp implements CustomerService {

    private List<Customer> customerList=new ArrayList<>();
    @Override
    public void addCustomer(Customer customer){
        this.customerList.add(customer);
    }
    @Override
    public void deleteCustomer(Long id){
        Customer c =this.customerList.stream()
                .filter(customer -> customer.getId()==id)
                .findFirst().orElse(null);
        customerList.remove(c);
    }

@Override
    public void updateCustomer(Customer customer){
        Customer customer1 =this.customerList.stream()
                .filter(c -> c.getId()==customer.getId())
                .findFirst().orElse(null);
        customer1.setAge(customer.getAge());
        customer1.setName(customer.getName());
        customer1.setSurname(customer.getSurname());
    }
    public List <Customer> getCustomer(){
        return this.customerList;
    }
}
