package com.jmschat.producer;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

public class TopicProducer extends Producer {

    @Override
    Destination getDestination(Session session, String subject) throws JMSException {
        return session.createTopic(subject);
    }

}
