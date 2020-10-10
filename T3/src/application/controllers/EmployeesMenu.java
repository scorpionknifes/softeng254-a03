package application.controllers;

import application.SceneManager;
import application.SceneManager.Scenes;
import application.models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeesMenu {

    private final SceneManager _sceneManager = SceneManager.getInstance();

    @FXML
    private TableView<Employee> _tableView;

    @FXML
    private TableColumn<Employee, String> _nameColumn;

    @FXML
    private TableColumn<Employee, String> _emailColumn;

    @FXML
    private TableColumn<Employee, String> _addressColumn;

    @FXML
    private TableColumn<Employee, String> _contactNoColumn;

    @FXML
    private TableColumn<Employee, String> _irdNoColumn;

    public void initialize() {
        _nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        _emailColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        _addressColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        _contactNoColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("contactNo"));
        _irdNoColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("irdNo"));

        _tableView.setItems(getEmployees());
        _tableView.setRowFactory( tv -> {
            TableRow<Employee> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    Employee rowData = row.getItem();
                    rowData.handleClick();
                }
            });
            return row ;
        });
    }

    private ObservableList<Employee> getEmployees() {
 
        ObservableList<Employee> data = FXCollections.observableArrayList();
        
        data.add(new Employee("Human Shopper", "human@email.net", "1 place, Auckland", "112312123", "111 111 111"));
        data.add(new Employee("Human Shopper 2", "human2@email.net", "2 place, Auckland", "132132213", "111 111 111"));
        data.add(new Employee("Robot", "bot@bot.net", "32 place, Auckland", "321123123", "111 111 111"));
 
        return data;
    }

    @FXML
    void handleAdd(ActionEvent event) {
        _sceneManager.switchScene(Scenes.EMPLOYEE);
    }

    @FXML
    void handleBack(ActionEvent event) {
        _sceneManager.backScene();
    }

}
