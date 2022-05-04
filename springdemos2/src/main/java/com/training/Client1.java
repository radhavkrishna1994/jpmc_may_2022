package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.bean.HelloWorld;

public class Client1 {

	public static void main(String[] args) {
	
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		HelloWorld helloBean = (HelloWorld)ctx.getBean("hello");
		
		System.out.println(helloBean.sayHello());
		
	}

}
