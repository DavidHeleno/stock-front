package br.com.logitrack.stock_flow.service.factory.movimentationFactory.model;

import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.interfaces.FlowResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class ApproachFlowResponse implements FlowResponse {

    private Object response;

}
