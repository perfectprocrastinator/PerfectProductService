package com.procrastinator.perfectproductservice.services;

import com.procrastinator.perfectproductservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public interface ProductService {
    Product createProduct(Product product);


}
