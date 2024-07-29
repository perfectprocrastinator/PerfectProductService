package com.procrastinator.perfectproductservice.controllers;

import com.procrastinator.perfectproductservice.dtos.createProductDTO;
import com.procrastinator.perfectproductservice.dtos.createProductResponseDTO;
import com.procrastinator.perfectproductservice.models.Product;
import com.procrastinator.perfectproductservice.services.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Getter
@Setter
public class ProductController {
    private ProductService productService;
    //Qualifier is used to tell Spring which class's object to inject when Spring itself can't decide which object to inject
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/{id}/")
    public String getProduct(@PathVariable("id") Long id){
        return "GetProduct api is called for id:"+id;
    }
    @GetMapping("/")
    public String getAllProducts(){
        return "GetAllProducts api is called";
    }

    @PostMapping("/")
    public createProductResponseDTO createProduct(@RequestBody createProductDTO createProductDTO){
        Product product=productService.createProduct(createProductDTO.toProduct());
        return createProductResponseDTO.fromProduct(product);


    }
    @DeleteMapping("/{id}/")
    public String deleteProduct(@PathVariable Long id){
        return "Delete product api is called with id:"+id;

    }
    @DeleteMapping("/")
    public String deleteAllProducts(){
        return "Delete all products api is called";
    }

    @RequestMapping(name = "BILAL" ,value = "/")
    public String customRequest(){
        return "Custom REST Method is called";
    }


}
