package br.com.logitrack.stock_flow.enuns;

public enum ContainerTypes {
    DRY("Standard Dry Container"),
    HIGH_CUBE("High Cube Container"),
    REFRIGERATED("Reefer (Refrigerated) Container");

    private final String description;

    ContainerTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}