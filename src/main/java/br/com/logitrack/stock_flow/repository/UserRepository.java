package br.com.logitrack.stock_flow.repository;

import br.com.logitrack.stock_flow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
