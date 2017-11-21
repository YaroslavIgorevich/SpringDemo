package com.bilyk;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

import static java.lang.String.format;

public class Triangle implements InitializingBean, DisposableBean {

    @InjectRandomPoint
    private Point pointA;

    @InjectRandomPoint
    private Point pointB;

    @InjectRandomPoint
    private Point pointC;

    private List<Point> points;

    public void draw() {
        System.out.println(format("Drawing triangle with points: %s, %s, %s.", pointA, pointB, pointC));
    }

    public void drawList() {
        System.out.println(points);
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "This is simple triangle object";
    }

    public void init() {
        System.out.println("Global init method called for Triangle bean");
    }

    public void clean() {
        System.out.println("Global destroy method called for Triangle bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean init method called for Triangle bean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy method called for Triangle bean");
    }
}
