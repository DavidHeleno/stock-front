package br.com.logitrack.stock_flow.service.factory.movimentationFactory;

import br.com.logitrack.stock_flow.config.plugins.TypedHandler;
import br.com.logitrack.stock_flow.enuns.EventFlowType;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.OutGoingFlowResponse;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.OutgoingFlowRequest;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.interfaces.FlowRequest;
import org.springframework.stereotype.Service;

@Service
@TypedHandler(value = EventFlowType.SAIDA, description = "Processador de Saida")
public class OutgoingFlowService implements FlowAbstractFactory<FlowRequest, OutGoingFlowResponse> {

    @Override
    public OutGoingFlowResponse process(FlowRequest payload) {
        System.out.println("executei a saida");
        return new OutGoingFlowResponse();
    }

}
