package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Customer;
import model.Pizzeria;
import model.Pizza;

public class ServeController extends Controller<Customer>{
    @FXML private Button submitBtn;
    @FXML private Button pizzaSelectBtn;
    @FXML private String phone;
    @FXML private ListView<Pizza> orderLv;
    @FXML private ComboBox<Pizza> orderedLv;
    
    @FXML public void initialize() {
        observeSubmit();
        observePizzaComboBox();
    }
    
    public final Customer getCustomer() {
        return model;
    }
    
    private void observeSubmit() {
        submitBtn.setDisable(true);
        model.getOrder().addListener(new ListChangeListener<Pizza>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Pizza> change) {
                submitBtn.setDisable(false);
            }
        });
    }
    
    private void observePizzaComboBox() {
        pizzaSelectBtn.setDisable(true);
        orderedLv.getSelectionModel().selectedItemProperty().addListener(
             (event) -> pizzaSelectBtn.setDisable(false)
        );
    }
    
    @FXML protected void handlePizzaSelectionAction(ActionEvent event) throws Exception {
        Pizza chosenPizza = orderedLv.getSelectionModel().getSelectedItem();
        chosenPizza.order();
    }
    
    
    @FXML protected void handleCancelPizzaAction(ActionEvent event) throws Exception {
        model.cancelOrder();
        stage.close();
    }
}
