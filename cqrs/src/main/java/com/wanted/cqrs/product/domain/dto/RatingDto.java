package com.wanted.cqrs.product.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    private Double average;
    private Integer count;
    private Map<String, Integer> distribution;
}
