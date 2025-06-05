package br.com.logitrack.stock_flow.service;

import br.com.logitrack.stock_flow.dto.TypeContainerDTO;
import br.com.logitrack.stock_flow.entity.ContainerProduct;
import br.com.logitrack.stock_flow.enuns.ContainerTypes;
import br.com.logitrack.stock_flow.form.ContainerProductForm;
import br.com.logitrack.stock_flow.repository.ContainerProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ContainerProductService {

    private final ContainerProductRepository repository;

    public ContainerProductService(ContainerProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Long registerContainer(ContainerProductForm form) {
        ContainerProduct cont = repository.save(form.toEntity());
        return cont.getId();
    }

    public List<ContainerProduct> findAll() {
        return repository.findAll();
    }

    // READ - Get by ID
    public Optional<ContainerProduct> findById(Long id) {
        return repository.findById(id);
    }

    // UPDATE
    @Transactional
    public boolean updateContainer(Long id, ContainerProductForm form) {
        Optional<ContainerProduct> optional = repository.findById(id);
        if (optional.isPresent()) {
            ContainerProduct entity = optional.get();
            entity.setName(form.name());
            entity.setDescription(form.description());
            entity.setLocation(form.location());
            entity.setType(ContainerTypes.valueOf(form.type()));
            entity.setUpdateAt(LocalDateTime.now());
            repository.save(entity);
            return true;
        }
        return false;
    }

    // DELETE (soft delete, atualiza o active para false)
    @Transactional
    public boolean deleteContainer(Long id) {
        Optional<ContainerProduct> optional = repository.findById(id);
        if (optional.isPresent()) {
            ContainerProduct entity = optional.get();
            entity.setActive(false);
            entity.setUpdateAt(LocalDateTime.now());
            repository.save(entity);
            return true;
        }
        return false;
    }

    public List<TypeContainerDTO> typesContainer() {
        return Arrays.stream(ContainerTypes.values())
                .map(type -> new TypeContainerDTO(type.name(), type.getDescription()))
                .toList();
    }

}
