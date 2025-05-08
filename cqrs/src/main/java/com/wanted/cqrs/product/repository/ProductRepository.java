package com.wanted.cqrs.product.repository;

import com.wanted.cqrs.product.domain.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

}
