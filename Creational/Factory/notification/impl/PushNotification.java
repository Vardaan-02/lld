package Creational.Factory.notification.impl;

import Creational.Factory.notification.Notification;

public class PushNotification implements Notification{

    @Override
    public void send(String message){
        System.out.println("Push Notification");
    }
}
