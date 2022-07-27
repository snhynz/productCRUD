package com.example.productCRUD.controller;

import com.example.productCRUD.model.Customer;
import com.example.productCRUD.model.Product;
import com.example.productCRUD.service.ProductService;
import com.example.productCRUD.serviceimp.ProductServiceİmp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity add(@RequestBody Product product){
        this.productService.addProduct(product);
        return new ResponseEntity<>("Başarılı", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        this.productService.deleteProduct(id);
        return new ResponseEntity<>("Başarılı",HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody Product product){
        this.productService.updateProduct(product);

    }

    @GetMapping
    public ResponseEntity<List<Product>> getProductList(){
        return ResponseEntity.ok(this.productService.getProductList());

    }

}
