package application.controllers;

import application.SceneManager;
import application.StateManager;
import application.SceneManager.Scenes;
import application.StateManager.Select;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SaleScreen {

    private final SceneManager _sceneManager = SceneManager.getInstance();
    private final StateManager _stateManager = StateManager.getInstance();

    @FXML
    private Label _screenText;

    @FXML
    private Button _employeeBtn;

    @FXML
    private Button _productBtn;

    @FXML
    private Button _customerBtn;

    @FXML
    private Label _dateText;

    @FXML
    void handleBack(ActionEvent event) {
        _sceneManager.backScene();
    }

    @FXML
    void handleCustomer(ActionEvent event) {
        _stateManager.setSelect(Select.CUSTOMER);
        _sceneManager.popUp(Scenes.SELECT_SCREEN);
    }

    @FXML
    void handleEmployee(ActionEvent event) {
        _stateManager.setSelect(Select.EMPLOYEE);
        _sceneManager.popUp(Scenes.SELECT_SCREEN);
    }

    @FXML
    void handleProduct(ActionEvent event) {
        _stateManager.setSelect(Select.PRODUCT);
        _sceneManager.popUp(Scenes.SELECT_SCREEN);
    }

    @FXML
    void handleSubmit(ActionEvent event) {
        _sceneManager.backScene();
    }

}
