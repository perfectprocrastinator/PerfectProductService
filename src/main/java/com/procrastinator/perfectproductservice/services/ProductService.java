package com.procrastinator.perfectproductservice.services;

import com.procrastinator.perfectproductservice.dtos.FakeStoreGetProductResponseDTO;
import com.procrastinator.perfectproductservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public interface ProductService {
    Product createProduct(Product product);
    Product getProduct(Long id);
    List<Product> getAllProducts();
    void deleteProduct(Long id);
    Product updateProduct(Long id);


}
