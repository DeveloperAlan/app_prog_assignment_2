package model;

import java.text.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ingredient {
    private String name;
    private DoubleProperty price = new SimpleDoubleProperty();
    private Category category;
    private IntegerProperty sold = new SimpleIntegerProperty();
    private DoubleProperty income = new SimpleDoubleProperty();

    public Ingredient(String name, double price, Category category) {
        this.name = name;
        this.price.set(price);
        this.category = category;
        sold.set(0);
    }

    public void sell() {
        sold.set(sold.get() + 1);
        setIncome();
    }

    public boolean in(Category category) {
        return this.category == category;
    }

    public String getName() {
        return name;
    }

    public final double getPrice() {
        return price.get();
    }
    
    public ReadOnlyDoubleProperty priceProperty() {
        return price;
    }

    public final int getSold() {
        return sold.get();
    }
    
    public ReadOnlyIntegerProperty soldProperty() {
        return sold;
    }

    public final double getIncome() {
        return income.get();
    }
    
    private void setIncome() {
        income.set(getPrice() * getSold());
    }

    public ReadOnlyDoubleProperty incomeProperty() {
        return income;
    }
    
    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " " + category;
    }

    private String formatted(double n) {
        return new DecimalFormat("###,##0.00").format(n);
    }
}
