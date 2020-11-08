package com.techmeskills.figuresfx.drawutils;

import com.techmeskills.figuresfx.figures.Figure;
import com.techmeskills.figuresfx.figures.Oval;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Drawer<T extends Figure & Drawable>{
    ArrayList<Figure> figuresList = new ArrayList<>();

    public Drawer(ArrayList<Figure> figuresList) {
        this.figuresList = figuresList;
    }

    public void draw(GraphicsContext gc) {
        for(Figure f :figuresList){
            f.draw(gc);
        }
    }
}
