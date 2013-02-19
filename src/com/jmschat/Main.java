package com.jmschat;

import com.jmschat.consumer.Consumer;
import com.jmschat.consumer.QueConsumer;
import com.jmschat.consumer.TopicConsumer;
import com.jmschat.producer.Producer;
import com.jmschat.producer.QueProducer;
import com.jmschat.producer.TopicProducer;

public class Main {

    private Consumer queConsumer = new QueConsumer();
    private Consumer queConsumerB = new QueConsumer();
    private Consumer topicConsumer = new TopicConsumer();
    private Consumer topicConsumerB = new TopicConsumer();

    private Producer queProducer = new QueProducer();
    private Producer topicProducer = new TopicProducer();


    public static void main(String[] args) {
        com.jmschat.Main chat = new com.jmschat.Main();

        try {
            chat.queProducer().sendMessage("hi, message q1");
            chat.topicProducer().sendMessage("hi, message t1");

            chat.queProducer().sendMessage("hi, message q2");
            chat.topicProducer().sendMessage("hi, message t2");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Producer queProducer(){
           return queProducer;
    }

    public Producer topicProducer(){
           return topicProducer;
    }
}
