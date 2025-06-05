package br.com.logitrack.stock_flow.controller;

import br.com.logitrack.stock_flow.entity.Product;
import br.com.logitrack.stock_flow.entity.ProductCategory;
import br.com.logitrack.stock_flow.form.ProductForm;
import br.com.logitrack.stock_flow.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody ProductForm form) {
        Long id = service.createProduct(form);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Optional<Product> product = service.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ProductForm form) {
        boolean updated = service.updateProduct(id, form);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.deleteProduct(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/all/category")
    public ResponseEntity<List<ProductCategory>> getAllCategories() {
        return ResponseEntity.ok(service.getAll());
    }
}
