package com.wanted.cqrs.product.controller;

import com.wanted.cqrs.core.BaseResponse;
import com.wanted.cqrs.core.ErrorType;
import com.wanted.cqrs.exception.AlertException;
import com.wanted.cqrs.product.domain.ProductSrchRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @PostMapping("/")
    public ResponseEntity<BaseResponse<?>> createProduct(HttpServletRequest request) {
        Map<String, Object> detail = new HashMap<>();
        detail.put("name", "상품명은 필수 항목입니다.");
        detail.put("base_price", "기본 가격은 0보다 커야 합니다.");

         throw new AlertException(ErrorType.INVALID_INPUT, "상품 등록에 실패했습니다.", detail);
//        return ResponseEntity.created(URI.create(request.getRequestURI())).build();
    }

    @GetMapping("/")
    public ResponseEntity<BaseResponse<?>> getProducts(@ParameterObject @Valid ProductSrchRequest request) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<?>> getProducts(@PathVariable String id) {
        throw new AlertException(ErrorType.RESOURCE_NOT_FOUND, "요청한 상품을 찾을 수 없습니다.");
//        return ResponseEntity.ok().build();
    }
}
