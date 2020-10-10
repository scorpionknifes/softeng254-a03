package application.controllers;

import application.models.Product;
import application.SceneManager;
import application.SceneManager.Scenes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductsMenu {

    private final SceneManager _sceneManager = SceneManager.getInstance();

    @FXML
    private TableView<Product> _tableView;

    @FXML
    private TableColumn<Product, String> _nameColumn;

    @FXML
    private TableColumn<Product, String> _typeColumn;

    @FXML
    private TableColumn<Product, String> _providerColumn;

    @FXML
    private TableColumn<Product, String> _priceColumn;

    public void initialize() {
        _nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        _typeColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("type"));
        _providerColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("provider"));
        _priceColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("price"));

        _tableView.setItems(getProducts());

        _tableView.setRowFactory( tv -> {
            TableRow<Product> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    Product rowData = row.getItem();
                    rowData.handleClick();
                }
            });
            return row ;
        });
    }

    private ObservableList<Product> getProducts() {

        ObservableList<Product> data = FXCollections.observableArrayList();

        data.add(new Product("Example Hotel Deal", "Hotel Deal", "Auckland Hotel", "$400"));
        data.add(new Product("Flight to Auckland", "Flight", "NZ airline", "$900"));
        data.add(new Product("Trip to Auckland", "Travel Deal", "Travel Agency", "$1200"));

        return data;
    }

    @FXML
    void handleAdd(ActionEvent event) {
        _sceneManager.switchScene(Scenes.PRODUCT_SCREEN);
    }

    @FXML
    void handleBack(ActionEvent event) {
        _sceneManager.backScene();
    }

}
