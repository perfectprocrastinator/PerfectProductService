package com.procrastinator.perfectproductservice.dtos;

import com.procrastinator.perfectproductservice.models.Category;
import com.procrastinator.perfectproductservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class createProductResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private double price;
    private String category;
    public static createProductResponseDTO fromProduct(Product product){
        createProductResponseDTO responseDTO=new createProductResponseDTO();
        responseDTO.setId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setImageUrl(product.getImageUrl());
        responseDTO.setCategory(product.getCategory());
        return responseDTO;
    }
}
