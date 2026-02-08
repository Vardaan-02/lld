package Creational.Factory.bootstrap;

import Creational.Factory.notification.NotificationFactory;
import Creational.Factory.notification.NotificationType;
import Creational.Factory.notification.impl.EmailNotification;
import Creational.Factory.notification.impl.PushNotification;
import Creational.Factory.notification.impl.SMSNotification;

public class AppInitializer {
    public static void init(){
        NotificationFactory.register(NotificationType.EMAIL, EmailNotification::new);
        NotificationFactory.register(NotificationType.PUSH, PushNotification::new);
        NotificationFactory.register(NotificationType.SMS, SMSNotification::new);
    }
}
