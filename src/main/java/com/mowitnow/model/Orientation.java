package com.mowitnow.model;

import com.mowitnow.exception.UndefinedOrientationException;

public enum Orientation {
    NORTH("N", 0, 1), EAST("E", 1, 0),
    SOUTH("S", 0, -1), WEST("W", -1, 0);

    private String label;
    private int x;
    private int y;

    Orientation(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Orientation getOrientationByLabel(String label) {
        switch (label) {
            case "N":
                return NORTH;
            case "E":
                return EAST;
            case "S":
                return SOUTH;
            case "W":
                return WEST;
            default:
                throw new UndefinedOrientationException(label + " is not a valid orientation.");
        }
    }

}
