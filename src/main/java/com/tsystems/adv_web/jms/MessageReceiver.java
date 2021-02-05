package com.tsystems.adv_web.jms;


import com.tsystems.adv_web.rest.ProductsGetter;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.inject.Scope;
import javax.jms.Message;
import javax.jms.MessageListener;
import org.jboss.annotation.ejb.ResourceAdapter;

@MessageDriven(name = "MessageReceiver", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "TopProductsQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
@ResourceAdapter("activemq-rar-4.1.1.rar")
public class MessageReceiver implements MessageListener {

    @EJB
    private ProductsGetter productsGetter;

    @EJB
    private Receiver receiver;

    public MessageReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public MessageReceiver() {
    }

    @Override
    public void onMessage(Message message) {
        productsGetter.getBestProducts();
    }
}
