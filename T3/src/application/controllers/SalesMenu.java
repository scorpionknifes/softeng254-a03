package application.controllers;

import application.SceneManager;
import application.SceneManager.Scenes;
import application.models.Sale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SalesMenu {

    private final SceneManager _sceneManager = SceneManager.getInstance();

    @FXML
    private TableView<Sale> _tableView;
    @FXML
    private TableColumn<Sale, String> _productColumn;
    @FXML
    private TableColumn<Sale, String> _customerColumn;
    @FXML
    private TableColumn<Sale, String> _priceColumn;
    @FXML
    private TableColumn<Sale, String> _dateColumn;
    @FXML
    private TableColumn<Sale, String> _employeeColumn;
    @FXML
    private TableColumn<Sale, Button> _editColumn;
    @FXML
    private TableColumn<Sale, Button> _deleteColumn;

    public void initialize() {
        _productColumn.setCellValueFactory(new PropertyValueFactory<Sale, String>("product"));
        _customerColumn.setCellValueFactory(new PropertyValueFactory<Sale, String>("customer"));
        _priceColumn.setCellValueFactory(new PropertyValueFactory<Sale, String>("price"));
        _dateColumn.setCellValueFactory(new PropertyValueFactory<Sale, String>("date"));
        _employeeColumn.setCellValueFactory(new PropertyValueFactory<Sale, String>("employee"));
        _editColumn.setCellValueFactory(new PropertyValueFactory<Sale, Button>("edit"));
        _deleteColumn.setCellValueFactory(new PropertyValueFactory<Sale, Button>("delete"));

        _tableView.setItems(getSales());
    }

    private ObservableList<Sale> getSales() {
 
        ObservableList<Sale> data = FXCollections.observableArrayList();
        
        data.add(new Sale("Example Product 1", "Non Human", "$100", "11/10/2020", "Aiden"));
        data.add(new Sale("Example Product 2", "Human", "$100", "11/10/2020", "Aiden"));
        data.add(new Sale("Example Product 3", "Bot", "$100", "11/10/2020", "Aiden"));
 
        return data;
    }

    @FXML
    void handleAdd(ActionEvent event) {
        _sceneManager.switchScene(Scenes.SALE_SCREEN);
    }

    @FXML
    void handleBack(ActionEvent event) {
        _sceneManager.backScene();
    }

}
