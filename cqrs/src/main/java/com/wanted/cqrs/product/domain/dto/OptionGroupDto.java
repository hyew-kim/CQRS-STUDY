package com.wanted.cqrs.product.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionGroupDto {
    private Long id;
    private String name;
    private Integer displayOrder;
    private List<OptionDto> options;
}
