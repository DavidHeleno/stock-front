package br.com.logitrack.stock_flow.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    private Boolean active;
    private String sku;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    public Product(String name, String type, String sku, ProductCategory category) {
        this.name = name;
        this.type = type;
        this.sku = sku;
        this.category = category;
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
        this.active = true;
    }

    public Product() {

    }
}