package br.com.logitrack.stock_flow.enuns;


import br.com.logitrack.stock_flow.service.factory.userFacory.UserFactory;
import br.com.logitrack.stock_flow.service.factory.userFacory.UserPFFactory;
import br.com.logitrack.stock_flow.service.factory.userFacory.UserPJFactory;

public enum DocumentType {
    PF(new UserPFFactory()),
    PJ(new UserPJFactory());

    private UserFactory userFactory;

    DocumentType(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    public void setUserFactory(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    public UserFactory getUserFactory() {
        return userFactory;
    }
}
