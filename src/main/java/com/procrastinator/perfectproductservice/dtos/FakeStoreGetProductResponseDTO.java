package com.procrastinator.perfectproductservice.dtos;

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
}
