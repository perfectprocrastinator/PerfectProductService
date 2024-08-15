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
    public Product updateProduct(Long id, Product product){
        Optional<Product> savedProduct=productRepository.findById(id);
        if(savedProduct.isEmpty()){
            //Product with that Id does not exists
            throw new ProductNotFoundException("The product with id "+id+" does not exists");
        }
        Product productToUpdate=savedProduct.get();
        if(product.getTitle() != null){
            productToUpdate.setTitle(product.getTitle());
        }
        if(product.getPrice() != null){
            productToUpdate.setPrice(product.getPrice());
        }
        if(product.getDescription() != null){
            productToUpdate.setDescription(product.getDescription());
        }
        if(product.getImageUrl() != null){
            productToUpdate.setImageUrl(product.getImageUrl());
        }
        if(product.getCategory() != null){
            Category updatedCategory=product.getCategory();
            productToUpdate.setCategory(updatedCategory);
        }
        return productRepository.save(productToUpdate);



    }


}
