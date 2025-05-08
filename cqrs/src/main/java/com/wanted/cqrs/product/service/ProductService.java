package com.wanted.cqrs.product.service;

import com.wanted.cqrs.product.domain.dto.response.ProductDetailSrchResponseDto;
import com.wanted.cqrs.product.repository.ProductRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository2 productRepository;

    public ProductDetailSrchResponseDto getProduct(Long id) {
        return productRepository.findProductDetailById(id);
    }
}
