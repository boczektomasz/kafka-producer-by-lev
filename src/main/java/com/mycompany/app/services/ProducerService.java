package com.mycompany.app.services;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerService {
    public static void produce(String message) {
        // When Kafka running locally in Docker use "127.0.0.1:9092"
        String bootstrapServer = "172.21.202.252:9092,172.21.83.196:9092,172.21.194.161:9092";

        // create producer properties
        Properties props = new Properties();
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

        // create producer record
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", message);

        // send data - async
        producer.send(record);

        // close and flush - makes all buffered records immediately available to send
        producer.close();
    }
}
