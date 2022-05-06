package com.training.services;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsService {
	
	@Autowired
	private ActiveMQQueue queue;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	
	public String publishMessage(String message)
	{
		jmsTemplate.convertAndSend(queue, message);
		return "Message Published";
	}

}
