package br.com.logitrack.stock_flow.service.factory.userFacory;

import br.com.logitrack.stock_flow.entity.User;
import br.com.logitrack.stock_flow.entity.UserDocumentation;
import br.com.logitrack.stock_flow.enuns.DocumentType;

import java.time.LocalDateTime;
import java.util.List;

public class UserPJFactory implements UserFactory{

    @Override
    public User create(String name, List<UserDocumentation> documentations) {
        User user = new User();
        user.setName(name);
        user.setTypeUser(DocumentType.PJ);
        user.setDocumentations(documentations);
        user.setCreateAt(LocalDateTime.now());
        user.setUpdateAt(LocalDateTime.now());

//        // validações e regras específicas de PF
//        if (documentations.stream().noneMatch(d -> d.getDocument().matches("\\d{11}"))) {
//            throw new IllegalArgumentException("CPF inválido ou ausente.");
//        }

        return user;
    }

}
