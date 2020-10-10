package application.controllers;

import application.SceneManager;
import application.SceneManager.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PackageDeal {

    private final SceneManager _sceneManager = SceneManager.getInstance();

    @FXML
    void handleBack(ActionEvent event) {
        _sceneManager.backScene();
    }

    @FXML
    void handleEdit(ActionEvent event) {
        _sceneManager.switchScene(Scenes.PRODUCT_SCREEN);
    }
}
