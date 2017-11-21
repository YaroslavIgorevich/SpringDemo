package com.bilyk;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DeprecatedBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        for (String definitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(definitionName);
            try {
                Class beanClass = Class.forName(beanDefinition.getBeanClassName());
                BeanDeprecated annotation = (BeanDeprecated) beanClass.getAnnotation(BeanDeprecated.class);
                if (annotation != null) {
                    Class newClass = annotation.newClass();
                    System.out.println(String.format("Class [%s] of the bean is deprecated. Replacing with new class - [%s]",
                            beanClass, newClass));
                    beanDefinition.setBeanClassName(newClass.getName());
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
