package com.example.productCRUD.repository;

import com.example.productCRUD.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository
        extends JpaRepository<Product,Long> {

    List<Product> getProductByName(String name);

    List<Product> getProductByNameOrPrice(String name,Double price);

    List<Product> findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByPriceGreaterThanAndNameIgnoreCase(Double price, String name);

    List<Product> findAllByPriceOrderByName(Double price);
@Query("select sum(p.price) from Product p")
    Integer productPriceSum();

  @Query(value = "select sum(product_price) from product where product_name" +
            " like '%'||:name||'%'"
            ,nativeQuery = true)
    Long sumProductsFilterByName(String name);

   @Query("select p from Product p where p.price>:price")
    List<Object> productPrice(Double price);

    @Query("select avg(p.price) from Product p")
    Integer productPriceAvg();
}
