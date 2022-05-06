package com.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisherService {
	
	private static final String KAFKATOPIC1="Kafka_Topic1";
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplateString;
	
	public String publishMessage(String message)
	{
		kafkaTemplateString.send(KAFKATOPIC1, message);
		return message+"published";
	}

}
