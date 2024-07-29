package com.procrastinator.perfectproductservice.dtos;

import lombok.Getter;

@Getter
public class FakeStoreCreateProductResponseDTO {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
