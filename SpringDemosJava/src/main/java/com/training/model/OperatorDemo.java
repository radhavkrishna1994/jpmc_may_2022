package com.training.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.training.interfaces.Operator;

public class OperatorDemo {

	@Qualifier("product")
	@Autowired   //Setter injection
	private Operator operator;
		
	//Constructor Injection
	/*
	 * public OperatorDemo(Operator operator) { this.operator=operator; }
	 */
	
	public void init()
	{
		System.out.println("Init method..");
	}
	
	public OperatorDemo() {}
	
	public void printResult(int x,int y)
	{
		operator.operate(x, y);
	}
	
}
