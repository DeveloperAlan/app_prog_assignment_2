package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Customer;
import model.Pizzeria;
import model.Pizza;

public class ServeController extends Controller<Customer>{
    @FXML private String nameTxt;
    @FXML private String phone;
    @FXML private ListView<Pizza> orderLv;
    
    @FXML public void initialize() {
        
    }
    
    public final Customer getCustomer() {
        return model;
    }
}
