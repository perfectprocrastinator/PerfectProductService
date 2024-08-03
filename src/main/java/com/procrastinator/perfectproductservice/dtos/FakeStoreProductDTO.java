package com.procrastinator.perfectproductservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
