package br.com.logitrack.stock_flow.form;

import br.com.logitrack.stock_flow.entity.Product;
import br.com.logitrack.stock_flow.entity.ProductCategory;

import java.time.LocalDateTime;

public record ProductForm(
        String name,
        String type,
        String sku,
        Long category_id
) {

    public Product toEntity(ProductCategory category) {
        return new Product(
                name,
                type,
                sku,
                category
        );
    }

}
