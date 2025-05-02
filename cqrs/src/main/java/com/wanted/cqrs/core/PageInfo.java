package com.wanted.cqrs.core;

import lombok.Data;

@Data
public class PageInfo {
    private int total_items;
    private int total_pages;
    private int current_page;
    private int per_page;
}
