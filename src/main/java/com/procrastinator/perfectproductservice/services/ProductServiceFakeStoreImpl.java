package com.procrastinator.perfectproductservice.services;

import com.procrastinator.perfectproductservice.dtos.*;
import com.procrastinator.perfectproductservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class ProductServiceFakeStoreImpl implements ProductService{
    private RestTemplate restTemplate;
    //Spring does not create a bean of RestTemplate by its own ,so we need to create beans manually by adding methods in configs
    public ProductServiceFakeStoreImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;

    }
    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductDTO fakeStoreCreateProductDTO=new FakeStoreCreateProductDTO();
        fakeStoreCreateProductDTO.setTitle(product.getTitle());
        fakeStoreCreateProductDTO.setPrice(product.getPrice());
        fakeStoreCreateProductDTO.setCategory(product.getCategory());
        fakeStoreCreateProductDTO.setDescription(product.getDescription());
        fakeStoreCreateProductDTO.setImage(product.getImageUrl());
        FakeStoreCreateProductResponseDTO responseDTO=restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreCreateProductDTO,
                FakeStoreCreateProductResponseDTO.class);
        FakeStoreProductDTO fakeStoreProductDTO= responseDTO.getFakeStoreProductDTO();
        Product product1=new Product();
        product1.setId(fakeStoreProductDTO.getId());
        product1.setTitle(fakeStoreProductDTO.getTitle());
        product1.setDescription(fakeStoreProductDTO.getDescription());
        product1.setCategory(fakeStoreProductDTO.getCategory());
        product1.setImageUrl(fakeStoreProductDTO.getImage());
        product1.setPrice(fakeStoreProductDTO.getPrice());
        return product1;

    }
    public Product getProduct(Long id){
        FakeStoreGetProductResponseDTO fakeStoreGetProductResponseDTO=restTemplate.getForObject("https://fakestoreapi.com/products/"+id,FakeStoreGetProductResponseDTO.class);

        Product product1=new Product();
        product1.setId(fakeStoreGetProductResponseDTO.getId());
        product1.setTitle(fakeStoreGetProductResponseDTO.getTitle());
        product1.setDescription(fakeStoreGetProductResponseDTO.getDescription());
        product1.setCategory(fakeStoreGetProductResponseDTO.getCategory());
        product1.setImageUrl(fakeStoreGetProductResponseDTO.getImage());
        product1.setPrice(fakeStoreGetProductResponseDTO.getPrice());
        return product1;



    }
    public List<Product> getAllProducts(){
        FakeStoreGetProductResponseDTO[] fakeStoreGetProductResponseDTOList=restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreGetProductResponseDTO[].class);
        List<Product> productList=new ArrayList<>();
        for(FakeStoreGetProductResponseDTO fakeStoreGetProductResponseDTO:fakeStoreGetProductResponseDTOList){
            Product product1=new Product();
            product1.setId(fakeStoreGetProductResponseDTO.getId());
            product1.setTitle(fakeStoreGetProductResponseDTO.getTitle());
            product1.setDescription(fakeStoreGetProductResponseDTO.getDescription());
            product1.setCategory(fakeStoreGetProductResponseDTO.getCategory());
            product1.setImageUrl(fakeStoreGetProductResponseDTO.getImage());
            product1.setPrice(fakeStoreGetProductResponseDTO.getPrice());
            productList.add(product1);
        }
        return productList;


    }
    public void deleteProduct(Long id){
        System.out.println("deleteProduct API");
        restTemplate.delete("https://fakestoreapi.com/products/"+id);
        System.out.println("Delete success");

    }
    public Product updateProduct(Long id){

        FakeStoreUpdateProductDTO fakeStoreUpdateProductDTO=restTemplate.patchForObject("https://fakestoreapi.com/products/"+id,FakeStoreUpdateProductDTO.class);
        return fakeStoreUpdateProductDTO;
    }



}
