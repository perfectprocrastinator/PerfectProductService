package com.procrastinator.perfectproductservice.validations.productValidation;

import com.procrastinator.perfectproductservice.dtos.product.CreateProductDTO;

public class PutProductValidation {
    public static boolean isValid(CreateProductDTO createProductDTO){
        if(createProductDTO.getTitle() == null || createProductDTO.getDescription() == null || createProductDTO.getPrice() == null || createProductDTO.getImageUrl() == null || createProductDTO.getCategoryName() == null){
            return  false;
        }
        return true;
    }
}
