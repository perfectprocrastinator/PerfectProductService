package com.procrastinator.perfectproductservice.services;

import com.procrastinator.perfectproductservice.dtos.product.CreateProductDTO;
import com.procrastinator.perfectproductservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProduct(Long id);
    Product updateProduct(Long id, Product product);
//    void deleteProduct(Long id);
//
//    Product partialUpdateProduct(Long id);


}
