package com.wanted.cqrs.product.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {
    private Long id;
    private String url;
    private String altText;
    private boolean isPrimary;
    private Integer displayOrder;
    private Long optionId;
}
