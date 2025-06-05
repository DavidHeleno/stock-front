package br.com.logitrack.stock_flow.service.factory.movimentationFactory;

import br.com.logitrack.stock_flow.config.plugins.TypedHandler;
import br.com.logitrack.stock_flow.enuns.EventFlowType;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.ApproachFlowRequest;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.ApproachFlowResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@TypedHandler( value = EventFlowType.SAIDA, description = "Entrada")
public class ApproachFlowService implements FlowAbstractFactory<ApproachFlowRequest, ApproachFlowResponse> {


    @Override
    public ApproachFlowResponse process(ApproachFlowRequest payload) {
        System.out.println("executei a saida");
        return null;
    }

}
