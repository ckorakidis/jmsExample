package com.jmschat.consumer;

import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.Destination;
import javax.jms.JMSException;

public class TopicConsumer extends Consumer {

    @Override
    Destination getDestination(String subject) throws JMSException {
        return new ActiveMQTopic(subject);
    }

}
