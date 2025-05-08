package com.wanted.cqrs.product.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product_options")
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "option_group_id")
    private ProductOptionGroup optionGroup;

    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ColumnDefault("0")
    @Column(name = "additional_price", precision = 12, scale = 2)
    private BigDecimal additionalPrice;

    @Size(max = 100)
    @Column(name = "sku", length = 100)
    private String sku;

    @ColumnDefault("0")
    @Column(name = "stock")
    private Integer stock;

    @ColumnDefault("0")
    @Column(name = "display_order")
    private Integer displayOrder;

}