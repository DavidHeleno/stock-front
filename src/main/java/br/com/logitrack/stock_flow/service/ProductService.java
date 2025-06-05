package br.com.logitrack.stock_flow.service;

import br.com.logitrack.stock_flow.entity.Product;
import br.com.logitrack.stock_flow.entity.ProductCategory;
import br.com.logitrack.stock_flow.form.ProductForm;
import br.com.logitrack.stock_flow.repository.ProductCategoryRepository;
import br.com.logitrack.stock_flow.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    public ProductService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    @Transactional
    public Long createProduct(ProductForm form) {
        ProductCategory category = productCategoryRepository.findById(form.category_id())
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        Product product = form.toEntity(category);
        return productRepository.save(product).getId();
    }

    public List<Product> findAll() {
        return productRepository.findAll().stream().filter(Product::getActive).toList();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public boolean updateProduct(Long id, ProductForm form) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            Product existing = optional.get();
            existing.setName(form.name());
            existing.setType(form.type());
            existing.setSku(form.sku());
            existing.setUpdateAt(LocalDateTime.now());

            ProductCategory category = productCategoryRepository.findById(form.category_id())
                    .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

            existing.setCategory(category);
            productRepository.save(existing);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean deleteProduct(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            Product product = optional.get();
            product.setActive(false);
            product.setUpdateAt(LocalDateTime.now());
            productRepository.save(product);
            return true;
        }
        return false;
    }

    public List<ProductCategory> getAll() {
        return productCategoryRepository.findAll();
    }
}
