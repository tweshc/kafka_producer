package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.producer.KafkaProducer;

@SpringBootApplication
@EnableEurekaClient
public class ProducerMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProducerMain.class, args);
		
		//ConfigurableApplicationContext ctx = SpringApplication.run(ProducerMain.class, args);

		//KafkaProducer producer = (KafkaProducer) ctx.getBean(KafkaProducer.class);
		
		//producer.sendMessageFromFile();
		
	}

}
