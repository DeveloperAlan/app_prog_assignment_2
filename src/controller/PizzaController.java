package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Customer;
import model.Ingredient;
import model.Pizzeria;
import model.Pizza;

public class PizzaController extends Controller<Pizza>{
    @FXML private ListView<Ingredient> kitchenLv;
    @FXML private ListView<Ingredient> ingredientsLv;
    @FXML private Button addButton;
    @FXML private Button removeButton;
    @FXML private Text statusText;
    @FXML private Text pizzaTotal;
    @FXML private Button createButton;
   
    @FXML public void initialize() {
        addItemsToKitchenIngredientListView();
        addItemsToPizzaIngredientListView();
        observeAddIngredient();
        observeRemoveIngredient();
        statusText.textProperty().bind(model.statusStringProperty());
        pizzaTotal.textProperty().bind(model.priceProperty().asString("$%.2f"));
        addButton.setDisable(true);
        createButton.setDisable(true);
    }
    
    private void observeAddIngredient() {
        kitchenLv.getSelectionModel().selectedItemProperty().addListener(
              event -> {
                  Ingredient ingredient = getSelectedKitchenIngredient();
                  disableAddButtonIfDone(ingredient);
              }
        );
    }
    
    private void observeRemoveIngredient() {
        removeButton.setDisable(true);
        ingredientsLv.getSelectionModel().selectedItemProperty().addListener(
            (event) -> removeButton.setDisable(false)
        );
    }
    
    public final Pizza getPizza() {
        return model;
    }
    
    private void addItemsToKitchenIngredientListView() {
        kitchenLv.setItems(model.getKitchen().getIngredients());
    }
    
    private void addItemsToPizzaIngredientListView() {
        ingredientsLv.setItems(model.getIngredients());
    }
    
    private boolean disableAddButtonIfDone(Ingredient ingredient) {
        if (model.canAdd(ingredient)) {
            addButton.setDisable(false);
            return false;
        } else {
            addButton.setDisable(true);
            return true;
        }
    }
    
    private void unlockCreateButtonIfPizzaIsDone() {
        createButton.setDisable(!model.checkIfPizzaIsValid());
    }
    
    @FXML protected void handleAddButtonAction() {
        Ingredient ingredient = getSelectedKitchenIngredient();
        model.add(ingredient);
        unlockCreateButtonIfPizzaIsDone();
        disableAddButtonIfDone(ingredient);
    }
    
    @FXML protected void handleRemoveButtonAction() {
        Ingredient ingredient = getSelectedPizzaIngredient();
        model.remove(ingredient);
        disableAddButtonIfDone(getSelectedKitchenIngredient());
        unlockCreateButtonIfPizzaIsDone();
        if (model.ingredientsEmpty()) {
            removeButton.setDisable(true);
        }
    }
    
    @FXML protected void handleCancelPizzaAction() {
        stage.close();
    }
    
    @FXML protected void handleCreatePizzaAction() {
        model.order();
        stage.close();
    }
    
    
    private Ingredient getSelectedKitchenIngredient() {
        return kitchenLv.getSelectionModel().getSelectedItem();
    }
    
    private Ingredient getSelectedPizzaIngredient() {
        return ingredientsLv.getSelectionModel().getSelectedItem();
    }
}
