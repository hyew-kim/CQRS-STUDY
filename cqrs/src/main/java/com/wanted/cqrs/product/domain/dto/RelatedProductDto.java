package com.wanted.cqrs.product.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelatedProductDto {
    private Long id;
    private String name;
    private String slug;
    private String shortDescription;
    private ImageDto primaryImage;
    private BigDecimal basePrice;
    private BigDecimal salePrice;
    private String currency;
}
