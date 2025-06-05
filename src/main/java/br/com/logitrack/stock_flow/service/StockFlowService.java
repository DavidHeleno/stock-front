package br.com.logitrack.stock_flow.service;

import br.com.logitrack.stock_flow.entity.ContainerProduct;
import br.com.logitrack.stock_flow.entity.Product;
import br.com.logitrack.stock_flow.entity.StockFlow;
import br.com.logitrack.stock_flow.entity.User;
import br.com.logitrack.stock_flow.form.StockFlowForm;
import br.com.logitrack.stock_flow.repository.ContainerProductRepository;
import br.com.logitrack.stock_flow.repository.ProductRepository;
import br.com.logitrack.stock_flow.repository.StockFlowRepository;
import br.com.logitrack.stock_flow.repository.UserRepository;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.FlowFactory;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.OutGoingFlowResponse;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.interfaces.FlowRequest;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.interfaces.FlowResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockFlowService {

    private final StockFlowRepository stockFlowRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ContainerProductRepository containerProductRepository;
    private final FlowFactory flowFactory;

    public StockFlowService(StockFlowRepository stockFlowRepository, 
                          ProductRepository productRepository,
                          UserRepository userRepository,
                          ContainerProductRepository containerProductRepository, FlowFactory flowFactory
    ) {
        this.stockFlowRepository = stockFlowRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.containerProductRepository = containerProductRepository;
        this.flowFactory = flowFactory;
    }

    @Transactional
    public Long registerStockFlow(StockFlowForm form) {
        Product prod = productRepository.findById(form.productId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        User user = userRepository.findById(form.userId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        ContainerProduct cont = containerProductRepository.findById(form.containerId())
                .orElseThrow(() -> new RuntimeException("Container não encontrado"));

        StockFlow stock = stockFlowRepository.save(form.toEntity(prod, user, cont));
        return stock.getId();
    }

    public OutGoingFlowResponse executeStockFlow(FlowRequest form, StockFlowForm stockFlow) {
        return (OutGoingFlowResponse) flowFactory.executa(stockFlow.event(), form);
    }

    public List<StockFlow> getAllByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return stockFlowRepository.findAllByUser(user);
    }

    public Optional<StockFlow> findById(Long id) {
        return stockFlowRepository.findById(id);
    }

    @Transactional
    public StockFlow updateStockFlow(Long id, StockFlowForm form) {
        StockFlow existingFlow = stockFlowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StockFlow não encontrado"));

        Product prod = productRepository.findById(form.productId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        User user = userRepository.findById(form.userId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        ContainerProduct cont = containerProductRepository.findById(form.containerId())
                .orElseThrow(() -> new RuntimeException("Container não encontrado"));

        StockFlow updatedFlow = form.toEntity(prod, user, cont);
        updatedFlow.setId(id);
        
        return stockFlowRepository.save(updatedFlow);
    }

    @Transactional
    public void deleteStockFlow(Long id) {
        stockFlowRepository.deleteById(id);
    }

    public List<StockFlow> getAllStockFlows() {
        return stockFlowRepository.findAll();
    }
}