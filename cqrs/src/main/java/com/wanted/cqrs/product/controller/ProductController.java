package com.wanted.cqrs.product.controller;

import com.wanted.cqrs.core.ErrorType;
import com.wanted.cqrs.core.PageData;
import com.wanted.cqrs.core.response.SuccessResponse;
import com.wanted.cqrs.exception.AlertException;
import com.wanted.cqrs.product.domain.dto.request.ProductListSrchRequestDto;
import com.wanted.cqrs.product.domain.dto.response.ProductDetailSrchResponseDto;
import com.wanted.cqrs.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<SuccessResponse<String>> createProduct(HttpServletRequest request) {
        try {
            SuccessResponse<String> response = SuccessResponse.<String>builder()
                    .message("상품이 성공적으로 등록되었습니다.")
                    .data("A")
                    .build();

            return ResponseEntity.created(URI.create(request.getRequestURI()))
                    .body(response);
        } catch (Exception ex) {
            Map<String, Object> detail = new HashMap<>();
            detail.put("name", "상품명은 필수 항목입니다.");
            detail.put("base_price", "기본 가격은 0보다 커야 합니다.");

            throw new AlertException(ErrorType.INVALID_INPUT, "상품 등록에 실패했습니다.", detail);
        }
    }

    @GetMapping("/")
    public ResponseEntity<SuccessResponse<PageData<String>>> getProducts(@ParameterObject @Valid ProductListSrchRequestDto request) {
        try {
            List<String> items = Collections.singletonList("A");

            PageData<String> pageData = PageData.<String>builder()
                    .items(items)
                    .pagination(PageData.Pagination.builder()
                            .total_items(100)
                            .total_pages(100)
                            .current_page(1)
                            .per_page(10)
                            .build())
                    .build();

            SuccessResponse<PageData<String>> response = SuccessResponse.<PageData<String>>builder()
                    .message("상품 목록을 성공적으로 조회했습니다.")
                    .data(pageData)
                    .build();

            return ResponseEntity.ok()
                    .body(response);
        } catch (Exception ex) {
            throw new AlertException(ErrorType.RESOURCE_NOT_FOUND, "요청한 상품을 찾을 수 없습니다.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<ProductDetailSrchResponseDto>> getProducts(@PathVariable String id) {
        try {
            ProductDetailSrchResponseDto data = productService.getProduct(Long.valueOf(id));
            if (data == null) {
                throw new RuntimeException();
            }
            SuccessResponse<ProductDetailSrchResponseDto> response = SuccessResponse.<ProductDetailSrchResponseDto>builder()
                    .message("상품 상세 정보를 성공적으로 조회했습니다.")
                    .data(data)
                    .build();

            return ResponseEntity.ok()
                    .body(response);
        } catch (Exception ex) {
            throw new AlertException(ErrorType.RESOURCE_NOT_FOUND, "요청한 상품을 찾을 수 없습니다.");
        }
    }
}
