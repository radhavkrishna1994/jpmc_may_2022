package com.training;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.config.MyConfiguration;
import com.training.model.OperatorDemo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(MyConfiguration.class);
       
       OperatorDemo demo = ctx.getBean(OperatorDemo.class);
       
       demo.printResult(12, 23);
       
       
    }
}
