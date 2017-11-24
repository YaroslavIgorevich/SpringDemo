package com.bilyk;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.registerShutdownHook();
        Shape circle = (Shape) context.getBean("circle");
        circle.draw();
    }
}
