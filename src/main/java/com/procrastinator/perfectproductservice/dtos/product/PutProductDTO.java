package com.procrastinator.perfectproductservice.dtos.product;

import com.procrastinator.perfectproductservice.models.Category;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class PutProductDTO {
    private String title;
    private String description;
    private Double price;

    private Category category;
}
