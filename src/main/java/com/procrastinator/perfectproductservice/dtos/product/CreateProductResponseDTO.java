package com.procrastinator.perfectproductservice.dtos.product;

import com.procrastinator.perfectproductservice.models.Category;
import com.procrastinator.perfectproductservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private double price;
    private String categoryName;
    public static CreateProductResponseDTO fromProduct(Product product){
        CreateProductResponseDTO responseDTO=new CreateProductResponseDTO();
        responseDTO.setId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setImageUrl(product.getImageUrl());
        responseDTO.setCategoryName(product.getCategory().getName());
        return responseDTO;
    }
}
