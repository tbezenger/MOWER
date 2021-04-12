package com.mowitnow.model;

public class Lawn {
    private int dimensionX;
    private int dimensionY;

    public Lawn(int dimensionX, int dimensionY) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }

    @Override
    public String toString() {
        return "Lawn{" +
                "dimensionX=" + dimensionX +
                ", dimensionY=" + dimensionY +
                '}';
    }
}
