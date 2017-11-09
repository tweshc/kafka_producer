package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.producer.KafkaProducer;

@RestController
public class ProducerController {
	
	@Autowired
	KafkaProducer producer;

	@RequestMapping("/producer/{topicName}/{data}")
	public String sendDataThroughURI(@PathVariable String topicName, @PathVariable String data) throws Exception {
		
		producer.sendMessageFromURI(topicName, data);
		
		return "data entered:" + data;
	}
	
}
