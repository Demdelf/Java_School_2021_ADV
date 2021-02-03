package com.tsystems.adv_web.jms;


import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(name = "MessageReceiver", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "/queue/TopProductsQueue")})
public class MessageReceiver implements MessageListener {

    @Override
    public void onMessage(Message message) {

    }
}
