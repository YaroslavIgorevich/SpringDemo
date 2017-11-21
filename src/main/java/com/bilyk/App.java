package com.bilyk;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.registerShutdownHook();
        Triangle triangle1 = (Triangle) context.getBean("triangle1");
        triangle1.draw();
    }
}
