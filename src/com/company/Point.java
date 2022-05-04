package com.company;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point getPoint() {
        return new Point(x, y);
    }

    public int getPointX() {
        return this.x;
    }

    public int getPointY() {
        return this.y;
    }
}
