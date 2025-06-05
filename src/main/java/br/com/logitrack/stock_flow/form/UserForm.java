package br.com.logitrack.stock_flow.form;

import br.com.logitrack.stock_flow.entity.User;
import br.com.logitrack.stock_flow.enuns.DocumentType;

import java.time.LocalDateTime;
import java.util.List;

public record UserForm(
        String name,
        DocumentType type,
        List<UserDocumentationForm> documentation
) {

    public User toEntity() {

        User user = new User();
        user.setTypeUser(type);
        user.setName(name);

        return user;

    }

}
