package com.procrastinator.perfectproductservice.controllers;

import com.procrastinator.perfectproductservice.dtos.createProductDTO;
import com.procrastinator.perfectproductservice.services.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

@RestController
@Getter
@Setter
public class ProductController {
    ProductService productService;
    @GetMapping("/products/{id}/")
    public String getProduct(@PathVariable Long id){
        return "GetProduct api is called for id:"+id;
    }
    @GetMapping("/products/")
    public String getAllProducts(){
        return "GetAllProducts api is called";
    }

    @PostMapping("/products/")
    public String createProduct(createProductDTO createProductDTO){
        return "CreteProduct is called with id: "+createProductDTO.getId();

    }
    @DeleteMapping("/products/{id}/")
    public String deleteProduct(@PathVariable Long id){
        return "Delete product api is called with id:"+id;

    }
    @DeleteMapping("/products/")
    public String deleteAllProducts(){
        return "Delete all products api is called";
    }


}
