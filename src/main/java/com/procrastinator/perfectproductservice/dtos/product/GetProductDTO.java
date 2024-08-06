package com.procrastinator.perfectproductservice.dtos.product;

import com.procrastinator.perfectproductservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private double price;
    private String category;
    public static GetProductDTO fromProduct(Product product){
        GetProductDTO responseDTO=new GetProductDTO();
        responseDTO.setId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setImageUrl(product.getImageUrl());
        responseDTO.setCategory(product.getCategory());
        return responseDTO;
    }
}
