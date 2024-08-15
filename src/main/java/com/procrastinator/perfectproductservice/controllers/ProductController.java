package com.procrastinator.perfectproductservice.controllers;

import com.procrastinator.perfectproductservice.dtos.product.*;
import com.procrastinator.perfectproductservice.exceptions.InvalidParameterException;
import com.procrastinator.perfectproductservice.models.Product;
import com.procrastinator.perfectproductservice.services.ProductService;
import com.procrastinator.perfectproductservice.validations.productValidation.PutProductValidation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    //Qualifier is used to tell Spring which class's object to inject when Spring itself can't decide which object to inject
    public ProductController(@Qualifier("dbProductService") ProductService productService){
        this.productService=productService;
    }
    @PostMapping
    public CreateProductResponseDTO createProduct(@RequestBody CreateProductDTO createProductDTO){
        Product product=productService.createProduct(createProductDTO.toProduct());
        return CreateProductResponseDTO.fromProduct(product);
    }
    @GetMapping
    public GetAllProductResponseDTO getAllProducts(){
        List<Product> allProducts=productService.getAllProducts();
        GetAllProductResponseDTO getAllProductResponseDTO = new GetAllProductResponseDTO();
        List<GetProductDTO> getProductDTOList = new ArrayList<>();
        for(Product p:allProducts){
            getProductDTOList.add(GetProductDTO.fromProduct(p));
        }
        getAllProductResponseDTO.setProducts(getProductDTOList);
        return getAllProductResponseDTO;
    }
    @GetMapping("/{id}")
    public GetProductResponseDTO getProduct(@PathVariable("id") Long id){
        Product product=productService.getProduct(id);
        GetProductResponseDTO getProductResponseDTO=new GetProductResponseDTO();
        getProductResponseDTO.setGetProductDTO(GetProductDTO.fromProduct(product));
        return getProductResponseDTO;
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
    @PatchMapping("/{id}")
    public UpdateProductResponseDTO patchProduct(@PathVariable("id") Long id,@RequestBody CreateProductDTO createProductDTO){
        Product product=productService.patchProduct(id,createProductDTO.toProduct());
        UpdateProductResponseDTO updateProductResponseDTO=new UpdateProductResponseDTO();
        updateProductResponseDTO.setGetProductDTO(GetProductDTO.fromProduct(product));
        return updateProductResponseDTO;
    }
    @PutMapping("/{id}")
    public UpdateProductResponseDTO putProduct(@PathVariable("id") Long id,@RequestBody CreateProductDTO createProductDTO){
        if(!PutProductValidation.isValid(createProductDTO)){
            throw new InvalidParameterException("putProduct api is called with missing parameter values");
        }
        Product product=productService.putProduct(id,createProductDTO.toProduct());
        UpdateProductResponseDTO updateProductResponseDTO=new UpdateProductResponseDTO();
        updateProductResponseDTO.setGetProductDTO(GetProductDTO.fromProduct(product));
        return updateProductResponseDTO;
    }





    @RequestMapping(name = "BILAL" ,value = "/")
    public String customRequest(){
        return "Custom REST Method is called";
    }


}
