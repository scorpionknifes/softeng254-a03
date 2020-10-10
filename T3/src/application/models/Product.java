package application.models;

import javafx.beans.property.SimpleStringProperty;

public class Product {
    private SimpleStringProperty name;
    private SimpleStringProperty type;
    private SimpleStringProperty provider;
    private SimpleStringProperty price;

    public Product(String s1, String s2, String s3, String s4) {
        name = new SimpleStringProperty(s1);
        type = new SimpleStringProperty(s2);
        provider = new SimpleStringProperty(s3);
        price = new SimpleStringProperty(s4);
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
