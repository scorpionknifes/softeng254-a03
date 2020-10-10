package application.controllers;

import java.util.ArrayList;
import java.util.List;

import application.SceneManager;
import application.StateManager;
import application.helper.SelectBtn;
import application.SceneManager.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelectScreen {

    private final StateManager _stateManager = StateManager.getInstance();
    private final SceneManager _sceneManager = SceneManager.getInstance();

    @FXML
    private Label _titleText;

    @FXML
    private VBox _scorePane;

    @FXML
    private Button _manageBtn;

    public void initialize() {
        List<SelectBtn> _selectBtns = new ArrayList<SelectBtn>();
        switch (_stateManager.getSelect()) {
            case CUSTOMER:
                _titleText.setText("Select Customer");
                _manageBtn.setText("Manage Customer");
                _selectBtns.add(new SelectBtn("Shopper 1"));
                _selectBtns.add(new SelectBtn("Shopper 2"));
                _selectBtns.add(new SelectBtn("Bot"));
                break;
            case PRODUCT:
                _titleText.setText("Select Product");
                _manageBtn.setText("Manage Product");
                _selectBtns.add(new SelectBtn("Flight to Wellington"));
                _selectBtns.add(new SelectBtn("Flight to Auckland"));
                _selectBtns.add(new SelectBtn("Auckland Hotel 3 Days"));
                _selectBtns.add(new SelectBtn("Travel Easy Package"));
                break;
            case EMPLOYEE:
                _titleText.setText("Select Employee");
                _manageBtn.setText("Manage Employee");
                _selectBtns.add(new SelectBtn("Aiden"));
                _selectBtns.add(new SelectBtn("Robot"));
                break;
            default:
                _titleText.setText("Select");
                break;
        }
        _scorePane.getChildren().addAll(_selectBtns);
    }

    @FXML
    void handleBack(ActionEvent event) {
        close();
    }

    @FXML
    void handleManage(ActionEvent event) {
        switch (_stateManager.getSelect()) {
            case CUSTOMER:
                _sceneManager.switchScene(Scenes.CUSTOMERS_MENU);
                break;
            case PRODUCT:
                _sceneManager.switchScene(Scenes.PRODUCTS_MENU);
                break;
            case EMPLOYEE:
                _sceneManager.switchScene(Scenes.EMPLOYEES_MENU);
                break;
            default:
                break;
        }
        close();
    }

    @FXML
    void handleSearch(ActionEvent event) {
        close();
    }

    private void close() {
        Stage stage = (Stage) _titleText.getScene().getWindow();
        stage.close();
    }

}
