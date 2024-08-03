package com.procrastinator.perfectproductservice.models;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    private String title;
    private String description;
    private double price;

    private String imageUrl;
    //@ManyToOne
    private String category;
}
