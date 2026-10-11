package com.sudhabelur.backend.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;

    private BigDecimal price;

    private Boolean available;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}