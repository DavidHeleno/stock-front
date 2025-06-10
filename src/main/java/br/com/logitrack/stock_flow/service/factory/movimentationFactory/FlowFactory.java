package br.com.logitrack.stock_flow.service.factory.movimentationFactory;

import br.com.logitrack.stock_flow.config.plugins.TypedHandlerRegistry;
import br.com.logitrack.stock_flow.enuns.EventFlowType;
import br.com.logitrack.stock_flow.form.StockFlowForm;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.ApproachFlowResponse;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.interfaces.FlowRequest;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.interfaces.FlowResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class FlowFactory extends TypedHandlerRegistry<FlowAbstractFactory<ApproachFlowResponse>> {


    public FlowFactory(List<FlowAbstractFactory<ApproachFlowResponse>> processors) {

        processors.forEach(this::register);

        logRegisteredProcessors();
    }

    public ApproachFlowResponse executa(EventFlowType type, StockFlowForm data) {
         return getHandler(type).map(flow -> flow.process(data)).orElseThrow(() -> new IllegalArgumentException(type.toString()));
    }

    public Set<EventFlowType> getAvailableProcessorTypes() {
        return getAvailableEnumTypes(EventFlowType.class);
    }

    private void logRegisteredProcessors() {
        getAvailableTypes().forEach(type ->
                System.out.println("Registered payment processor: " + type));
    }

}
