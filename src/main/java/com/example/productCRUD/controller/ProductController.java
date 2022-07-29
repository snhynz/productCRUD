package com.example.productCRUD.controller;

import com.example.productCRUD.model.dto.ProductDTO;
import com.example.productCRUD.service.ProductService;
import com.example.productCRUD.utils.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapperUtils modelMapperUtils;

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

    @GetMapping("getByName")
    @Transactional(readOnly = true)
    public List<ProductDTO> getProductByName(
            @RequestParam(name= "name") String name){
        return this.productService.getProductByName(name);
    }
    @GetMapping("getByNameOrPrice")
    @Transactional(readOnly = true)
    public List<ProductDTO> getProductByNameOrPrice(
            @RequestParam(name= "name") String name,
            @RequestParam(name = "price") Double price){
        return this.productService.getProductByNameOrPrice(name,price);
    }
    @GetMapping("findDistinctByName")
    @Transactional(readOnly = true)
    public List<ProductDTO> findDistinctByName
            (@RequestParam(name = "name") String name){
        return this.productService.findDistinctByName(name);
    }

    @GetMapping("greaterThan")
    @Transactional(readOnly = true)
    public List<ProductDTO> findByPriceGreaterThan(){
        return this.productService.findByPriceGreaterThan();
    }
    @GetMapping("uzunisim")
    @Transactional(readOnly = true)
    public List<ProductDTO> getByPriceGreaterThanAndNameIgnoreCase(){
        return this.productService.getByPriceGreaterThanAndNameIgnoreCase();
    }
    @GetMapping("allProduct")
    @Transactional(readOnly = true)
    public List<ProductDTO> findAllByPriceOrderByName(){
        return this.productService.findAllByPriceOrderByName();
    }

    @GetMapping("allProductPriceSum")
    @Transactional(readOnly = true)
    public Integer productPriceSum(){
        return productService.productPriceSum();
    }
    @GetMapping("allProductPrice")
    @Transactional(readOnly = true)
    public List<Object> productPrice(
            @RequestParam(name = "price")Double price
    ){
        return productService.productPrice(price);
    }

    @GetMapping("allProductPriceAvg")
    @Transactional(readOnly = true)
    public Integer productPriceAvg(){
        return productService.productPriceAvg();
    }

   @GetMapping("FilterByName/{name}")
    @Transactional(readOnly = true)
    public ResponseEntity<Long> sumProductsFilterByName(
            @PathVariable(name="name") String name
    ){
        return ResponseEntity.ok(
                this.productService.sumProductsFilterByName(name));
    }
}
