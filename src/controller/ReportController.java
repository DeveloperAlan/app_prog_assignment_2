package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Customer;
import model.Pizzeria;

public class ReportController extends Controller<Pizzeria>{
    @FXML public void initialize() {
        
    }
    
    @FXML protected void handleCloseWindowAction(ActionEvent event) throws Exception {
        stage.close();
    }
}
