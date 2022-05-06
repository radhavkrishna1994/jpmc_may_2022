package com.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.training.model.Order;

@Service
public class KafkaPublisherService {
	
	private static final String KAFKATOPIC1="Kafka_Topic1";
	private static final String KAFKATOPIC2="Kafka_Topic2";
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplateString;
	
	@Autowired
	private KafkaTemplate<String,Order> kafkaTemplateOrder;
	
	public String publishMessage(String message)
	{
		kafkaTemplateString.send(KAFKATOPIC1, message);
		return message+"published";
	}
	
	public String publishOrder(Order order)
	{
		kafkaTemplateOrder.send(KAFKATOPIC2, order);
		return order+"published";
	}
	

}
