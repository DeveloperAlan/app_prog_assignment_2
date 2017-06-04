package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Customer;
import model.Pizzeria;

public class CustomerAddController extends Controller<Pizzeria>{
    @FXML private TextField phoneTf;
    @FXML private TextField nameTf;
    @FXML private Button addBtn;
    @FXML private Button cancelBtn;
    @FXML private Text statusText;
    
    @FXML public void initialize() {
        addBtn.setDisable(true);
    }
    
    private void checkIfFormIsDone() {
        if (phoneTf.getText().length() > 0 && nameTf.getText().length() > 0) {
            addBtn.setDisable(false);
        } else {
            addBtn.setDisable(true);
        }
    }
    
    @FXML protected void handleAddButtonAction() {
        try {
            model.addCustomer(phoneTf.getText(), nameTf.getText());
            stage.close();
        } catch (NullPointerException e) {
            statusText.setText("Customer already exists");
        }
    }
    
    @FXML protected void handleCancelButtonAction() {
        stage.close();
    }
    
    @FXML protected void handleTextAction() {
        checkIfFormIsDone();
    }
    
    public final Pizzeria getPizzeria() {
        return model;
    }
}
