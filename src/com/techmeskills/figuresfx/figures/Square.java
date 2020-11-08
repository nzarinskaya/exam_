package com.techmeskills.figuresfx.figures;

import com.techmeskills.figuresfx.exception.IncorrectHeightException;
import com.techmeskills.figuresfx.exception.IncorrectWidthException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import org.apache.log4j.Logger;

import java.util.Objects;

public class Square extends Figure {
    private static final Logger logger = Logger.getLogger(Square.class);

    private double width;
    private double height;
    private double wFill;
    private double hFill;
    private double wClear;
    private double hClear;
    Color color2;


    public Square(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_SQUARE, cx, cy, lineWidth, color);
    }

    public Square(double cx, double cy, double lineWidth, Color color, double width, double height, double wFill, double hFill, double wClear, double hClear, Color color2)
            throws IncorrectWidthException, IncorrectHeightException {
        this(cx, cy, lineWidth, color);
        this.width = width;
        this.height = height;
        this.wFill = wFill;
        this.hFill = hFill;
        this.wClear = wClear;
        this.hClear = hClear;
        this.color2 = color2;
        if (width < 10) {
            logger.warn("Квадрат имеет маленькую ширину!");
        }
        if (height < 10) {
            logger.warn("Квадрат имеет мельнкую высоту!");
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

    public double getwFill() {
        return wFill;
    }

    public void setwFill(double wFill) {
        this.wFill = wFill;
    }

    public double gethFill() {
        return hFill;
    }

    public void sethFill(double hFill) {
        this.hFill = hFill;
    }

    public double getwClear() {
        return wClear;
    }

    public void setwClear(double wClear) {
        this.wClear = wClear;
    }

    public double gethClear() {
        return hClear;
    }

    public void sethClear(double hClear) {
        this.hClear = hClear;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.setFill(color2);
        gc.fillRect(cx - wFill / 2, cy - hFill / 2, wFill, hFill);
        gc.clearRect(cx - wClear / 2, cy - hClear / 2, wClear, hClear);
        gc.strokeRect(cx - width / 2, cy - height / 2, width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.width, width) == 0 &&
                Double.compare(square.height, height) == 0 &&
                Double.compare(square.wFill, wFill) == 0 &&
                Double.compare(square.hFill, hFill) == 0 &&
                Double.compare(square.wClear, wClear) == 0 &&
                Double.compare(square.hClear, hClear) == 0 &&
                Objects.equals(color2, square.color2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, wFill, hFill, wClear, hClear, color2);
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                ", height=" + height +
                ", wFill=" + wFill +
                ", hFill=" + hFill +
                ", wClear=" + wClear +
                ", hClear=" + hClear +
                ", color2=" + color2 +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }
}

