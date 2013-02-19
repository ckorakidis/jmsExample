package com.jmschat.consumer;

import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.Destination;
import javax.jms.JMSException;

public class QueConsumer extends Consumer {

    @Override
    Destination getDestination(String subject) throws JMSException {
        return new ActiveMQQueue(subject);
    }

}
