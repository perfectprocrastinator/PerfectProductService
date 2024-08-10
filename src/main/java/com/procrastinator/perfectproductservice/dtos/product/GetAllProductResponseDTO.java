package com.procrastinator.perfectproductservice.dtos.product;

import lombok.Setter;

import java.util.List;
@Setter
public class GetAllProductResponseDTO {
    private List<GetProductDTO> products;

}
