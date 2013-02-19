package com.jmschat.consumer;

import javax.jms.*;

import static com.jmschat.helper.JMSConnection.getConnection;

public abstract class Consumer implements MessageListener {

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
     * The consumer.
     */
    private MessageConsumer consumer;

    private Destination destination;

    public Consumer(){

        try {

            connection = getConnection();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            destination = getDestination(SUBJECT);

            consumer = setupConsumer(session, destination);

            connection.start();

            consumer.setMessageListener(this);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private MessageConsumer setupConsumer(Session session, Destination destination) throws JMSException {

        return session.createConsumer(destination);
    }

    abstract Destination getDestination(String subject) throws JMSException;

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}