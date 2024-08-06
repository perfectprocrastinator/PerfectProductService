package com.procrastinator.perfectproductservice.dtos.fakeStoreProduct;

import com.procrastinator.perfectproductservice.models.Category;
import com.procrastinator.perfectproductservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreCreateProductDTO {
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

}
