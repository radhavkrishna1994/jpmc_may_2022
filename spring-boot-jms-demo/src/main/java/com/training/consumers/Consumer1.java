package com.training.consumers;

import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.training.model.Order;

@Component
public class Consumer1 {

	/*@JmsListener(destination = "test-queue-1")
	public void receiveMessage(String message)
	{
		System.out.println("Message Received:"+message);
	}*/
	
	/*@JmsListener(destination = "test-queue-1")
	public void receiveOrder(Order order)
	{
		System.out.println("Order Received:"+order);
	}*/
	
	@JmsListener(destination = "test-queue-1")
	public void receiveOrder(List<Order> orders)
	{
		System.out.println("Orders Received:"+orders);
	}
	
}
