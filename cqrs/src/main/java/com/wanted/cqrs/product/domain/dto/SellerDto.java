package com.wanted.cqrs.product.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerDto {
    private Long id;
    private String name;
    private String description;
    private String logoUrl;
    private BigDecimal rating;
    private String contactEmail;
    private String contactPhone;
    private LocalDateTime createdAt;

    public SellerDto(Long id, String name, String logoUrl, BigDecimal rating, String contactEmail, String contactPhone) {
        this.id = id;
        this.name = name;
        this.logoUrl = logoUrl;
        this.rating = rating;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    @QueryProjection
    public SellerDto(Long id, String name, String logoUrl, BigDecimal rating, String contactEmail, String contactPhone, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.logoUrl = logoUrl;
        this.rating = rating;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.createdAt = createdAt;
    }
}
