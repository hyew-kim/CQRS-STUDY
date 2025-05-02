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

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @PostMapping("/")
    public ResponseEntity<BaseResponse<?>> createProduct(HttpServletRequest request) {
         throw new AlertException(ErrorType.INVALID_INPUT);
//        return ResponseEntity.created(URI.create(request.getRequestURI())).build();
    }

    @GetMapping("/")
    public ResponseEntity<BaseResponse<?>> getProducts(@ParameterObject @Valid ProductSrchRequest request) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<?>> getProducts(@PathVariable String id) {
        throw new AlertException(ErrorType.RESOURCE_NOT_FOUND);
//        return ResponseEntity.ok().build();
    }
}
