package com.procrastinator.perfectproductservice.dtos.product;

import com.procrastinator.perfectproductservice.models.Category;
import com.procrastinator.perfectproductservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDTO {
    private String title;
    private String description;
    private String imageUrl;
    private Double price;
    private String categoryName;

    public Product toProduct() {
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        Category category=new Category();
        category.setName(this.categoryName);
        product.setCategory(category);

        return product;
    }
}
