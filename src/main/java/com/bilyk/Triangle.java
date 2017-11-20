package com.bilyk;

import static java.lang.String.format;

public class Triangle {

    private Point pointA;
    private Point pointB;
    private Point pointC;

    public void draw() {
        System.out.println(format("Drawing triangle with points: %s, %s, %s.", pointA, pointB, pointC));
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
}
