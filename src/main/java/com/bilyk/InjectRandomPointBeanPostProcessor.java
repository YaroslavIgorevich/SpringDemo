package com.bilyk;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;

public class InjectRandomPointBeanPostProcessor implements BeanPostProcessor {
    private final Random random = new Random();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            if (type == Point.class) {
                System.out.println("Field type:" + type);
                try {
                    Point point = new Point();
                    field.get(bean);
                    System.out.println("Point object: " + point);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                System.out.println(field.getName());
            }
        }

        for (Field field : fields) {
            InjectRandomPoint annotation = field.getAnnotation(InjectRandomPoint.class);
            if (annotation != null) {
                if (!field.getType().equals(Point.class)) {
                    throw new RuntimeException("InjectRandomPoint annotation is not applicable for [" + field.getType() + "] type field");
                }
                if (Modifier.isFinal(field.getModifiers())) {
                    throw  new RuntimeException("Cannot inject to final fields");
                }
                Point point = new Point();
                point.setX(random.nextInt(10));
                point.setY(random.nextInt(10));
                field.setAccessible(true);
                try {
                    field.set(bean, point);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
