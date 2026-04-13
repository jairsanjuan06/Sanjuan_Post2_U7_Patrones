package com.example.hexagonal.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoJpaRepository extends JpaRepository<ProductoJpaEntity, Long> {
}
