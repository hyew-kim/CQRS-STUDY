package com.wanted.cqrs.product.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductSrchRequest {
    private int page = 1;
    private int perPage = 10;
    //TODO: 다중 정렬 요청 처리 로직 필요함
    @Schema(example = "created_at:desc")
    private String sort = "created_at:desc";
    @Schema(implementation = Status.class)
    private Status status;
    private int minPrice;
    private int maxPrice;
    private int[] category;
    private int seller;
    private int brand;
    private boolean inStock;
    private String search;

    // sort 파라미터 파싱을 위한 메서드들
    public String getSortField() {
        return sort.split(":")[0];
    }

    public String getSortDirection() {
        String[] parts = sort.split(":");
        return parts.length > 1 ? parts[1].toUpperCase() : "DESC";
    }

//    // Spring Data JPA에서 사용하기 위한 메서드
//    public Sort toSpringSort() {
//        String direction = getSortDirection();
//        return Sort.by(
//                direction.equalsIgnoreCase("ASC") ?
//                        Sort.Direction.ASC :
//                        Sort.Direction.DESC,
//                getSortField()
//        );
//    }
}
