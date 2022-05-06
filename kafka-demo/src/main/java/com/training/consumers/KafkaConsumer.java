package com.training.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.training.model.Order;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "Kafka_Topic2")
	public void receiveOrder(Order order)
	{
		System.out.println(order);
	}
}
