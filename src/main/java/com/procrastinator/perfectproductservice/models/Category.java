package com.procrastinator.perfectproductservice.models;


import java.util.List;
public class Category extends BaseModel {
    private String name;
    private String description;
    //@OneToMany
    private List<Product> featuredProducts;
    //@OneToMany(mappedBy = "category")
    private List<Product> allProducts;
}
