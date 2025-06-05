package br.com.logitrack.stock_flow.entity;

import br.com.logitrack.stock_flow.enuns.DocumentType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_documentation")
@Data
public class UserDocumentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DocumentType type;

    private String description;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "bucket_path")
    private String bucketPath;

    private Boolean valid = true;

    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @Column(name = "issuing_body")
    private String issuingBody;

    @Column(name = "create_at")
    private LocalDateTime createAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
