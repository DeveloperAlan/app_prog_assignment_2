package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Pizzeria;

public class PizzeriaController extends Controller<Pizzeria> {

    @FXML public void initialize() {
        Image img = new Image("file:pizzeria.png");
        ImageView imageView = new ImageView(img);
    }

    public final Pizzeria getPizzeria() {
        return model;
    }
}
