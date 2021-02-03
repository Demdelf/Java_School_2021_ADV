package com.tsystems.adv_web.jms;

import com.tsystems.adv_web.rest.ProductsGetter;
import java.util.Hashtable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Startup
@Singleton
public class Receiver {

    @EJB
    private MessageReceiver messageReceiver;

    @EJB
    private ProductsGetter productsGetter;

    @PostConstruct
    public void receive() {
        Hashtable<String, String> props = new Hashtable<>();
        props.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.put("java.naming.provider.url", "tcp://localhost:61616");
        props.put("queue.js-queue", "TopProductsQueue");
        props.put("connectionFactoryNames", "queueCF");

        Context context;

        {
            try {
                context = new InitialContext(props);
                QueueConnectionFactory connectionFactory = (QueueConnectionFactory) context.lookup("queueCF");
                Queue queue = (Queue) context.lookup("js-queue");

                QueueConnection connection = connectionFactory.createQueueConnection();
                connection.start();

                QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);

                QueueReceiver receiver = session.createReceiver(queue);
                receiver.setMessageListener(messageReceiver);

            } catch (NamingException | JMSException e) {
                e.printStackTrace();
            }
            productsGetter.getBestProducts();
        }
    }
}
