package com.wanted.cqrs.product.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandDto {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private String logoUrl;
    private String website;

    @QueryProjection
    public BrandDto(Long id, String name, String slug, String logoUrl, String website) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.logoUrl = logoUrl;
        this.website = website;
    }
}
