package com.wanted.cqrs.product.controller;

import com.wanted.cqrs.core.ErrorType;
import com.wanted.cqrs.core.response.SuccessResponse;
import com.wanted.cqrs.exception.AlertException;
import com.wanted.cqrs.product.domain.ProductSrchRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @PostMapping("/")
    public ResponseEntity<SuccessResponse<String>> createProduct(HttpServletRequest request) {
        try {
            SuccessResponse<String> response = SuccessResponse.<String>builder()
                    .message("상품 목록을 성공적으로 조회했습니다.")
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
    public ResponseEntity<SuccessResponse<String>> getProducts(@ParameterObject @Valid ProductSrchRequest request) {
        try {
            SuccessResponse<String> response = SuccessResponse.<String>builder()
                    .message("상품 목록을 성공적으로 조회했습니다.")
                    .data("sample")
                    .build();

            return ResponseEntity.ok()
                    .body(response);
        } catch (Exception ex) {
            throw new AlertException(ErrorType.RESOURCE_NOT_FOUND, "요청한 상품을 찾을 수 없습니다.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<String>> getProducts(@PathVariable String id) {
        try {
            SuccessResponse<String> response = SuccessResponse.<String>builder()
                    .message("상품 상세 정보를 성공적으로 조회했습니다.")
                    .data(id)
                    .build();

            return ResponseEntity.ok()
                    .body(response);
        } catch (Exception ex) {
            throw new AlertException(ErrorType.RESOURCE_NOT_FOUND, "요청한 상품을 찾을 수 없습니다.");
        }
    }
}
