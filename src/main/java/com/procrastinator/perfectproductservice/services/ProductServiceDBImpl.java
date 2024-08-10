package com.procrastinator.perfectproductservice.services;

import com.procrastinator.perfectproductservice.models.Category;
import com.procrastinator.perfectproductservice.models.Product;
import com.procrastinator.perfectproductservice.repositories.CategoryRepository;
import com.procrastinator.perfectproductservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService{
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    ProductServiceDBImpl(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public Product createProduct(Product product) {
        Category category=product.getCategory();
        Category categoryToBePutInProduct=null;
        Optional<Category> category1=categoryRepository.findByName(category.getName());
        if(category1.isEmpty()){
            //create a new category
            Category categoryToSave=new Category();
            categoryToSave.setName(category.getName());
            categoryToSave.setDescription(category.getDescription());
            categoryToBePutInProduct=categoryRepository.save(categoryToSave);
        }
        else{
            categoryToBePutInProduct=category1.get();
        }
        product.setCategory(categoryToBePutInProduct);
        Product product1=productRepository.save(product);
        return product1;
    }
}
