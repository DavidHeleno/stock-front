package br.com.logitrack.stock_flow.config.plugins;

public interface Plugin<T> {
    Class<T> getInputType();
    void execute(T input);
}
