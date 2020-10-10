package application.controllers;

import application.SceneManager;
import application.SceneManager.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddHotel {

    @FXML
    private Label _titleText;

    @FXML
    private Button _handleAdd;

    @FXML
    void handleBack(ActionEvent event) {
        close();
    }

    @FXML
    void handleManage(ActionEvent event) {
        close();
    }
    
    private void close() {
        SceneManager.getInstance().popUp(Scenes.SELECT_SCREEN);
        Stage stage = (Stage) _titleText.getScene().getWindow();
        stage.close();
    }

}
