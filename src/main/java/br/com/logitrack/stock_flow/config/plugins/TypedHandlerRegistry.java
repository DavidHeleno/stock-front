package br.com.logitrack.stock_flow.config.plugins;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
@Slf4j
public class TypedHandlerRegistry<T> {

    private final Map<String, T> handlers = new ConcurrentHashMap<>();
    private final Map<Enum<?>, T> enumHandlers = new ConcurrentHashMap<>();

    protected void register(T handler) {
        Class<?> handlerClass = handler.getClass();
        TypedHandler annotation = handlerClass.getAnnotation(TypedHandler.class);

        if (annotation != null) {
            String type = annotation.value().toString();
            Enum<?> enumType = annotation.value();
            System.out.println(type);
            // Registra em ambos os maps para consistência
            handlers.put(type, handler);
            System.out.println(handlers.size());
//            System.out.println(getHandler("SAIDA").get().getClass().getCanonicalName());
            enumHandlers.put(enumType, handler);
        }
    }

    private Optional<T> getHandler(String type) {
        return Optional.ofNullable(handlers.get(type));
    }

    protected Optional<T> getHandler(Enum<?>  type) {
        return Optional.ofNullable(enumHandlers.get(type));
    }

    public Set<String> getAvailableTypes() {
        return handlers.keySet();
    }

    @SuppressWarnings("unchecked")
    public <E extends Enum<E>> Set<E> getAvailableEnumTypes(Class<E> enumClass) {
        return enumHandlers.keySet()
                .stream()
                .filter(enumClass::isInstance)
                .map(enumClass::cast)
                .collect(Collectors.toSet());
    }

    public boolean hasHandler(String type) {
        return handlers.containsKey(type);
    }

    public boolean hasHandler(Enum<?> type) {
        return enumHandlers.containsKey(type);
    }
}