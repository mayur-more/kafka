package org.example.kafka.test1;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerDemo {

    public static void main(String[] args) {
        String bootstrapServer = "localhost:9096";
//        System.out.println("Hello Kafka World!");
        //Create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        //create a producer data
        ProducerRecord<String, String> record = new ProducerRecord<>("first_local_topic", "Hello kafka world...");

        //send data - async
        producer.send(record);

        //flush data
        producer.flush();

        //flush and close producer
        producer.close();
    }
}
