package com.procrastinator.perfectproductservice.dtos.product;

import com.procrastinator.perfectproductservice.dtos.category.GetAllCategoryDTO;
import com.procrastinator.perfectproductservice.models.Category;
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
    private GetAllCategoryDTO category;
    public static GetProductDTO fromProduct(Product product){
        GetProductDTO responseDTO=new GetProductDTO();
        responseDTO.setId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setImageUrl(product.getImageUrl());
        responseDTO.setCategory(fromCategory(product.getCategory()));
        return responseDTO;
    }

    public static GetAllCategoryDTO fromCategory(Category category){
        GetAllCategoryDTO getAllCategoryDTO=new GetAllCategoryDTO();
        getAllCategoryDTO.setName(category.getName());
        getAllCategoryDTO.setId(category.getId());
        getAllCategoryDTO.setDescription(category.getDescription());
        return getAllCategoryDTO;

    }
}
