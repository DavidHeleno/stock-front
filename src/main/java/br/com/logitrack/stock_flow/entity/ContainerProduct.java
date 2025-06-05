package br.com.logitrack.stock_flow.entity;

import br.com.logitrack.stock_flow.enuns.ContainerTypes;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "container_product")
@Data
public class ContainerProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String location;

    @Enumerated(EnumType.STRING)
    private ContainerTypes type;
    private Boolean active = true;

    @Column(name = "create_at")
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(name = "update_at")
    private LocalDateTime updateAt = LocalDateTime.now() ;
}