package com.techmeskills.figuresfx.figures;

import com.techmeskills.figuresfx.exception.IncorrectRadiusException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.util.Objects;

public class Oval extends Figure {
    private static final Logger logger = Logger.getLogger(Oval.class);

    private double radius;

    public Oval(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_CIRCLE, cx, cy, lineWidth, color);
    }

    public Oval(double cx, double cy, double lineWidth, Color color, double radius) throws IncorrectRadiusException {
        this(cx, cy, lineWidth, color);
        this.radius = radius;
        if (radius < 10) {
            logger.warn("Овал имеет маленький радиус!");
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
        gc.fillOval(cx - radius, cy - radius, radius * 2, radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oval oval = (Oval) o;
        return Double.compare(oval.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Oval{" +
                "radius=" + radius +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }
}
