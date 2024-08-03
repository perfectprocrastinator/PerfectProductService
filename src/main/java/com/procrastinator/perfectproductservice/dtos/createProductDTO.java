package com.procrastinator.perfectproductservice.dtos;

import com.procrastinator.perfectproductservice.models.Category;
import com.procrastinator.perfectproductservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class createProductDTO {
    private String title;
    private double price;
    private String category;
    private String description;
    private String imageUrl;
    public Product toProduct(){
        Product product=new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setCategory(this.category);
        product.setImageUrl(this.imageUrl);
        return product;
    }
}
