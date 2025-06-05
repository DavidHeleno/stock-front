package br.com.logitrack.stock_flow.controller;

import br.com.logitrack.stock_flow.dto.TypeContainerDTO;
import br.com.logitrack.stock_flow.entity.ContainerProduct;
import br.com.logitrack.stock_flow.enuns.ContainerTypes;
import br.com.logitrack.stock_flow.form.ContainerProductForm;
import br.com.logitrack.stock_flow.service.ContainerProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("container/product")
public class ContainerProductController {

    private final ContainerProductService service;

    public ContainerProductController(ContainerProductService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Long> register(@RequestBody ContainerProductForm form) {
        Long id = service.registerContainer(form);
        return ResponseEntity.ok(id);
    }

    // READ - Get all
    @GetMapping
    public ResponseEntity<List<ContainerProduct>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // READ - Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<ContainerProduct> getById(@PathVariable Long id) {
        Optional<ContainerProduct> result = service.findById(id);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ContainerProductForm form) {
        boolean updated = service.updateContainer(id, form);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    // DELETE (soft delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.deleteContainer(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/type")
    public ResponseEntity<List<TypeContainerDTO>> types() {
        return ResponseEntity.ok(service.typesContainer());
    }
}
