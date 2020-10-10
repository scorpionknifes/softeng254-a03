package application.controllers;

import application.SceneManager;
import application.SceneManager.Scenes;
import application.models.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomersMenu {

    private final SceneManager _sceneManager = SceneManager.getInstance();

    @FXML
    private TableView<Customer> _tableView;

    @FXML
    private TableColumn<Customer, String> _nameColumn;

    @FXML
    private TableColumn<Customer, String> _emailColumn;

    @FXML
    private TableColumn<Customer, String> _addressColumn;

    @FXML
    private TableColumn<Customer, String> _contactNoColumn;

    @FXML
    private TableColumn<Customer, String> _creditCardNoColumn;

    public void initialize() {
        _nameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        _emailColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
        _addressColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
        _contactNoColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("contactNo"));
        _creditCardNoColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("creditNo"));

        _tableView.setItems(getCustomers());
        
        _tableView.setRowFactory( tv -> {
            TableRow<Customer> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    Customer rowData = row.getItem();
                    System.out.println(rowData);
                    rowData.handleClick();
                }
            });
            return row ;
        });
    }

    private ObservableList<Customer> getCustomers() {
 
        ObservableList<Customer> data = FXCollections.observableArrayList();
        
        data.add(new Customer("Human Shopper", "human@email.net", "1 place, Auckland", "112312123", "1111 1111 1111 1111"));
        data.add(new Customer("Human Shopper 2", "human2@email.net", "2 place, Auckland", "132132213", "1111 1111 1111 1111"));
        data.add(new Customer("Robot", "bot@bot.net", "32 place, Auckland", "321123123", "1111 1111 1111 1111"));
 
        return data;
    }

    @FXML
    void handleAdd(ActionEvent event) {
        _sceneManager.switchScene(Scenes.CUSTOMER);
    }

    @FXML
    void handleBack(ActionEvent event) {
        _sceneManager.backScene();
    }

}
