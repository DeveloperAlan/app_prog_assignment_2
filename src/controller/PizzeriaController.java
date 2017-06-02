package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import model.Pizzeria;

public class PizzeriaController extends Controller<Pizzeria> {

    @FXML public void initialize() {
    }

    public final Pizzeria getPizzeria() {
        return model;
    }
}
