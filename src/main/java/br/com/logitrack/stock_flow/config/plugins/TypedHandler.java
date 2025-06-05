package br.com.logitrack.stock_flow.config.plugins;

import br.com.logitrack.stock_flow.enuns.EventFlowType;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TypedHandler {
    EventFlowType value();
    String description() default "";
}