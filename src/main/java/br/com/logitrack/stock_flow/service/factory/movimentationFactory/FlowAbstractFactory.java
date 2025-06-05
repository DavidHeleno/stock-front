package br.com.logitrack.stock_flow.service.factory.movimentationFactory;

import br.com.logitrack.stock_flow.config.plugins.Plugin;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.interfaces.FlowRequest;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.interfaces.FlowResponse;

public interface FlowAbstractFactory<REQUEST extends FlowRequest, RESPONSE extends FlowResponse> {

   RESPONSE process(REQUEST request);

}
