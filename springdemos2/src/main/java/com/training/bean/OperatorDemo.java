package com.training.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.training.interfaces.MyInterface;
import com.training.interfaces.Operator;

public class OperatorDemo {


	private Operator operator;



	public OperatorDemo()
	{
		System.out.println("Constructor..");
	}


	public void setOperator(Operator operator) {

		System.out.println("calling setter.."); 
		this.operator = operator; }


	public void printResult(int x,int y)
	{
		operator.operate(x, y);
	}

}
