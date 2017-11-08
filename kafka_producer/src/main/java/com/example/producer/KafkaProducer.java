package com.example.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.utility.FileReader;

@Service
public class KafkaProducer {

	@Autowired
	FileReader fileReader;
	
	public void sendMessage() throws Exception{
		 Properties props = new Properties();
		 props.put("bootstrap.servers", "localhost:9092,localhost:9093");
		 props.put("acks", "all");
		 props.put("retries", 0);
		 props.put("batch.size", 16384);
		 props.put("linger.ms", 1);
		 props.put("buffer.memory", 33554432);
		 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(props);
		 String data = fileReader.readFileAsString("C:\\Users\\tchowdhury\\Documents\\workspace_microservices\\Kafka-Microservices-Application\\src\\main\\resources\\employees.xml");
	     producer.send(new ProducerRecord<String, String>("inputData", data));
	     producer.close();
	}
}
