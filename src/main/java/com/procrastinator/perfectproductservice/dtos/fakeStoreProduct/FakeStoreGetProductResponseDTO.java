package com.procrastinator.perfectproductservice.dtos.fakeStoreProduct;

import com.procrastinator.perfectproductservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreGetProductResponseDTO {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
    public Product toProduct(){
        Product product1=new Product();
        product1.setId(this.getId());
        product1.setTitle(this.getTitle());
        product1.setDescription(this.getDescription());
        //product1.setCategory(this.getCategory());
        product1.setImageUrl(this.getImage());
        product1.setPrice(this.getPrice());
        return product1;
    }
}
