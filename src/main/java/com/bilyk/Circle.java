package com.bilyk;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service
public class Circle implements Shape {

    private Point center;

    @Override
    public void draw() {
        System.out.println("Drawing circle with the center in " + center);
    }

    public Point getCenter() {
        return center;
    }

    @Resource(name="pointC")
    public void setCenter(@Qualifier(value = "circleRelated") Point center) {
        this.center = center;
    }

    @PostConstruct
    public void initCircle() {
        System.out.println("Init circle");
    }

    @PreDestroy
    public void destroyCircle() {
        System.out.println("Destroy circle");
    }
}
