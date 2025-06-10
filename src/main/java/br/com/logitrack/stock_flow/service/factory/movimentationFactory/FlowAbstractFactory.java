package br.com.logitrack.stock_flow.service.factory.movimentationFactory;

import br.com.logitrack.stock_flow.config.plugins.Plugin;
import br.com.logitrack.stock_flow.form.StockFlowForm;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.interfaces.FlowRequest;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.interfaces.FlowResponse;

public interface FlowAbstractFactory<RESPONSE extends FlowResponse> {

   RESPONSE process(StockFlowForm request);

}
