package com.techmeskills.figuresfx.figures;

import com.techmeskills.figuresfx.exception.IncorrectHeightException;
import com.techmeskills.figuresfx.exception.IncorrectRadiusException;
import com.techmeskills.figuresfx.exception.IncorrectWidthException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import javax.naming.ldap.PagedResultsControl;
import java.util.Objects;
import java.util.Random;

public class Rectangle extends Figure {
    private static final Logger logger = Logger.getLogger(Rectangle.class);

    private double width;
    private double height;
    private Random random;
    Color color2;


    private Rectangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_RECTANGLE, cx, cy, lineWidth, color);
    }

    public Rectangle(double cx, double cy, double lineWidth, Color color, double width, double height, Color color2) throws IncorrectHeightException, IncorrectWidthException {
        this(cx, cy, lineWidth, color);
        this.width = width;
        this.height = height;
        this.color2 = color2;
        if (width < 10) {
            logger.warn("У прямоугольника маленькая ширина!");
        }
        if (height < 10) {
            logger.warn("У прямоугольника маленькая высота!");
        }

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.setFill(color2);
        gc.strokeRect(cx - width / 2, cy - height / 2, width, height);
        gc.fillRect(cx - width / 2, cy - height / 2, width, height);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 &&
                Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }

}
