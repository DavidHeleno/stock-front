package br.com.logitrack.stock_flow.form;

import br.com.logitrack.stock_flow.entity.ContainerProduct;
import br.com.logitrack.stock_flow.enuns.ContainerTypes;

public record ContainerProductForm(
        String name,
        String description,
        String location,
        String type
) {

    public ContainerProduct toEntity() {
        ContainerProduct cont = new ContainerProduct();

        cont.setName(name);
        cont.setDescription(description);
        cont.setLocation(location);
        cont.setType(ContainerTypes.valueOf(type));

        return cont;
    }

}
