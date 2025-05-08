package com.wanted.cqrs.product.domain.dto.response;

import com.wanted.cqrs.product.domain.Status;
import com.wanted.cqrs.product.domain.dto.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductDetailSrchResponseDto {
    private Long id;
    private String name;
    private String slug;
    private String shortDescription;
    private String fullDescription;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private SellerDto seller;
    private BrandDto brand;

    private DetailDto detail;
    private PriceDto price;

    private List<CategoryDto> categories;
    private List<OptionGroupDto> optionGroups;
    private List<ImageDto> images;
    private List<TagDto> tags;
    private RatingDto rating;
    private List<RelatedProductDto> relatedProducts;

    public ProductDetailSrchResponseDto(
            Long id,
            String name,
            String slug,
            String shortDescription,
            String fullDescription,
            Status status,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            SellerDto seller,
            BrandDto brand,
            PriceDto price,
            DetailDto detail
    ) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.seller = seller;
        this.brand = brand;
        this.price = price;
        this.detail = detail;
    }
}
