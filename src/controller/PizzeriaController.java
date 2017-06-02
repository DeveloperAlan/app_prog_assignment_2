package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Customer;
import model.Pizzeria;

public class PizzeriaController extends Controller<Pizzeria> {
    @FXML private ListView<Customer> customersLv;
    
    private Customer getSelectedCustomer() {
        return customersLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML public void initialize() {
        Image img = new Image("file:pizzeria.png");
        ImageView imageView = new ImageView(img);
    }

    public final Pizzeria getPizzeria() {
        return model;
    }
}
