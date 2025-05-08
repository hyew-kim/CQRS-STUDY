package com.wanted.cqrs.product.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wanted.cqrs.product.domain.dto.BrandDto;
import com.wanted.cqrs.product.domain.dto.DetailDto;
import com.wanted.cqrs.product.domain.dto.PriceDto;
import com.wanted.cqrs.product.domain.dto.SellerDto;
import com.wanted.cqrs.product.domain.dto.response.ProductDetailSrchResponseDto;
import com.wanted.cqrs.product.domain.entity.*;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository2 {

    private final JPAQueryFactory queryFactory;

    public ProductRepository2(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public ProductDetailSrchResponseDto findProductDetailById(Long id) {
        return queryFactory
                .select(Projections.constructor(
                                ProductDetailSrchResponseDto.class,
                                QProducts.products.id,
                                QProducts.products.name,
                                QProducts.products.slug,
                                QProducts.products.shortDescription,
                                QProducts.products.fullDescription,
                                QProducts.products.status,
                                QProducts.products.createdAt,
                                QProducts.products.updatedAt,
                                Projections.constructor(
                                        SellerDto.class,
                                        QSellers.sellers.id,
                                        QSellers.sellers.name,
                                        QSellers.sellers.logoUrl,
                                        QSellers.sellers.rating,
                                        QSellers.sellers.contactEmail,
                                        QSellers.sellers.contactPhone
                                ),
                                Projections.constructor(
                                        BrandDto.class,
                                        QBrands.brands.id,
                                        QBrands.brands.name,
                                        QBrands.brands.slug,
                                        QBrands.brands.logoUrl,
                                        QBrands.brands.website
                                ),
                                Projections.constructor(
                                        PriceDto.class,
                                        QProductPrice.productPrice.basePrice,
                                        QProductPrice.productPrice.salePrice,
                                        QProductPrice.productPrice.costPrice,
                                        QProductPrice.productPrice.currency,
                                        QProductPrice.productPrice.taxRate
                                ),
                               Projections.constructor(
                                       DetailDto.class,
                                       QProductDetail.productDetail.weight,
                                       QProductDetail.productDetail.dimensions,
                                       QProductDetail.productDetail.materials,
                                       QProductDetail.productDetail.countryOfOrigin,
                                       QProductDetail.productDetail.warrantyInfo,
                                       QProductDetail.productDetail.careInstructions,
                                       QProductDetail.productDetail.additionalInfo
                               )
                        )
                )
                .from(QProducts.products)
                .join(QProducts.products.brand, QBrands.brands)
                .join(QProducts.products.seller, QSellers.sellers)
                .join(QProductPrice.productPrice).on(
                        QProductPrice.productPrice.product.eq(QProducts.products)
                )
                .join(QProductDetail.productDetail).on(
                        QProductDetail.productDetail.product.eq(QProducts.products)
                )
                .where(QProducts.products.id.eq(id))
                .fetchOne();
    }
}

