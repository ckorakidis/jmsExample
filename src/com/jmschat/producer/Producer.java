package com.jmschat.producer;

import javax.jms.*;

import static com.jmschat.helper.JMSConnection.closeConnection;
import static com.jmschat.helper.JMSConnection.getConnection;

/**
 * The Class Producer.
 */
public abstract class Producer {

    /**
     * The Constant SUBJECT.
     */
    private static final String SUBJECT = "topic.jay";

    /**
     * The connection.
     */
    private Connection connection = null;

    /**
     * The session.
     */
    private Session session;

    /**
     * The producer.
     */
    private MessageProducer producer;

    private Destination destination;


    /**
     * Send message.
     *
     * @throws Exception the exception
     */
    public void sendMessage(String message) throws Exception {


        try {

            connection = getConnection();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            destination = getDestination(session, SUBJECT);

            producer = setupProducer(session, destination);

            TextMessage textMessage = this.session.createTextMessage(message);

            System.out.println("Sending message: " + message);
            producer.send(textMessage);

            closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MessageProducer setupProducer(Session session, Destination destination) throws JMSException {

        MessageProducer producer = session.createProducer(destination);
        producer.setPriority(1);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        return producer;
    }

    abstract Destination getDestination(Session session, String subject) throws JMSException;

}
