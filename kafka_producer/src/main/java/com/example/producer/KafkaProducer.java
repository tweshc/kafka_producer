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
	private FileReader fileReader;
	
	private Producer<String, String> producer;
	
	private Properties setDefaultProperties() {
		 Properties props = new Properties();
		 props.put("bootstrap.servers", "localhost:9092,localhost:9093");
		 props.put("acks", "all");
		 props.put("retries", 0);
		 props.put("batch.size", 16384);
		 props.put("linger.ms", 1);
		 props.put("buffer.memory", 33554432);
		 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 return props;
	}
	
	/*
	 * filePath is present here, for testing purposes
	 */
	public void sendMessageFromFile() throws Exception{

		 producer = new org.apache.kafka.clients.producer.KafkaProducer<>(setDefaultProperties());
		 
		 String filePath = "C:\\Users\\tchowdhury\\Documents\\workspace_microservices\\Kafka-Microservices-Application\\src\\main\\resources\\employees.xml";
		 
		 String data = fileReader.readFileAsString(filePath);
	     
		 producer.send(new ProducerRecord<String, String>("inputData", data));
	     
		 producer.close();
	}
	
	/*
	 * user enters filePath to xml file via URI. Controller then uses this method
	 */
	public void sendMessageFromURI(String topicName, String data) throws Exception{
		
		producer = new org.apache.kafka.clients.producer.KafkaProducer<>(setDefaultProperties());
		
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, data);
		
		producer.send(record);
	     
		producer.close();
	}
	
	
}
