package br.com.logitrack.stock_flow.service.factory.userFacory;

import br.com.logitrack.stock_flow.entity.User;
import br.com.logitrack.stock_flow.entity.UserDocumentation;

import java.util.List;

public interface UserFactory {

    User create(String name, List<UserDocumentation> documentations);

}
