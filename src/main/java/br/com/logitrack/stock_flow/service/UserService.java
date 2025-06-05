package br.com.logitrack.stock_flow.service;

import br.com.logitrack.stock_flow.entity.User;
import br.com.logitrack.stock_flow.form.UserForm;
import br.com.logitrack.stock_flow.repository.UserDocumentationRepository;
import br.com.logitrack.stock_flow.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDocumentationRepository userDocumentationRepository;

    public UserService(UserRepository userRepository, UserDocumentationRepository userDocumentationRepository) {
        this.userRepository = userRepository;
        this.userDocumentationRepository = userDocumentationRepository;
    }

    @Transactional
    public Long registerUser(UserForm form) {
        User user = userRepository.save(form.toEntity());
        form.documentation().forEach(doc -> {
            userDocumentationRepository.save(doc.toEntity(user));
        });
        return user.getId();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User updateUser(Long id, UserForm form) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        User updatedUser = form.toEntity();
        updatedUser.setId(id);

        form.documentation().forEach(doc -> {
            userDocumentationRepository.save(doc.toEntity(updatedUser));
        });

        return userRepository.save(updatedUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        userRepository.deleteById(id);
    }
}