package br.com.logitrack.stock_flow.service.factory.movimentationFactory.model;

import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.interfaces.FlowResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class OutGoingFlowResponse implements FlowResponse {

    private String name;

}
