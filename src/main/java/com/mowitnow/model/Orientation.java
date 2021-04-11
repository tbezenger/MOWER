package com.mowitnow.model;

public enum Orientation {
    NORTH('N'), EAST('E'), SOUTH('S'), WEST('W');

    private char label;

    Orientation(char label) {
        this.label = label;
    }

    public char getLabel() {
        return label;
    }

}
