package com.training.config;

import org.springframework.context.annotation.Bean;

import com.training.interfaces.Operator;
import com.training.model.AddOperator;
import com.training.model.OperatorDemo;

// in place of beans.xml
public class MyConfiguration {

	@Bean
	public Operator getOperator()
	{
		return new AddOperator();
	}
	
	@Bean
	public OperatorDemo getOperatorDemo()
	{
		return new OperatorDemo();
	}
	
	
}
