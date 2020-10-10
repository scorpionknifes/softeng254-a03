package application;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class manages javafx stage and scene. This class caches all scenes and
 * stores history of scenes.
 * 
 * @author Cheng-Zhen Yang
 */
public final class SceneManager {

    private static final String PATH = "/application/resources/";
    private static final int DEFAULT_WIDTH = 1200;
    private static final int DEFAULT_HEIGHT = 800;
    private static final int MINIMUM_WIDTH = 600;
    private static final int MINIMUM_HEIGHT = 400;

    private static SceneManager _instance = new SceneManager();

    private Stage _rootStage;
    private Stack<Scenes> _history = new Stack<Scenes>();
    private final Map<Scenes, Scene> _scenes = new HashMap<Scenes, Scene>();

    /** Enum for each scene with a filename and name */
    public enum Scenes {
        /** Home Menu scene */
        MAIN_MENU("MainMenu.fxml"),
        /** Sales Menu scene */
        SALES_MENU("SalesMenu.fxml"),
        /** Sale scene */
        SALE_SCREEN("SaleScreen.fxml"),
        /** Products Menu scene */
        PRODUCTS_MENU("ProductsMenu.fxml"),
        /** Product scene */
        PRODUCT_SCREEN("Product.fxml"),
        /** HotelDeal */
        HOTEL_DEAL("HotelDeal.fxml"),
        /** Flight */
        FLIGHT("Flight.fxml"),
        /** PackageDeal */
        PACKAGE_DEAL("PackageDeal.fxml"),
        /** Customers Menu scene */
        CUSTOMERS_MENU("CustomersMenu.fxml"),
        /** Customer scene */
        CUSTOMER("Customer.fxml"),
        /** Add Hotel scene */
        ADD_HOTEL("AddHotel.fxml"),
        /** Add Provider scene */
        ADD_PROVIDER("AddProvider.fxml"),
        /** Employees Menu scene */
        EMPLOYEES_MENU("EmployeesMenu.fxml"),
        /** Employee scene */
        EMPLOYEE("Employee.fxml"),
        /** Select PopUp scene */
        SELECT_SCREEN("SelectScreen.fxml"),
        ;

        private final String _filename;

        Scenes(final String filename) {
            _filename = filename;
        }
    }

    private SceneManager() {
    }

    /**
     * Used to return the single instance of this class.
     * 
     * @return SceneManager
     */
    public static SceneManager getInstance() {
        return _instance;
    }

    /**
     * Used to init rootStage for single instance of this class.
     * 
     * @param rootStage
     */
    public void init(final Stage rootStage) throws IllegalArgumentException {
        if (rootStage == null) {
            throw new IllegalArgumentException();
        }
        rootStage.setTitle("Aroha Explore");
        rootStage.setWidth(DEFAULT_WIDTH);
        rootStage.setHeight(DEFAULT_HEIGHT);
        rootStage.setMinWidth(MINIMUM_WIDTH);
        rootStage.setMinHeight(MINIMUM_HEIGHT);
        rootStage.show();
        _rootStage = rootStage;
    }

    /**
     * Used to switch current scene to new scene using Scenes enums.
     *
     * @param scene Scenes enum
     * @throws RuntimeException
     */
    public void switchScene(final Scenes scene) throws RuntimeException {
        Scene next = _scenes.computeIfAbsent(scene, k -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(PATH + k._filename));
                return new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        _history.push(scene);
        _rootStage.setScene(next);
    }

    /**
     * Used to create popup
     * 
     * @param scene Scenes enum
     * @throws RuntimeException
     */
    public void popUp(final Scenes scene) throws RuntimeException {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(_rootStage);
        try {
            Parent root = FXMLLoader.load(getClass().getResource(PATH + scene._filename));
            Scene dialogScene = new Scene(root, MINIMUM_WIDTH, MINIMUM_HEIGHT);
            dialog.setScene(dialogScene);
            dialog.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Used to switch back scene by popping current scene from the history
     */
    public void backScene() {
        _history.pop();
        switchScene(_history.pop());
    }

    /**
     * Used to close stage/window
     */
    public void close() {
        _rootStage.close();
    }
}
