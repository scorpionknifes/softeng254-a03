package application.models;

import application.SceneManager;
import application.SceneManager.Scenes;
import application.alerts.Confirm;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class Sale {
    private SimpleStringProperty product;
    private SimpleStringProperty customer;
    private SimpleStringProperty price;
    private SimpleStringProperty date;
    private SimpleStringProperty employee;

    private final SceneManager _sceneManager = SceneManager.getInstance();

    public Sale(String s1, String s2, String s3, String s4, String s5) {
        product = new SimpleStringProperty(s1);
        customer = new SimpleStringProperty(s2);
        price = new SimpleStringProperty(s3);
        date = new SimpleStringProperty(s4);
        employee = new SimpleStringProperty(s5);
    }

    /**
     * @return SimpleStringProperty return the product
     */
    public String getProduct() {
        return product.get();
    }

    /**
     * @param product the product to set
     */
    public void setProduct(SimpleStringProperty product) {
        this.product = product;
    }

    /**
     * @return SimpleStringProperty return the customer
     */
    public String getCustomer() {
        return customer.get();
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(SimpleStringProperty customer) {
        this.customer = customer;
    }

    /**
     * @return SimpleStringProperty return the price
     */
    public String getPrice() {
        return price.get();
    }

    /**
     * @param price the price to set
     */
    public void setPrice(SimpleStringProperty price) {
        this.price = price;
    }

    /**
     * @return SimpleStringProperty return the date
     */
    public String getDate() {
        return date.get();
    }

    /**
     * @param date the date to set
     */
    public void setDate(SimpleStringProperty date) {
        this.date = date;
    }

    /**
     * @return SimpleStringProperty return the employee
     */
    public String getEmployee() {
        return employee.get();
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(SimpleStringProperty employee) {
        this.employee = employee;
    }
    
    public Button getEdit() {
        Button editBtn = new Button("Edit");
        editBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                _sceneManager.switchScene(Scenes.SALE_SCREEN);
            }
        });
        return editBtn;
    }

    public Button getDelete() {
        Button deleteBtn = new Button("Del");
        deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                new Confirm("Delete this Product"){
                    @Override
                    public void handleConfirm() {
                        
                    }
                };
            }
        });
        return deleteBtn;
    }

}
