package application.controllers;

import application.SceneManager;
import application.SceneManager.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenu {
    
    private final SceneManager _sceneManager = SceneManager.getInstance();

    @FXML
    void handleCustomers(final ActionEvent event) {
        _sceneManager.switchScene(Scenes.CUSTOMERS_MENU);
    }

    @FXML
    void handleEmployees(final ActionEvent event) {
        _sceneManager.switchScene(Scenes.EMPLOYEES_MENU);
    }

    @FXML
    void handleProducts(final ActionEvent event) {
        _sceneManager.switchScene(Scenes.PRODUCTS_MENU);
    }

    @FXML
    void handleSales(final ActionEvent event) {
        _sceneManager.switchScene(Scenes.SALES_MENU);
    }

    @FXML
    void handleQuit(final ActionEvent event) {
        _sceneManager.close();
    }
}
