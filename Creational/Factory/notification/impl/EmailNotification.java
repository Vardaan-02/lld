package Creational.Factory.notification.impl;

import Creational.Factory.notification.Notification;

public class EmailNotification implements Notification{

    @Override
    public void send(String message){
        System.out.println("Email Notification");
    }
}
