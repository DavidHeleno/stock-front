package br.com.logitrack.stock_flow.controller;

import br.com.logitrack.stock_flow.entity.StockFlow;
import br.com.logitrack.stock_flow.form.StockFlowForm;
import br.com.logitrack.stock_flow.service.StockFlowService;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.OutGoingFlowResponse;
import br.com.logitrack.stock_flow.service.factory.movimentationFactory.model.interfaces.FlowResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockFlowController {

    private final StockFlowService service;

    public StockFlowController(StockFlowService service) {
        this.service = service;
    }

    @PostMapping
    @RequestMapping("/register")
    public Long registerStock(@RequestBody StockFlowForm form) {
        return service.registerStockFlow(form);
    }

    @GetMapping("/all/{userId}")
    public List<StockFlow> listAllForUser(@PathVariable("userId") Long userId) {
        return service.getAllByUser(userId);
    }

    @PostMapping("teste")
    public ResponseEntity<OutGoingFlowResponse> testeStrategy(@RequestBody StockFlowForm form) {
        return ResponseEntity.ok(service.executeStockFlow(null, form));
    }

}
