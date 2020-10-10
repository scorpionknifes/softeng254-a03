package application.controllers;

import application.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Employee {

    private final SceneManager _sceneManager = SceneManager.getInstance();

    @FXML
    void handleBack(ActionEvent event) {
        _sceneManager.backScene();
    }

    @FXML
    void handleSubmit(ActionEvent event) {
        _sceneManager.backScene();
    }

}
