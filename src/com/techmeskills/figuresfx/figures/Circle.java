package com.techmeskills.figuresfx.figures;

import com.techmeskills.figuresfx.exception.IncorrectRadiusException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

import org.apache.log4j.Logger;

public class Circle extends Figure {
    private static final Logger logger = Logger.getLogger(Circle.class);

    private double radius;

    public Circle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_CIRCLE, cx, cy, lineWidth, color);
    }

    public Circle(double cx, double cy, double lineWidth, Color color, double radius) throws IncorrectRadiusException {
        this(cx, cy, lineWidth, color);
        this.radius = radius;
        if (radius < 10) {
            logger.warn("У круга маленький радиус!");
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setFill(color);
        gc.fillOval(cx - radius, cy - radius, radius * 2, radius * 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }
}
