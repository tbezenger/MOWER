package com.mowitnow.model;

public class Mower {

    private int x;
    private int y;
    private Orientation orientation;
    private Lawn lawn;

    public Mower(int x, int y, Orientation orientation, Lawn lawn) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.lawn = lawn;
    }

    public Lawn getLawn() {
        return lawn;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public String getPosition() {
        return x + " " + y + " " + orientation.getLabel();
    }
}
