package com.example.productCRUD.controller;

import com.example.productCRUD.model.dto.SaleDTO;
import com.example.productCRUD.model.dto.SaleRequestDTO;
import com.example.productCRUD.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
private SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody SaleRequestDTO saleRequestDTO){
        this.saleService.addSale(saleRequestDTO.getCustomerId(),saleRequestDTO.getProductID(),saleRequestDTO.getSaleId());
        return new ResponseEntity<>("Başarılı", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam(name = "id")Long id){
        this.saleService.deleteSale(id);
        return new ResponseEntity<>("Başarılı",HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody SaleRequestDTO saleRequestDTO){
        this.saleService.updateSale(saleRequestDTO.getCustomerId(),saleRequestDTO.getProductID(),saleRequestDTO.getSaleId());
        return new ResponseEntity<>("Başarılı", HttpStatus.ACCEPTED);

    }

    @GetMapping
    public ResponseEntity<List <SaleDTO>> getSaleList(){
        return new ResponseEntity<>(this.saleService.getSaleList(),HttpStatus.OK);

    }
}
