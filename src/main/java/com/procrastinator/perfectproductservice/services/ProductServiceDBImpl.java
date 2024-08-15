package com.procrastinator.perfectproductservice.services;

import com.procrastinator.perfectproductservice.dtos.product.CreateProductDTO;
import com.procrastinator.perfectproductservice.exceptions.ProductNotFoundException;
import com.procrastinator.perfectproductservice.models.Category;
import com.procrastinator.perfectproductservice.models.Product;
import com.procrastinator.perfectproductservice.repositories.CategoryRepository;
import com.procrastinator.perfectproductservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
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
    @Override
    public List<Product> getAllProducts(){
       List<Product> allProducts=productRepository.findAll();
       return allProducts;
    }
    @Override
    public Product getProduct(Long id){
        Optional<Product> product=productRepository.findById(id);
        return product.get();
    }
    @Override
    public  void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
    @Override
    public Product patchProduct(Long id,Product updatedProduct){
        Optional<Product> optionalProduct=productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("The product to be changed does not exists in DB");
        }
        Product savedProduct=optionalProduct.get();
        if(updatedProduct.getTitle() != null){
            savedProduct.setTitle(updatedProduct.getTitle());
        }
        if(updatedProduct.getPrice() != null){
            savedProduct.setPrice(updatedProduct.getPrice());
        }
        if(updatedProduct.getDescription() != null){
            savedProduct.setDescription(updatedProduct.getDescription());
        }
        if(updatedProduct.getImageUrl() != null){
            savedProduct.setImageUrl(updatedProduct.getImageUrl());
        }
        if(updatedProduct.getCategory() != null){
            Category updatedCategory=updatedProduct.getCategory();
            savedProduct.setCategory(updatedCategory);
        }
        categoryRepository.save(savedProduct.getCategory());
        productRepository.save(savedProduct);
        return savedProduct;
    }
    @Override
    public Product putProduct(Long id,Product updatedProduct){
        Optional<Product> optionalProduct=productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("The product to be changed does not exists in DB");
        }
        Product savedProduct=optionalProduct.get();
        if(updatedProduct.getTitle() != null){
            savedProduct.setTitle(updatedProduct.getTitle());
        }
        if(updatedProduct.getPrice() != null){
            savedProduct.setPrice(updatedProduct.getPrice());
        }
        if(updatedProduct.getDescription() != null){
            savedProduct.setDescription(updatedProduct.getDescription());
        }
        if(updatedProduct.getImageUrl() != null){
            savedProduct.setImageUrl(updatedProduct.getImageUrl());
        }
        if(updatedProduct.getCategory() != null){
            Category updatedCategory=updatedProduct.getCategory();
            savedProduct.setCategory(updatedCategory);
        }
        categoryRepository.save(savedProduct.getCategory());
        productRepository.save(savedProduct);
        return savedProduct;
    }


}
