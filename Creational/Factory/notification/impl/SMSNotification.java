package Creational.Factory.notification.impl;

import Creational.Factory.notification.Notification;

public class SMSNotification implements Notification{

    @Override
    public void send(String message){
        System.out.println("Email Notification");
    }
}
