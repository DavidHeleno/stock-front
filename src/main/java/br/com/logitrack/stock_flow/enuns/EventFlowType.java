package br.com.logitrack.stock_flow.enuns;

public enum EventFlowType {
    ENTRADA("entrada"),
    SAIDA("saida"),
    TRANSFERENCIA("transferencia");
    // Adicione mais tipos conforme necessário

    private final String description;

    public String getDescription() {
        return description;
    }

    EventFlowType(String description) {
        this.description = description;
    }
}