package com.mowitnow.model;

import java.awt.*;

public class Lawn {
    private Point dimensions;

    public Lawn(Point dimensions) {
        this.dimensions = dimensions;
    }

    public Point getDimensions() {
        return dimensions;
    }

    public void setDimensions(Point dimensions) {
        this.dimensions = dimensions;
    }
}
