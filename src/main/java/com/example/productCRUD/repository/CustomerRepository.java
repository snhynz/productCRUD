package com.example.productCRUD.repository;

import com.example.productCRUD.model.dto.CustomerDTO;
import com.example.productCRUD.model.entity.Customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository
        extends CrudRepository<Customer,Long> {

    List<Customer> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(String name,String surname);

    List<Customer> findByAgeBetween(Integer age, Integer age2);

    List<Customer> findByNameContainingIgnoreCaseOrderByNameDesc(String name);

    List<Object> groupByAge();

@Query("select c.age from Customer c group by c.age")
    List<Object> groupByAgeWithHQL();
@Query(value = "select c.birt_date from Customer c group by c.birt_date",nativeQuery = true)
    List<Object> groupByAgeWithoutHQL();


}
