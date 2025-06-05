package br.com.logitrack.stock_flow.repository;

import br.com.logitrack.stock_flow.entity.StockFlow;
import br.com.logitrack.stock_flow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockFlowRepository extends JpaRepository<StockFlow, Long> {

    List<StockFlow> findAllByUser(User user);

}
