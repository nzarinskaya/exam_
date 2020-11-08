package com.techmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Triangle extends Figure {
    private double[] doubleX;
    private double[] doubleY;
    private int n;

    public Triangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }

    public Triangle(double cx, double cy, double lineWidth, Color color, double[] doubleX, double[] doubleY, int n) {
        this(cx, cy, lineWidth, color);
        this.doubleX = doubleX;
        this.doubleY = doubleY;
        this.n = n;
    }

    public double[] getDoubleX() {
        return doubleX;
    }

    public void setDoubleX(double[] doubleX) {
        this.doubleX = doubleX;
    }

    public double[] getDoubleY() {
        return doubleY;
    }

    public void setDoubleY(double[] doubleY) {
        this.doubleY = doubleY;
    }

    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(doubleX, doubleY, doubleX.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return n == triangle.n &&
                Arrays.equals(doubleX, triangle.doubleX) &&
                Arrays.equals(doubleY, triangle.doubleY);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(n);
        result = 31 * result + Arrays.hashCode(doubleX);
        result = 31 * result + Arrays.hashCode(doubleY);
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "doubleX=" + Arrays.toString(doubleX) +
                ", doubleY=" + Arrays.toString(doubleY) +
                ", n=" + n +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }
}
