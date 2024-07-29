package com.procrastinator.perfectproductservice.services;

import com.procrastinator.perfectproductservice.dtos.FakeStoreCreateProductDTO;
import com.procrastinator.perfectproductservice.dtos.FakeStoreCreateProductResponseDTO;
import com.procrastinator.perfectproductservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        Product product1=new Product();
        product1.setId(responseDTO.getId());
        product1.setTitle(responseDTO.getTitle());
        product1.setDescription(responseDTO.getDescription());
        product1.setCategory(responseDTO.getCategory());
        product1.setImageUrl(product.getImageUrl());
        product1.setPrice(product.getPrice());
        return product1;

    }
}
