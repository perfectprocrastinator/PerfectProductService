package com.procrastinator.perfectproductservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class createProductDTO {
    private Long id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String imageUrl;
}
