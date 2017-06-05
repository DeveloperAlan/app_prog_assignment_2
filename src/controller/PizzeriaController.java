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

public class PizzeriaController extends Controller<Pizzeria> {
    @FXML private ListView<Customer> customersLv;
    @FXML private Button selected;
    
    private Customer getSelectedCustomer() {
        return customersLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML public void initialize() {
        selected.setDisable(true);
        customersLv.getSelectionModel().selectedItemProperty().addListener(
             (event) -> selected.setDisable(false)
        );
    }
    
    @FXML protected void handleAddCustomerAction(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/customer_add.fxml", "Add customer", new Stage());
    }
    
    @FXML protected void handleServeCustomerAction(ActionEvent event) throws Exception {
        ViewLoader.showStage(getSelectedCustomer(), "/view/serve.fxml", "Serve customer", new Stage());
    }
    
    @FXML protected void handleViewReportAction(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/report.fxml", "Income report", new Stage());
    }

    public final Pizzeria getPizzeria() {
        return model;
    }
}
