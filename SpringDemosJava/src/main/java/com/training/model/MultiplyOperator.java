package com.training.model;

import com.training.interfaces.Operator;

public class MultiplyOperator implements Operator {

	@Override
	public void operate(int x, int y) {
		System.out.println("product:"+(x*y));

	}

}
