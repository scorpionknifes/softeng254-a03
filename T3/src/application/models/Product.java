package application.models;

import java.util.Random;

import application.SceneManager;
import application.SceneManager.Scenes;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    private SimpleStringProperty name;
    private SimpleStringProperty type;
    private SimpleStringProperty provider;
    private SimpleStringProperty price;

    private final SceneManager _sceneManager = SceneManager.getInstance();

    public Product(String s1, String s2, String s3, String s4) {
        name = new SimpleStringProperty(s1);
        type = new SimpleStringProperty(s2);
        provider = new SimpleStringProperty(s3);
        price = new SimpleStringProperty(s4);
    }

    public void handleClick() {
        Random rand = new Random();
        switch (rand.nextInt(3))// default range is from(0 to 14) +1 at the end makes the range from(1 to 15)
        {
            case 0:
                _sceneManager.switchScene(Scenes.HOTEL_DEAL);
                break;
            case 1:
                _sceneManager.switchScene(Scenes.FLIGHT);
                break;
            case 2:
                _sceneManager.switchScene(Scenes.PACKAGE_DEAL);
                break;
        }
    }

    /**
     * @return SimpleStringProperty return the name
     */
    public String getName() {
        return name.get();
    }

    /**
     * @param name the name to set
     */
    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    /**
     * @return SimpleStringProperty return the type
     */
    public String getType() {
        return type.get();
    }

    /**
     * @param type the type to set
     */
    public void setType(SimpleStringProperty type) {
        this.type = type;
    }

    /**
     * @return SimpleStringProperty return the provider
     */
    public String getProvider() {
        return provider.get();
    }

    /**
     * @param provider the provider to set
     */
    public void setProvider(SimpleStringProperty provider) {
        this.provider = provider;
    }

    /**
     * @return SimpleStringProperty return the price
     */
    public String getPrice() {
        return price.get();
    }

    /**
     * @param price the price to set
     */
    public void setPrice(SimpleStringProperty price) {
        this.price = price;
    }

}
