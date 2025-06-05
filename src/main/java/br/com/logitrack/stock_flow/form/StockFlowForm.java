package br.com.logitrack.stock_flow.form;

import br.com.logitrack.stock_flow.entity.ContainerProduct;
import br.com.logitrack.stock_flow.entity.Product;
import br.com.logitrack.stock_flow.entity.StockFlow;
import br.com.logitrack.stock_flow.entity.User;
import br.com.logitrack.stock_flow.enuns.EventFlowType;

import java.math.BigDecimal;

public record StockFlowForm(
        Long productId,
        Long userId,
        Long containerId,
        EventFlowType event,
        BigDecimal unitValue,
        Long quantity
) {

    public StockFlow toEntity(Product prod, User user, ContainerProduct containerProduct) {
        StockFlow stock = new StockFlow();

        stock.setProduct(prod);
        stock.setUser(user);
        stock.setTypeEvent(event);
        stock.setQuantity(quantity);
        stock.setUnitValue(unitValue);
        stock.setContainerProduct(containerProduct);

        return stock;
    }

}
