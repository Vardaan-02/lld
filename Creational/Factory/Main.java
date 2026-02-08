package Creational.Factory;

import Creational.Factory.bootstrap.AppInitializer;
import Creational.Factory.notification.Notification;
import Creational.Factory.notification.NotificationFactory;
import Creational.Factory.notification.NotificationType;

public class Main {
    public static void main(String[] args){
        AppInitializer.init();

        Notification notification = NotificationFactory.create(NotificationType.EMAIL);
        notification.send("Hello World");
    }
}
