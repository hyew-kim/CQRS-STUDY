package com.wanted.cqrs.product.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_id")
    private Products product;

    @NotNull
    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Size(max = 255)
    @Column(name = "title")
    private String title;

    @Column(name = "content", length = Integer.MAX_VALUE)
    private String content;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

    @ColumnDefault("false")
    @Column(name = "verified_purchase")
    private Boolean verifiedPurchase;

    @ColumnDefault("0")
    @Column(name = "helpful_votes")
    private Integer helpfulVotes;

}