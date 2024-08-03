package com.procrastinator.perfectproductservice.controllers;

import com.procrastinator.perfectproductservice.dtos.*;
import com.procrastinator.perfectproductservice.models.Product;
import com.procrastinator.perfectproductservice.services.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @PostMapping
    public createProductResponseDTO createProduct(@RequestBody createProductDTO createProductDTO){
        Product product=productService.createProduct(createProductDTO.toProduct());
        return createProductResponseDTO.fromProduct(product);


    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);

    }
    @GetMapping("")
    public List<GetProductResponseDTO> getAllProducts(){
        List<Product> productList= productService.getAllProducts();
        List<GetProductResponseDTO> getProductResponseDTOList=new ArrayList<>();
        for(Product p:productList){
//            GetProductResponseDTO getProductResponseDTO=new GetProductResponseDTO();
//            getProductResponseDTO.setId(p.getId());
//            getProductResponseDTO.setDescription(p.getDescription());
//            getProductResponseDTO.setTitle(p.getTitle());
//            getProductResponseDTO.setPrice(p.getPrice());
//            getProductResponseDTO.setCategory(p.getCategory());
//            getProductResponseDTO.setImageUrl(p.getImageUrl());
//            getProductResponseDTOList.add(getProductResponseDTO);

        }
        return getProductResponseDTOList;
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @PatchMapping("/{id}")
    public UpdateProductDTO updateProduct(@PathVariable Long id){
            productService.updateProduct(id);

    }


    @RequestMapping(name = "BILAL" ,value = "/")
    public String customRequest(){
        return "Custom REST Method is called";
    }


}
