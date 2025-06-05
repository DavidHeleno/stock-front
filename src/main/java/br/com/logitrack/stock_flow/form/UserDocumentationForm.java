package br.com.logitrack.stock_flow.form;

import br.com.logitrack.stock_flow.entity.User;
import br.com.logitrack.stock_flow.entity.UserDocumentation;
import br.com.logitrack.stock_flow.enuns.DocumentType;

import java.time.LocalDateTime;

public record UserDocumentationForm(
        DocumentType type,
        String description,
        String reference_number,
        LocalDateTime issue_date,
        String issuing_body
) {

    public UserDocumentation toEntity(User user) {
        UserDocumentation doc = new UserDocumentation();

        doc.setType(type);
        doc.setDescription(description);
        doc.setReferenceNumber(reference_number);
        doc.setIssueDate(issue_date);
        doc.setIssuingBody(issuing_body);
        doc.setUser(user);
        doc.setBucketPath("");
        return doc;
    }

}
