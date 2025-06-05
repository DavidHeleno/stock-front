package br.com.logitrack.stock_flow.service.strategy;

import br.com.logitrack.stock_flow.entity.User;
import br.com.logitrack.stock_flow.form.UserForm;

public interface UserStrategy {

    User registerUser(UserForm form);
    User consultUser(Long id);

}
