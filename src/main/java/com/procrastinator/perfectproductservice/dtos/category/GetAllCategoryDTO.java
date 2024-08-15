package com.procrastinator.perfectproductservice.dtos.category;

import com.procrastinator.perfectproductservice.models.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GetAllCategoryDTO {
    private Long id;
    private String name;
    private String description;
}
