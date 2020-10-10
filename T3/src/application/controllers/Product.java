package application.controllers;

import application.SceneManager;
import application.StateManager;
import application.SceneManager.Scenes;
import application.StateManager.Select;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Product {

    private final SceneManager _sceneManager = SceneManager.getInstance();
    private final StateManager _stateManager = StateManager.getInstance();

    @FXML
    private Label _productTitle;

    @FXML
    private ChoiceBox<String> _typeSelect;

    @FXML
    private GridPane _gridpane;

    @FXML
    private Label _field0;

    @FXML
    private Label _field1;

    @FXML
    private Label _field2;

    public void initialize() {
        _typeSelect.getItems().add("Hotel Deal");
        _typeSelect.getItems().add("Flight");
        _typeSelect.getItems().add("Package Deal");
        _typeSelect.setValue("Hotel Deal");
        _typeSelect.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                clearGrid();
                switch (number2.intValue()) {
                    case 0:
                        hotelDeal();
                        break;
                    case 1:
                        flightDeal();
                        break;
                    case 2:
                        packageDeal();
                        break;
                }
            }
        });
        hotelDeal();
    }

    private void hotelDeal() {
        _field0.setText("Start:");
        _field1.setText("End:");
        _field2.setText("Hotel:");

        _gridpane.add(new TextField(), 1, 2);
        _gridpane.add(new TextField(), 1, 3);
        Button hotelBtn = new Button("Empty");
        hotelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                _stateManager.setSelect(Select.HOTEL);
                _sceneManager.popUp(Scenes.SELECT_SCREEN);
            }
        });
        _gridpane.add(hotelBtn, 1, 4);
    }

    private void flightDeal() {
        _field0.setText("Departure:");
        _field1.setText("Destination:");
        _field2.setText("Airline");
        _gridpane.add(new TextField(), 1, 2);
        _gridpane.add(new TextField(), 1, 3);
        Button flightBtn = new Button("Empty");
        flightBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                _stateManager.setSelect(Select.AIRLINE);
                _sceneManager.popUp(Scenes.SELECT_SCREEN);
            }
        });
        _gridpane.add(flightBtn, 1, 4);
    }

    private void packageDeal() {
        _field0.setText("Hotel Deal:");
        _field1.setText("Flight:");
        _field2.setText("Travel Provider:");
        Button hotelBtn = new Button("Empty");
        hotelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                _stateManager.setSelect(Select.HOTEL);
                _sceneManager.popUp(Scenes.SELECT_SCREEN);
            }
        });
        Button flightBtn = new Button("Empty");
        flightBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                _stateManager.setSelect(Select.AIRLINE);
                _sceneManager.popUp(Scenes.SELECT_SCREEN);
            }
        });
        Button providerBtn = new Button("Empty");
        providerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                _stateManager.setSelect(Select.TRAVEL);
                _sceneManager.popUp(Scenes.SELECT_SCREEN);
            }
        });
        _gridpane.add(hotelBtn, 1, 2);
        _gridpane.add(flightBtn, 1, 3);
        _gridpane.add(providerBtn, 1, 4);
    }

    private void clearGrid() {
        _gridpane.getChildren().removeIf(node -> {
            ;
            if (GridPane.getColumnIndex(node) == null || GridPane.getRowIndex(node) == null) {
                return false;
            }
            if (GridPane.getColumnIndex(node) == 1) {
                if (GridPane.getRowIndex(node) == 2) {
                    return true;
                } else if (GridPane.getRowIndex(node) == 3) {
                    return true;
                } else if (GridPane.getRowIndex(node) == 4) {
                    return true;
                }
            }
            return false;
        });
    }

    @FXML
    void handleBack(ActionEvent event) {
        _sceneManager.backScene();
    }

    @FXML
    void handleSubmit(ActionEvent event) {
        _sceneManager.backScene();
    }

}
