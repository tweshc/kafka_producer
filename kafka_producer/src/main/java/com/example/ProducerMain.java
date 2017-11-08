package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.producer.KafkaProducer;

@SpringBootApplication
public class ProducerMain {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(ProducerMain.class, args);
		
		KafkaProducer producer = (KafkaProducer) ctx.getBean(KafkaProducer.class);
		
		producer.sendMessage();
		//
	}

}
