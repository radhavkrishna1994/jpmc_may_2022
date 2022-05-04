package com.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.training.interfaces.Operator;
import com.training.model.AddOperator;
import com.training.model.MultiplyOperator;
import com.training.model.OperatorDemo;

// in place of beans.xml
//@Configuration
public class MyConfiguration {

	
	@Bean(name="sum")
	public Operator getOperator()
	{
		return new AddOperator();
	}
	
	//@Scope(scopeName = "prototype")
	@Bean(initMethod = "init")
	public OperatorDemo getOperatorDemo()
	{
		return new OperatorDemo();
	}
	
	@Bean(name="product")
	public Operator getOperator1()
	{
		return new MultiplyOperator();
	}
	
}
