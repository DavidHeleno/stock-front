package br.com.logitrack.stock_flow.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_category")
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
}
