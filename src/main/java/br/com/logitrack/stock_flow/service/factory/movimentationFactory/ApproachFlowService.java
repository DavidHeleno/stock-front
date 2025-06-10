package br.com.logitrack.stock_flow.service.factory.movimentationFactory;

import br.com.logitrack.stock_flow.config.plugins.TypedHandler;
import br.com.logitrack.stock_flow.entity.ContainerProduct;
import br.com.logitrack.stock_flow.entity.Product;
import br.com.logitrack.stock_flow.entity.StockFlow;
import br.com.logitrack.stock_flow.entity.User;
import br.com.logitrack.stock_flow.enuns.EventFlowType;
import br.com.logitrack.stock_flow.form.StockFlowForm;
import br.com.logitrack.stock_flow.repository.ContainerProductRepository;
import br.com.logitrack.stock_flow.repository.ProductRepository;
import br.com.logitrack.stock_flow.repository.StockFlowRepository;
import br.com.logitrack.stock_flow.repository.UserRepository;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.ApproachFlowRequest;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.ApproachFlowResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@TypedHandler( value = EventFlowType.SAIDA, description = "Entrada")
public class ApproachFlowService implements FlowAbstractFactory<ApproachFlowResponse> {

    private final StockFlowRepository stockFlowRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ContainerProductRepository containerProductRepository;

    public ApproachFlowService(StockFlowRepository stockFlowRepository,
                               ProductRepository productRepository,
                               UserRepository userRepository,
                               ContainerProductRepository containerProductRepository
    ) {
        this.stockFlowRepository = stockFlowRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.containerProductRepository = containerProductRepository;
    }

    @Override
    public ApproachFlowResponse process(StockFlowForm payload) {
        Product prod = productRepository.findById(payload.productId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        User user = userRepository.findById(payload.userId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        ContainerProduct cont = containerProductRepository.findById(payload.containerId())
                .orElseThrow(() -> new RuntimeException("Container não encontrado"));

        StockFlow stock = stockFlowRepository.save(payload.toEntity(prod, user, cont));

        return new ApproachFlowResponse(stock);
    }

}
