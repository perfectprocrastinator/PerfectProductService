package com.procrastinator.perfectproductservice.dtos.product;

import com.procrastinator.perfectproductservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private double price;
    private String category;
    public static CreateProductDTO fromProduct(Product product){
        CreateProductDTO responseDTO=new CreateProductDTO();
        responseDTO.setId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setImageUrl(product.getImageUrl());
        responseDTO.setCategory(product.getCategory());
        return responseDTO;
    }
    public Product toProduct() {
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        product.setCategory(this.category);

        return product;
    }
}
