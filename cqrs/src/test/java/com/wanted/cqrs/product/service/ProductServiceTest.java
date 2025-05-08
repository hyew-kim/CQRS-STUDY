package com.wanted.cqrs.product.service;

import com.wanted.cqrs.product.domain.dto.response.ProductDetailSrchResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    void getProduct() {
        ProductDetailSrchResponseDto target = productService.getProduct(1L);
        assertThat(target)
                .isNotNull();
    }
}