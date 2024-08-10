package com.procrastinator.perfectproductservice.services;

import com.procrastinator.perfectproductservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product createProduct(Product product);
//    Product getProduct(Long id);
//    List<Product> getAllProducts();
//    void deleteProduct(Long id);
//    //Product updateProduct(Long id);
//
//    Product partialUpdateProduct(Long id);


}
