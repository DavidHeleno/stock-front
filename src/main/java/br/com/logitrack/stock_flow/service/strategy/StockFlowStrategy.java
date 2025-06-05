package br.com.logitrack.stock_flow.service.strategy;

import br.com.logitrack.stock_flow.entity.StockFlow;
import br.com.logitrack.stock_flow.form.StockFlowForm;

public interface StockFlowStrategy {

    StockFlow register(StockFlowForm form);


}
