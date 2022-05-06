package com.training.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfiguration {

	@Value("${test-queue}")
	private String myQueue;
	
	@Bean
	public ActiveMQQueue getActiveMQ()
	{
		return new ActiveMQQueue(myQueue);
	}
}
