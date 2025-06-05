package br.com.logitrack.stock_flow.repository;

import br.com.logitrack.stock_flow.entity.ContainerProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerProductRepository extends JpaRepository<ContainerProduct, Long> {


}
