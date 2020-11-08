package com.techmeskills.figuresfx.controller;
import com.techmeskills.figuresfx.drawutils.Drawer;
import com.techmeskills.figuresfx.exception.IncorrectHeightException;
import com.techmeskills.figuresfx.exception.IncorrectRadiusException;
import com.techmeskills.figuresfx.exception.IncorrectWidthException;
import com.techmeskills.figuresfx.exception.UnknownTypeException;
import com.techmeskills.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class mainScreenViewController implements Initializable {

    private static final Logger logger = Logger.getLogger(mainScreenViewController.class);
    private ArrayList<Figure> figures;
    private Random random;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        figures = new ArrayList<Figure>();
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
        figures.add(figure);
        return;
    }

    private Figure createFigure(double x, double y) throws UnknownTypeException, IncorrectRadiusException, IncorrectWidthException, IncorrectHeightException {

        Figure figure = null;
        int squareWH = random.nextInt(50);
        int fillWH = Math.max(random.nextInt(65), 100);
        int clearWH = Math.max(random.nextInt(55), 60);

        switch (random.nextInt(5)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, Math.max(random.nextInt(1), 4), Color.MEDIUMSPRINGGREEN, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, Math.max(random.nextInt(1), 4), Color.SILVER, random.nextInt(50), random.nextInt(100), Color.SKYBLUE);
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, Math.max(random.nextInt(1), 4), Color.YELLOW, new double[]{random.nextInt(990), random.nextInt(870), random.nextInt(990)}, new double[]{random.nextInt(550), random.nextInt(470), random.nextInt(550)}, 3);
                break;
            case Figure.FIGURE_TYPE_SQUARE:
                figure = new Square(x, y, Math.max(random.nextInt(1), 4), Color.VIOLET, squareWH, squareWH, fillWH, fillWH, clearWH, clearWH, Color.MISTYROSE);
                break;
            case Figure.FIGURE_TYPE_OVAL:
                figure = new Oval(x, y, Math.max(random.nextInt(1), 4), Color.ORANGERED, random.nextInt(70));
                break;
            default:
                logger.warn("Hеизвестный тип фигуры!");
        }
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) throws UnknownTypeException, IncorrectRadiusException, IncorrectWidthException, IncorrectHeightException {
        addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        repaint();
    }
}
