package com.training.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.interfaces.Operator;

public class OperatorDemo {

	@Autowired   //Setter injection
	private Operator operator;
		
	//Constructor Injection
	/*
	 * public OperatorDemo(Operator operator) { this.operator=operator; }
	 */
	
	public OperatorDemo() {}
	
	public void printResult(int x,int y)
	{
		operator.operate(x, y);
	}
	
}
