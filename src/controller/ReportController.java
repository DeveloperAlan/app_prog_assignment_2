package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Customer;
import model.Ingredient;
import model.Kitchen;
import model.Pizzeria;

public class ReportController extends Controller<Kitchen>{
    @FXML private TableView reportTv; 
    @FXML private TableColumn<Ingredient, String> priceClm;
    @FXML private TableColumn<Ingredient, String> incomeClm;
    @FXML private TableColumn<Ingredient, String> soldClm;
    @FXML private Text totalIncomeTxt;
    
    @FXML public void initialize() {
        priceClm.setCellValueFactory(cellData ->
                cellData.getValue().priceProperty().asString("$%.2f")
        );
        
        soldClm.setCellValueFactory(cellData ->
            cellData.getValue().soldProperty().asString()
        );
        incomeClm.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ingredient, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Ingredient, String> cellData) {
                totalIncomeTxt.textProperty().bind(model.incomeProperty().asString("$%.2f"));
                return cellData.getValue().incomeProperty().asString("$%.2f");
            }
        });
       
    }
    
    @FXML protected void handleCloseWindowAction(ActionEvent event) throws Exception {
        stage.close();
    }
    
    public final Kitchen getKitchen() {
        return model;
    }
}
