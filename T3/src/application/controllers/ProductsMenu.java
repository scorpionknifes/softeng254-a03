package application.controllers;

import application.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class ProductsMenu {

    private final SceneManager _sceneManager = SceneManager.getInstance();

    @FXML
    private TableView<?> _tableView;

    @FXML
    void handleAdd(ActionEvent event) {

    }

    @FXML
    void handleBack(ActionEvent event) {
        _sceneManager.backScene();
    }

}
