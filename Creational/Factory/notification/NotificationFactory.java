package Creational.Factory.notification;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NotificationFactory {
    private static final Map<NotificationType, Supplier<Notification>> registry = new HashMap<>();

    private NotificationFactory() {}

    public static void register(NotificationType type, Supplier<Notification> supplier){
        registry.put(type, supplier);
    }

    public static Notification create(NotificationType type){
        Supplier<Notification> supplier = registry.get(type);

        if (supplier == null){
            throw new IllegalArgumentException("No notification registered for " + type);
        }

        return supplier.get();
    }
}
