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
       System.out.println(demo.hashCode());
       demo.printResult(12, 23);
       
       OperatorDemo demo1 = ctx.getBean(OperatorDemo.class);
       System.out.println(demo1.hashCode());
       demo1.printResult(45,67);
    }
}
