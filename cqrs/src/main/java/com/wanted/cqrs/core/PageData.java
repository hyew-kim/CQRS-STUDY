package com.wanted.cqrs.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PageData<T> {
    private List<T> items;
    private Pagination pagination;

    @Getter
    @Builder
    public static class Pagination {
        private int total_items;
        private int total_pages;
        private int current_page;
        private int per_page;
    }
}