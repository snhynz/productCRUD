package com.example.productCRUD.controller;

import com.example.productCRUD.model.dto.ProductDTO;
import com.example.productCRUD.service.ProductService;
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
    public ResponseEntity add(@RequestBody ProductDTO productDTO){
        this.productService.addProduct(productDTO);
        return new ResponseEntity<>("Başarılı", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        this.productService.deleteProduct(id);
        return new ResponseEntity<>("Başarılı",HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody ProductDTO productDTO){
        this.productService.updateProduct(productDTO);

    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProductList(){
        return ResponseEntity.ok(this.productService.getProductList());

    }

}
