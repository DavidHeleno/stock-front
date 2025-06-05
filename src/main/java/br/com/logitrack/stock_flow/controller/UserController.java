package br.com.logitrack.stock_flow.controller;

import br.com.logitrack.stock_flow.entity.User;
import br.com.logitrack.stock_flow.form.UserForm;
import br.com.logitrack.stock_flow.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public Long registerUser(@RequestBody UserForm form) {
        return service.registerUser(form);
    }

    @GetMapping("/all")
    public List<User> listAll() {
        return service.getAllUsers();
    }
}
