package com.example.productCRUD.controller;

import com.example.productCRUD.model.dto.CustomerDTO;
import com.example.productCRUD.model.entity.Customer;
import com.example.productCRUD.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody CustomerDTO customerDTO){
        this.customerService.addCustomer(customerDTO);
        return new ResponseEntity<>("Başarılı", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>("Başarılı",HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody CustomerDTO customerDTO){
        this.customerService.updateCustomer(customerDTO);

    }

    @GetMapping
    public List<CustomerDTO> getCustomerList(){
        return this.customerService.getCustomer();

    }
    @GetMapping("findById")
    public ResponseEntity<CustomerDTO> getCustomerById(@RequestParam(value = "Id")Long Id){
       return customerService.getCustomerById(Id);
    }
    @GetMapping("allCountCustomer")
    public ResponseEntity<Long> getAllCountCustomer(){
        return new ResponseEntity<>
                (customerService.getAllCountCustomer(),HttpStatus.OK);
    }
@PostMapping("addList")
    public ResponseEntity addListCustomer(@RequestBody List<CustomerDTO> customerDTOList){
        this.customerService.addListCustomerDTO(customerDTOList);
        return new ResponseEntity<>
                ("Başarılı",HttpStatus.OK);
    }

    @GetMapping("ignorCaseName")
    @Transactional(readOnly = true)
    public List<CustomerDTO> getByNameIgnoreCaseOrSurnameIgnoreCase(
            @RequestParam(name = "name")String name,
            @RequestParam(name = "surname")String surname
    ){
        return this.customerService.getByNameIgnoreCaseOrSurnameIgnoreCase(name,surname);
    }
    @GetMapping("ageBetween")
    @Transactional(readOnly = true)
    public List<CustomerDTO> getByAgeBetween(
            @RequestParam(name = "age") Integer age,
            @RequestParam(name = "age2") Integer age2) {
    return this.customerService.getByAgeBetween(age,age2);
    }
    @GetMapping("findByNameFilter/{name}")
    @Transactional(readOnly = true)
    public List<CustomerDTO> getByNameContainingIgnoreCase(@PathVariable(name = "name")String name){
        return this.customerService.getByNameContainingIgnoreCase(name);
    }

    @GetMapping("groupByAgeWith")
    @Transactional(readOnly = true)
    public List<Object> groupByAgeWithHQL(){
        return this.customerService.groupByAgeWithHQL();
    }

    @GetMapping("groupByAgeWithout")
    @Transactional(readOnly = true)
    public List<Object> groupByAgeWithoutHQL(){
        return this.customerService.groupByAgeWithoutHQL();
    }

}
