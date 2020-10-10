package application.models;

import application.SceneManager;
import application.SceneManager.Scenes;
import javafx.beans.property.SimpleStringProperty;

public class Customer {
    private SimpleStringProperty name;
    private SimpleStringProperty email;
    private SimpleStringProperty address;
    private SimpleStringProperty contactNo;
    private SimpleStringProperty creditNo;

    private final SceneManager _sceneManager = SceneManager.getInstance();

    public Customer(String s1, String s2, String s3, String s4, String s5) {
        name = new SimpleStringProperty(s1);
        email = new SimpleStringProperty(s2);
        address = new SimpleStringProperty(s3);
        contactNo = new SimpleStringProperty(s4);
        creditNo = new SimpleStringProperty(s5);
    }

    public void handleClick() {
        _sceneManager.switchScene(Scenes.CUSTOMER);
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
     * @return SimpleStringProperty return the email
     */
    public String getEmail() {
        return email.get();
    }

    /**
     * @param email the email to set
     */
    public void setEmail(SimpleStringProperty email) {
        this.email = email;
    }

    /**
     * @return SimpleStringProperty return the address
     */
    public String getAddress() {
        return address.get();
    }

    /**
     * @param address the address to set
     */
    public void setAddress(SimpleStringProperty address) {
        this.address = address;
    }

    /**
     * @return SimpleStringProperty return the contactNo
     */
    public String getContactNo() {
        return contactNo.get();
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(SimpleStringProperty contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * @return SimpleStringProperty return the irdNo
     */
    public String getCreditNo() {
        return creditNo.get();
    }

    /**
     * @param creditNo the irdNo to set
     */
    public void setCreditNo(SimpleStringProperty creditNo) {
        this.creditNo = creditNo;
    }

}
